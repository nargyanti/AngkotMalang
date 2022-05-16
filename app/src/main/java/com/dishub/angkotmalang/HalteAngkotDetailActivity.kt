package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.AngkotAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.AngkotModel

class HalteAngkotDetailActivity : AppCompatActivity() {
    private lateinit var rvAngkot : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var angkotList: List<AngkotModel> = ArrayList<AngkotModel>()

    companion object {
        const val EXTRA_ID_HALTE = "extra_id_halte"
        const val EXTRA_NAMA_HALTE = "extra_nama_halte"
        const val EXTRA_LOKASI_HALTE = "extra_lokasi_halte"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halte_detail)

        val tvNamaHalte: TextView = findViewById(R.id.tv_nama_halte)
        val tvLokasiHalte: TextView = findViewById(R.id.tv_lokasi_halte)
        rvAngkot = findViewById(R.id.rv_name_location)
        rvAngkot.setHasFixedSize(true)

        val nama_halte = intent.getStringExtra(EXTRA_NAMA_HALTE)
        val lokasi_halte = intent.getStringExtra(EXTRA_LOKASI_HALTE)

        tvNamaHalte.text = nama_halte
        tvLokasiHalte.text = lokasi_halte

        dbHandler = DatabaseHelper(this)

        supportActionBar?.title = "Halte yang Dilalui Angkot"

        showRecyclerList()
    }

    private fun showRecyclerList() {
        val id_halte:String = intent.getStringExtra(EXTRA_ID_HALTE).toString()
        angkotList = dbHandler!!.getAngkotListByIdHalte(id_halte)
        rvAngkot.layoutManager = LinearLayoutManager(this)
        val angkotAdapter = AngkotAdapter(angkotList)
        rvAngkot.adapter = angkotAdapter
    }
}