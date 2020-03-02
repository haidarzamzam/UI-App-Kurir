package com.haidev.androididn.main2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.haidev.androididn.R
import com.haidev.androididn.main.models.MainModel
import kotlinx.android.synthetic.main.item_list_packet_horizontal.view.*

class ItemMain2Adapter(private val listMain: ArrayList<MainModel>) :
    RecyclerView.Adapter<ItemMain2Adapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(main: MainModel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(main.image)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
                    .into(ivMain)
                tvName.text = main.name
                tvAddress.text = main.address
                tvReceipt.text = main.receipt

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(main) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MainModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_packet_horizontal, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMain.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMain[position])
    }
}