package com.Sena.konstruapp.Adaptadores

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.Sena.konstruapp.Modelo.ModeloImageSeleccionada
import com.Sena.konstruapp.R
import com.Sena.konstruapp.databinding.ItemImagenesSeleccionadasBinding
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage


class AdaptadorImagenSeleccionada(
    private val context : Context,
    private val imagenesSelecArrayList : ArrayList<ModeloImageSeleccionada>,
    //private val idAnuncio : String
): Adapter<AdaptadorImagenSeleccionada.HolderImagenSeleccionada>(){

    private lateinit var binding : ItemImagenesSeleccionadasBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderImagenSeleccionada {
        binding = ItemImagenesSeleccionadasBinding.inflate(LayoutInflater.from(context),parent,false)
        return HolderImagenSeleccionada(binding.root)
    }

    override fun getItemCount(): Int {
        return imagenesSelecArrayList.size
    }

    override fun onBindViewHolder(holder: HolderImagenSeleccionada, position: Int) {
        val modelo = imagenesSelecArrayList[position]
        val imagenUri = modelo.imagenUri

            try {
                //val imagenUri = modelo.imagenUri
                Glide.with(context)
                    .load(imagenUri)
                    .placeholder(R.drawable.item_imagen)
                    .into(holder.item_imagen)
            }catch (e:Exception){

            }




        holder.btn_cerrar.setOnClickListener {

                imagenesSelecArrayList.remove(modelo)
                notifyDataSetChanged()
            }


    }



    inner class HolderImagenSeleccionada(itemView : View) : ViewHolder(itemView){
        var item_imagen = binding.itemImagen
        var btn_cerrar = binding.cerrarItem
    }


}