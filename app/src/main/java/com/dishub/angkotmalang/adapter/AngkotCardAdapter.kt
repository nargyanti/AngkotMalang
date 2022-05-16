package com.dishub.angkotmalang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.AngkotHalteDetailActivity
import com.dishub.angkotmalang.R
import com.dishub.angkotmalang.model.AngkotModel

class AngkotCardAdapter (private val angkotList: List<AngkotModel>) : RecyclerView.Adapter<AngkotCardAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: AngkotModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvKodeAngkot: TextView = itemView.findViewById(R.id.tv_item_kode_angkot)
        var tvNamaTrayek: TextView = itemView.findViewById(R.id.tv_item_nama_trayek)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_angkot_card, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return angkotList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val angkot = angkotList[position]
        holder.tvKodeAngkot.text = angkot.kode_angkot
        holder.tvNamaTrayek.text = angkot.nama_trayek

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val moveToDetailIntent = Intent(context, AngkotHalteDetailActivity::class.java)
            moveToDetailIntent.putExtra(AngkotHalteDetailActivity.EXTRA_ID_ANGKOT, angkot.id_angkot)
            moveToDetailIntent.putExtra(AngkotHalteDetailActivity.EXTRA_KODE_ANGKOT, angkot.kode_angkot)
            moveToDetailIntent.putExtra(AngkotHalteDetailActivity.EXTRA_NAMA_TRAYEK, angkot.nama_trayek)
            context.startActivity(moveToDetailIntent)
        }
    }
}