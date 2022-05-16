package com.dishub.angkotmalang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.R
import com.dishub.angkotmalang.model.AngkotModel

class AngkotAdapter(private val angkotList: List<AngkotModel>) : RecyclerView.Adapter<AngkotAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: AngkotModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvKodeAngkot: TextView = itemView.findViewById(R.id.tv_item_nama)
        var tvNamaTrayek: TextView = itemView.findViewById(R.id.tv_item_lokasi)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_name_location, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val angkot = angkotList[position]
        holder.tvKodeAngkot.text = angkot.kode_angkot
        holder.tvNamaTrayek.text = angkot.nama_trayek
    }

    override fun getItemCount(): Int {
        return angkotList.size
    }
}