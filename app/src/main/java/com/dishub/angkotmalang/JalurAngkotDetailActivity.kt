package com.dishub.angkotmalang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dishub.angkotmalang.adapter.JalurAngkotAdapter
import com.dishub.angkotmalang.database.DatabaseHelper
import com.dishub.angkotmalang.model.JalurAngkotModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class JalurAngkotDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_ANGKOT = "extra_id_angkot"
        const val EXTRA_KODE_ANGKOT = "extra_kode_angkot"
        const val EXTRA_NAMA_TRAYEK = "extra_nama_trayek"
        const val EXTRA_BERANGKAT = "extra_berangkat"
        const val EXTRA_TUJUAN = "extra_tujuan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jalur_angkot_detail)

        val tvKodeAngkot: TextView = findViewById(R.id.tv_kode_angkot)
        val tvNamaTrayek: TextView = findViewById(R.id.tv_nama_trayek)
        val tvBerangkat: TextView = findViewById(R.id.tv_berangkat)
        val tvTujuan: TextView = findViewById(R.id.tv_tujuan)

        val btnPergi: Button = findViewById(R.id.btn_jalur_pergi)
        val btnPulang: Button = findViewById(R.id.btn_jalur_pulang)

        val id_angkot = intent.getStringExtra(EXTRA_ID_ANGKOT)
        val kode_angkot = intent.getStringExtra(EXTRA_KODE_ANGKOT)
        val nama_trayek = intent.getStringExtra(EXTRA_NAMA_TRAYEK)
        val berangkat = intent.getStringExtra(EXTRA_BERANGKAT)
        val tujuan = intent.getStringExtra(EXTRA_TUJUAN)

        tvKodeAngkot.text = kode_angkot
        tvNamaTrayek.text = nama_trayek
        tvBerangkat.text = "Dari $berangkat"
        tvTujuan.text = "Ke $tujuan"

        supportActionBar?.title = "Jalur Trayek Angkot"

        btnPergi.setOnClickListener{
            val moveToDetailIntent = Intent(this@JalurAngkotDetailActivity, JalurPergiListActivity::class.java)
            moveToDetailIntent.putExtra(AngkotHalteDetailActivity.EXTRA_ID_ANGKOT, id_angkot)
            startActivity(moveToDetailIntent)
        }

        btnPulang.setOnClickListener{
            val moveToDetailIntent = Intent(this@JalurAngkotDetailActivity, JalurPulangListActivity::class.java)
            moveToDetailIntent.putExtra(AngkotHalteDetailActivity.EXTRA_ID_ANGKOT, id_angkot)
            startActivity(moveToDetailIntent)
        }
    }
}