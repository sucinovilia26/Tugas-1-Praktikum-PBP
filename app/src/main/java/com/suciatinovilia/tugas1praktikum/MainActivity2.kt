
package com.suciatinovilia.tugas1praktikum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        // Menghubungkan komponen XML
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val img = findViewById<ImageView>(R.id.imgLogo)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        // Menerima data dari MainActivity
        val nama = intent.getStringExtra("NAMA")
        val umur = intent.getIntExtra("UMUR", 0)
        val gambar = intent.getIntExtra("GAMBAR", 0)

        // Menampilkan data peserta
        tvHasil.text = "Halo ${nama ?: ""},\n\n" +
                "Usia Anda $umur tahun.\n\n" +
                "Pendaftaran Pelatihan Desain Grafis Anda berhasil !!"

        // Menampilkan gambar jika tersedia
        if (gambar != 0) {
            img.setImageResource(gambar)
        }

        // Tombol kembali
        btnKembali.setOnClickListener {
            Toast.makeText(
                this,
                "Kembali ke halaman utama",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}
