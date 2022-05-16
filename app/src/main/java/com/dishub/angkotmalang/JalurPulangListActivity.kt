package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.JalurAngkotAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.JalurAngkotModel

class JalurPulangListActivity : AppCompatActivity() {
    private lateinit var rvJalurPulang : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var jalurListPulang: List<JalurAngkotModel> = ArrayList<JalurAngkotModel>()

    companion object {
        const val EXTRA_ID_ANGKOT = "extra_id_angkot"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jalur_pulang_list)

        rvJalurPulang = findViewById(R.id.rv_jalur_pulang)
        rvJalurPulang.setHasFixedSize(true)

        dbHandler = DatabaseHelper(this)

        supportActionBar?.title = "Jalur Trayek Angkot"

        showRecyclerList()

    }

    private fun showRecyclerList() {
        val id_angkot:String = intent.getStringExtra(EXTRA_ID_ANGKOT).toString()
        jalurListPulang = dbHandler!!.getJalurListByAngkotId(id_angkot, "pulang")
        rvJalurPulang.layoutManager = LinearLayoutManager(this)
        val jalurPulangAdapter = JalurAngkotAdapter(jalurListPulang)
        rvJalurPulang.adapter = jalurPulangAdapter
    }
}