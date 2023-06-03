package com.argent.vistarecicler

import Dog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        var dogList: ArrayList<Dog> = Datasource(this).getDogList()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val dogAdapter =DogAdapter(dogList)
        recyclerView.adapter=dogAdapter
        recyclerView.layoutManager= LinearLayoutManager(this)

        dogAdapter.onItemClick = {
            val intentDog = Intent(this,DogDetails::class.java)
            //Toast.makeText(this,it.nombre.lowercase(Locale.ROOT), Toast.LENGTH_LONG).show()
//            Toast.makeText(this,"${it.imagen}, Toast.LENGTH_LONG).show()
            //intentDog.putExtra("dogItem",it)
            intentDog.putExtra("dogName",it.nombre)
            intentDog.putExtra("dogPic",it.imagen)
            startActivity(intentDog)
        }

    }
}