package com.argent.multiplicador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*

class MainActivity : AppCompatActivity() {
        private  lateinit var txtN1 : TextView
        private lateinit var txtN2 : TextView
        private  lateinit var txtAcierto : TextView
        private  lateinit var txtAcierto2 : TextView
        private lateinit var txtLine : EditText
        var numero1: Int = 1
        var numero2: Int = 1
        var acertados: Int = 0
        var fallados: Int = 0
        var respuesta: Int? = 0

        private val respuestaActivity = registerForActivityResult(StartActivityForResult()){
                respuesta ->
            if (respuesta.resultCode== RESULT_OK){
                val correcto = respuesta.data?.getBooleanExtra("correcto",false)
                //Toast.makeText(this,correcto.toString(), Toast.LENGTH_LONG).show()
                if(correcto==true)acertados++
                else    fallados++
                numerosRandom()
                setTextoPantalla()
            }else{
                //Toast.makeText(this,"No hay resultado", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        txtN1= findViewById<TextView>(R.id.num1TV)
        txtN2= findViewById<TextView>(R.id.num2TV)
        txtAcierto= findViewById<TextView>(R.id.aciertos)
        txtAcierto2= findViewById<TextView>(R.id.aciertos2)
        txtLine= findViewById(R.id.NUMres)
        numerosRandom()
        setTextoPantalla()
    }

    fun setTextoPantalla(){
        txtN1.setText(numero1.toString())
        txtN2.setText(numero2.toString())
        txtAcierto.setText("Aciertos: $acertados")
        txtAcierto2.setText("Fallados: $fallados")
        txtLine.setText("0")
    }

    fun numerosRandom(){
        numero1=(1..15).random();
        numero2=(1..15).random();
    }

    fun cambiarPantalla(view: View){
            respuesta= txtLine.text?.toString()?.toInt()
        if(respuesta!=null) {
            Log.d("res2",respuesta.toString())
            val intent = Intent(this, SumaActivity::class.java)
            intent.putExtra("num1", numero1)
            intent.putExtra("num2", numero2)
            intent.putExtra("res", respuesta)
            respuestaActivity.launch(intent)
        }
    }
}