package com.Sena.konstruapp

import android.text.format.DateFormat
import java.util.Calendar
import java.util.Locale

object Constantes {

    const val anuncio_disponible = "Disponible"
    const val anuncio_vendido = "Vendido"

    val categorias = arrayOf(
        "Ferreteria",
        "Construccion",
        "Pisos",
        "Pinturas",

    )
    val condiciones = arrayOf(
        "Nuevo",
        "Usado"
    )



    fun obtenerTiempoDis(): Long{
        return System.currentTimeMillis()
    }
    fun obtenerFecha(tiempo : Long) : String{
        val calendario = Calendar.getInstance(Locale.ENGLISH)
        calendario.timeInMillis = tiempo

        return DateFormat.format("dd/MM/yyyy", calendario).toString()
    }

}