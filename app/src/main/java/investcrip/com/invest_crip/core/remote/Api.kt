package investcrip.com.invest_crip.core.remote

import investcrip.com.invest_crip.features.crypto.source.remote.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @JvmDefault
    @GET("/coins/markets")
    suspend fun getCryptoList(
            @Query("vs_currency") currency: String = "BRL",
            @Query("order") order: String = "market_cap_desc",
            @Query("per_page") perPage: String = "100",
            @Query("page") page: String = "1",
            @Query("sparkline") sparkLine: Boolean = false,
    ): CryptoResponse
}