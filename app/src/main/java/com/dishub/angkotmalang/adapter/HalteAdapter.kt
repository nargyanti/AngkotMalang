package com.dishub.angkotmalang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.R
import com.dishub.angkotmalang.model.HalteModel

class HalteAdapter(private val halteList: List<HalteModel>) : RecyclerView.Adapter<HalteAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: HalteModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaHalte: TextView = itemView.findViewById(R.id.tv_item_nama)
        var tvLokasiHalte: TextView = itemView.findViewById(R.id.tv_item_lokasi)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_name_location, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val halte = halteList[position]
        holder.tvNamaHalte.text = halte.nama_halte
        holder.tvLokasiHalte.text = halte.lokasi_halte
    }

    override fun getItemCount(): Int {
        return halteList.size
    }



}