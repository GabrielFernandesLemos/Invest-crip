package investcrip.com.invest_crip.features.crypto.source.remote

import investcrip.com.invest_crip.features.crypto.presentation.entity.Crypto

interface CryptoRepository {
    suspend fun getAll(): List<Crypto>
}