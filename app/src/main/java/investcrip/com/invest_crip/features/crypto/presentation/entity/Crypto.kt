package investcrip.com.invest_crip.features.crypto.presentation.entity

import java.math.BigDecimal

data class Crypto(
        val currentPrice: BigDecimal,
        val cryptoName: String,
        val maxPriceDay: BigDecimal,
        val minPriceDay: BigDecimal,
        val urlLogo: String
)