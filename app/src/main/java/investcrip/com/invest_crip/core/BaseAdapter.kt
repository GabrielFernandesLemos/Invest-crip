package investcrip.com.invest_crip.core

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(callback: DiffUtil.ItemCallback<T>)
    : ListAdapter<T, VH>(callback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindData(getItem(position))
    }
}

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(item: T?)
}