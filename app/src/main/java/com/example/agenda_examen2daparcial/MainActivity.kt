package com.example.agenda_examen2daparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agenda_examen2daparcial.Agenda
import com.example.agenda_examen2daparcial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val agendaList = ArrayList<Agenda>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAgregar.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val noControl = binding.editTextNoControl.text.toString()

            if (name.isNotBlank() && noControl.isNotBlank()) {
                agendaList.add(Agenda(name, noControl))
                binding.editTextName.text.clear()
                binding.editTextNoControl.text.clear()
                binding.textViewContactCount.text = "Contactos Agregados: ${agendaList.size}"
                Toast.makeText(this, "Contacto agregado con éxito", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Campos Vacios, intenta de Nuevo", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVerAgenda.setOnClickListener {
            val noControl = binding.editTextBuscarNoControl.text.toString()
            val contact = agendaList.find { it.nocontrol == noControl }

            if (contact != null) {
                val intent = Intent(this, MainActivityDetalles::class.java)
                intent.putExtra("contactName", contact.nombre)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Ingresa un No.Control valido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
