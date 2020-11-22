package investcrip.com.invest_crip.features.crypto.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import coil.load
import investcrip.com.invest_crip.R
import investcrip.com.invest_crip.core.BaseAdapter
import investcrip.com.invest_crip.core.BaseViewHolder
import investcrip.com.invest_crip.features.crypto.presentation.entity.Crypto
import java.text.NumberFormat
import java.util.*

class CryptoListAdapter : BaseAdapter<Crypto, CryptoViewHolder>(CryptoDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false))
    }
}

class CryptoViewHolder(
        itemView: View
) : BaseViewHolder<Crypto>(itemView) {
    private val name: TextView = itemView.findViewById(R.id.cryptoName)
    private val highPrice: TextView = itemView.findViewById(R.id.cryptoMax)
    private val lowPrice: TextView = itemView.findViewById(R.id.cryptoMin)
    private val image: ImageView = itemView.findViewById(R.id.cryptoImage)
    private val currentPrice: TextView = itemView.findViewById(R.id.cryptoBalance)
    private val numberFormat: NumberFormat =
            NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
                    .apply { maximumFractionDigits = 2 }

    override fun bindData(item: Crypto) {
        name.text = item.cryptoName
        highPrice.text = numberFormat.format(item.maxPriceDay)
        lowPrice.text = numberFormat.format(item.minPriceDay)
        image.load(item.urlLogo)
        currentPrice.text = numberFormat.format(item.currentPrice)
    }
}

class CryptoDiff : DiffUtil.ItemCallback<Crypto>() {
    override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean = newItem.cryptoName == newItem.cryptoName
    override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean = oldItem == newItem
}
