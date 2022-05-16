package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.HalteCardAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.HalteModel

class HalteAngkotActivity : AppCompatActivity() {
    private lateinit var rvHalte : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var halteList: List<HalteModel> = ArrayList<HalteModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halte)

        rvHalte = findViewById(R.id.rv_halte)
        rvHalte.setHasFixedSize(true)

        dbHandler = DatabaseHelper(this)

        supportActionBar?.title = "Angkot yang Melewati Halte"

        showRecyclerList()
    }

    private fun showRecyclerList() {
        halteList = dbHandler!!.getAllHalte()
        rvHalte.layoutManager = LinearLayoutManager(this)
        val halteAdapter = HalteCardAdapter(halteList)
        rvHalte.adapter = halteAdapter
    }

}