package com.argent.vistarecicler

import Dog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class DogDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_dog_details)
        val nombre: TextView= findViewById(R.id.nameDog)
        val foto: ImageView=findViewById(R.id.imageDog)
        val pNom=intent.getStringExtra("dogName")
        val pPic=intent.getIntExtra("dogPic",0)
        //val perro= intent.getParcelableExtra<Dog>("dogItem") as? Dog
//        if(perro!=null){
//            nombre.setText(perro.nombre)
////            foto.setImageResource(perro.imagen)
//        }
        if (pNom!=null && pPic!=null){
            nombre.setText(pNom)
            foto.setImageResource(pPic)
        }
    }

    fun cerrar(view: View){
        finish()
    }
}