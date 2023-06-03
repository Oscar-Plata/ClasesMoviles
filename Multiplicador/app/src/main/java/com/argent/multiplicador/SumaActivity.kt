package com.argent.multiplicador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView

class SumaActivity : AppCompatActivity() {
    var correcto: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_suma)
        var txtRes=findViewById<TextView>(R.id.NumRespuesta)
        var txtAnu=findViewById<TextView>(R.id.Anuncio)
        var res =intent.getIntExtra("res",0)
        var num1=intent.getIntExtra("num1",0)
        var num2=intent.getIntExtra("num2",0)
        var mult=num1*num2
        correcto = mult==res
        txtRes.setText(mult.toString())
        if(correcto) txtAnu.setText("Has acertado !")
        else txtAnu.setText("Has Fallado!")
    }

    fun regresar(view: View){
        val intent=Intent()
        intent.putExtra("correcto",correcto)
        setResult(RESULT_OK,intent)
        finish()
    }
}