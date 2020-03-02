package com.haidev.androididn.activitymain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.haidev.androididn.R
import com.haidev.androididn.activitymain.models.MainModel
import kotlinx.android.synthetic.main.item_list_packet_vertical.view.*

class ItemMainAdapter(private val listMain: ArrayList<MainModel>) :
    RecyclerView.Adapter<ItemMainAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(main: MainModel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(main.image)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
                    .into(ivMain)
                tvNumber.text = main.num
                tvName.text = main.name
                tvAddress.text = main.address
                tvReceipt.text = main.receipt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_packet_vertical, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMain.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMain[position])
    }
}