package investcrip.com.invest_crip.features.crypto.presentation.entity

data class Crypto(
        val currentPrice: String,
        val cryptoName: String,
        val maxPriceDay: String,
        val minPriceDay: String,
        val urlLogo: String
)