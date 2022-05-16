package com.dishub.angkotmalang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Halte dan Angkot Kota Malang"

        val btn_jalur_angkot: Button = findViewById(R.id.btn_jalur_angkot)
        val btn_halte_angkot: Button = findViewById(R.id.btn_halte_angkot)
        val btn_angkot_halte: Button = findViewById(R.id.btn_angkot_halte)

        btn_jalur_angkot.setOnClickListener(this)
        btn_halte_angkot.setOnClickListener(this)
        btn_angkot_halte.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_jalur_angkot -> {
                val moveIntent = Intent(this@MainActivity, JalurAngkotActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_halte_angkot -> {
                val moveIntent = Intent(this@MainActivity, AngkotHalteActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_angkot_halte -> {
                val moveIntent = Intent(this@MainActivity, HalteAngkotActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}