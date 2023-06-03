package com.argent.tarea1contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    var contador=0
    lateinit var texto:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto= findViewById<TextView>(R.id.textView) as TextView
    }

    //Salvar el estado de la activity
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
        Toast.makeText(applicationContext,"Se guardo el valor $contador",Toast.LENGTH_LONG).show()
    }

    //Recuperar el estado de la activity
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("contador")
        Toast.makeText(applicationContext,"Se ha recuperado el valor $contador",Toast.LENGTH_LONG).show()
    }

    // Aumentar el contador al hacer click
    fun aumentar(view: View){
        contador++
        texto.text= contador.toString()
    }

}