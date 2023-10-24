package com.example.agenda_examen2daparcial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda_examen2daparcial.databinding.ActivityMainDetallesBinding


class MainActivityDetalles : AppCompatActivity() {
    private lateinit var binding: ActivityMainDetallesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDetallesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val contactName = intent.getStringExtra("contactName")
        binding.textViewContactName.text = contactName

        binding.btnSalir.setOnClickListener {
            finish()
        }
    }
}


