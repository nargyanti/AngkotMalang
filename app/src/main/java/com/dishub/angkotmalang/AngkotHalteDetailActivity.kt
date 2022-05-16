package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.HalteAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.HalteModel

class AngkotHalteDetailActivity : AppCompatActivity() {
    private lateinit var rvHalte : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var halteList: List<HalteModel> = ArrayList<HalteModel>()

    companion object {
        const val EXTRA_ID_ANGKOT = "extra_id_angkot"
        const val EXTRA_KODE_ANGKOT = "extra_kode_angkot"
        const val EXTRA_NAMA_TRAYEK = "extra_nama_trayek"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halte_angkot_detail)

        val tvKodeAngkot: TextView = findViewById(R.id.tv_kode_angkot)
        val tvNamaTrayek: TextView = findViewById(R.id.tv_nama_trayek)
        rvHalte = findViewById(R.id.rv_name_location)
        rvHalte.setHasFixedSize(true)

        val kode_angkot = intent.getStringExtra(EXTRA_KODE_ANGKOT)
        val nama_trayek = intent.getStringExtra(EXTRA_NAMA_TRAYEK)

        tvKodeAngkot.text = kode_angkot
        tvNamaTrayek.text = nama_trayek

        supportActionBar?.title = "Angkot yang Melewati Halte"

        dbHandler = DatabaseHelper(this)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        val id_angkot:String = intent.getStringExtra(EXTRA_ID_ANGKOT).toString()
        halteList = dbHandler!!.getHalteListByIdAngkot(id_angkot)
        rvHalte.layoutManager = LinearLayoutManager(this)
        val halteAdapter = HalteAdapter(halteList)
        rvHalte.adapter = halteAdapter
    }
}