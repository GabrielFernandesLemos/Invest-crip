package investcrip.com.invest_crip.features.crypto.source.remote

import investcrip.com.invest_crip.features.crypto.presentation.entity.Crypto
import java.math.BigDecimal

class CryptoRepositoryImpl(
        private val dataSource: CryptoRemoteDataSource
) : CryptoRepository {
    override suspend fun getAll(): List<Crypto> =
            dataSource.get()
                    .map { response ->
                        Crypto(
                                currentPrice = BigDecimal(response.currentPrice.orZero()),
                                cryptoName = response.name.orEmpty(),
                                maxPriceDay = BigDecimal(response.high24h.orZero()),
                                minPriceDay = BigDecimal(response.low24h.orZero()),
                                urlLogo = response.image.orEmpty()
                        )
                    }

    private fun String?.orZero() = this ?: "0"
}

