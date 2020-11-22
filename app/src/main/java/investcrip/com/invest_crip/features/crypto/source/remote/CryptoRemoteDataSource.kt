package investcrip.com.invest_crip.features.crypto.source.remote

import investcrip.com.invest_crip.features.crypto.source.remote.model.CryptoItemResponse

interface CryptoRemoteDataSource {
    suspend fun get(): List<CryptoItemResponse>
}