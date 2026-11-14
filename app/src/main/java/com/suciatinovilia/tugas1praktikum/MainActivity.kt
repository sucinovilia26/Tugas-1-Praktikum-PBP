package com.suciatinovilia.tugas1praktikum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnInfo = findViewById<Button>(R.id.btnInfo)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageText = etAge.text.toString().trim()

            if (name.isEmpty() || ageText.isEmpty()) {
                if (name.isEmpty()) {
                    etName.error = "Nama tidak boleh kosong"
                }

                if (ageText.isEmpty()) {
                    etAge.error = "Umur tidak boleh kosong"
                }

                Toast.makeText(this, "Nama dan umur wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val age = ageText.toIntOrNull()

            if (age == null || age < 0) {
                etAge.error = "Umur harus berupa angka dan tidak boleh minus"
                Toast.makeText(this, "Masukkan umur yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("NAMA", name)
            intent.putExtra("UMUR", age)
            startActivity(intent)
        }

        btnInfo.setOnClickListener {
            val query = "https://www.instagram.com/fhdigital.solutions?mdxt=MW9ubzJsMnhpeWh4aA=="
            val intent = Intent(Intent.ACTION_VIEW, query.toUri())
            startActivity(intent)
        }

    }
}
