package investcrip.com.invest_crip.features.crypto.source.remote

import investcrip.com.invest_crip.core.remote.Api
import investcrip.com.invest_crip.features.crypto.source.remote.model.CryptoItemResponse

class CryptoRemoteDataSourceImpl(private val api: Api) : CryptoRemoteDataSource {
    override suspend fun get(): List<CryptoItemResponse> = api.getCryptoList().itemResponses
}