package com.Sena.konstruapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Sena.konstruapp.databinding.ActivityCrearAnuncioBinding
import com.Sena.konstruapp.databinding.ActivitySeleccionarUbicacionBinding

class SeleccionarUbicacion : AppCompatActivity() {
    private lateinit var binding : ActivitySeleccionarUbicacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeleccionarUbicacionBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}