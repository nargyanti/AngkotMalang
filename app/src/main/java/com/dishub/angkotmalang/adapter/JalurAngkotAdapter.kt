package com.dishub.angkotmalang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.R
import com.dishub.angkotmalang.model.HalteModel
import com.dishub.angkotmalang.model.JalurAngkotModel

class JalurAngkotAdapter (private val jalurList: List<JalurAngkotModel>) : RecyclerView.Adapter<JalurAngkotAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: HalteModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUrutanJalur: TextView = itemView.findViewById(R.id.tv_urutan_jalur)
        var tvNamajalur: TextView = itemView.findViewById(R.id.tv_nama_jalur)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_jalur, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val jalur = jalurList[position]
        holder.tvUrutanJalur.text = jalur.urutan_jalur.toString() + "."
        holder.tvNamajalur.text = jalur.nama_jalur
    }

    override fun getItemCount(): Int {
        return jalurList.size
    }
}