package com.dishub.angkotmalang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dishub.angkotmalang.adapter.JalurAngkotAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.JalurAngkotModel

class JalurPergiListActivity : AppCompatActivity() {
    private lateinit var rvJalurPergi : RecyclerView
    private var dbHandler : DatabaseHelper?= null
    private var jalurListPergi: List<JalurAngkotModel> = ArrayList<JalurAngkotModel>()

    companion object {
        const val EXTRA_ID_ANGKOT = "extra_id_angkot"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jalur_pergi_list)

        rvJalurPergi = findViewById(R.id.rv_jalur_pergi)
        rvJalurPergi.setHasFixedSize(true)

        dbHandler = DatabaseHelper(this)

        supportActionBar?.title = "Jalur Trayek Angkot"

        showRecyclerList()

    }

    private fun showRecyclerList() {
        val id_angkot:String = intent.getStringExtra(EXTRA_ID_ANGKOT).toString()
        jalurListPergi = dbHandler!!.getJalurListByAngkotId(id_angkot, "pergi")
        rvJalurPergi.layoutManager = LinearLayoutManager(this)
        val jalurPergiAdapter = JalurAngkotAdapter(jalurListPergi)
        rvJalurPergi.adapter = jalurPergiAdapter
    }
}