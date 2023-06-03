package com.argent.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private  lateinit var num : TextView
    var valor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num= findViewById<TextView>(R.id.num)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("val",valor)
        Toast.makeText(applicationContext,"Se guardo $valor",Toast.LENGTH_SHORT).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        valor = savedInstanceState.getInt("val")
        Toast.makeText(applicationContext,"Se recupero $valor",Toast.LENGTH_SHORT).show()
        num.setText(valor.toString())
    }

    fun aumentarNum(view: View){
        valor++
//        Toast.makeText(this,"$valor",Toast.LENGTH_LONG).show()
        num.setText(valor.toString())
    }
}