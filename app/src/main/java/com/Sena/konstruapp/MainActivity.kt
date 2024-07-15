package com.Sena.konstruapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Sena.konstruapp.Anuncios.CrearAnuncio
import com.Sena.konstruapp.Fragmentos.FragmentChats
import com.Sena.konstruapp.Fragmentos.FragmentCuenta
import com.Sena.konstruapp.Fragmentos.FragmentInicio
import com.Sena.konstruapp.Fragmentos.FragmentMisAnuncios
import com.Sena.konstruapp.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        comprobarSesion()
        verFragmentInicio()
        binding.BottomNV.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.Item_Inicio->{
                    verFragmentInicio()
                    true
                }
                R.id.Item_Chats->{
                    verFragmentChats()
                    true
                }
                R.id.Item_Mis_Anuncios->{
                    verFragmentMisAnuncios()
                    true
                }
                R.id.Item_Cuenta->{
                    verFragmentCuenta()
                    true
                }
                else->{
                    false
                }
            }

        }
        binding.FAB.setOnClickListener {
            startActivity(Intent(this, CrearAnuncio::class.java))
            /*val intent = Intent(this, CrearAnuncio::class.java)
            intent.putExtra("Edicion", false)
            startActivity(intent)*/
        }

    }
    private fun comprobarSesion(){
        if (firebaseAuth.currentUser == null){
            startActivity(Intent(this, OpcionesLogin::class.java))
            finishAffinity()
        }
    }

    private fun verFragmentInicio(){
        binding.TituloRl.text= "Inicio"
        val fragment = FragmentInicio()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentInicio")
        fragmentTransition.commit()
    }
    private fun verFragmentChats(){
        binding.TituloRl.text= "Chats"
        val fragment = FragmentChats()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentChats")
        fragmentTransition.commit()
    }
    private fun verFragmentMisAnuncios(){
        binding.TituloRl.text= "Anuncios"
        val fragment = FragmentMisAnuncios()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentMisAnuncios")
        fragmentTransition.commit()
    }
    private fun verFragmentCuenta(){
        binding.TituloRl.text= "Cuenta"
        val fragment = FragmentCuenta()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentCuenta")
        fragmentTransition.commit()
    }

}