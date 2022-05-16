package com.dishub.angkotmalang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.HalteAngkotDetailActivity
import com.dishub.angkotmalang.R
import com.dishub.angkotmalang.model.HalteModel

class HalteCardAdapter(private val halteList: List<HalteModel>) : RecyclerView.Adapter<HalteCardAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: HalteModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaHalte: TextView = itemView.findViewById(R.id.tv_item_nama_halte)
        var tvLokasiHalte: TextView = itemView.findViewById(R.id.tv_item_lokasi_halte)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_halte_card, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val halte = halteList[position]
        holder.tvNamaHalte.text = halte.nama_halte
        holder.tvLokasiHalte.text = halte.lokasi_halte

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val moveToDetailIntent = Intent(context, HalteAngkotDetailActivity::class.java)
            moveToDetailIntent.putExtra(HalteAngkotDetailActivity.EXTRA_ID_HALTE, halte.id_halte)
            moveToDetailIntent.putExtra(HalteAngkotDetailActivity.EXTRA_NAMA_HALTE, halte.nama_halte)
            moveToDetailIntent.putExtra(HalteAngkotDetailActivity.EXTRA_LOKASI_HALTE, halte.lokasi_halte)
            context.startActivity(moveToDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return halteList.size
    }



}