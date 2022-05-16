package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.JalurAngkotCardAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.AngkotModel

class JalurAngkotActivity : AppCompatActivity() {
    private lateinit var rvAngkot : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var angkotList: List<AngkotModel> = ArrayList<AngkotModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halte_angkot)

        rvAngkot = findViewById(R.id.rv_angkot_card)
        rvAngkot.setHasFixedSize(true)

        dbHandler = DatabaseHelper(this)

        supportActionBar?.title = "Jalur Trayek Angkot"
        showRecyclerList()
    }

    private fun showRecyclerList() {
        angkotList = dbHandler!!.getAllAngkot()
        rvAngkot.layoutManager = LinearLayoutManager(this)
        val angkotAdapter = JalurAngkotCardAdapter(angkotList)
        rvAngkot.adapter = angkotAdapter
    }
}