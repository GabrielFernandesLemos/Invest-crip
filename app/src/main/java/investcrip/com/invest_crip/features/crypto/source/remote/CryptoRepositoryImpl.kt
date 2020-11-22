package investcrip.com.invest_crip.features.crypto.source.remote

import investcrip.com.invest_crip.features.crypto.presentation.entity.Crypto

class CryptoRepositoryImpl(
        private val dataSource: CryptoRemoteDataSource
) : CryptoRepository {
    override suspend fun getAll(): List<Crypto> =
            dataSource.get()
                    .map { response ->
                        Crypto(
                                currentPrice = response.currentPrice.orZero(),
                                cryptoName = response.name.orEmpty(),
                                maxPriceDay = response.high24h.orZero(),
                                minPriceDay = response.low24h.orZero(),
                                urlLogo = response.image.orEmpty()
                        )
                    }

    private fun String?.orZero() = this ?: "0"
}

