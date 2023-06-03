package com.argent.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity(), OnFragmentActionListener {
    private lateinit var b1: Button
    private  lateinit var b2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        b1=findViewById(R.id.botonuno) as Button
        b2=findViewById(R.id.botondos) as Button
        b1.setOnClickListener{loadFragment(Frag1())}
        b2.setOnClickListener { replaceFragment(Frag2()) }
    }

    private fun replaceFragment(frag: Fragment) {
        val fragTrans= supportFragmentManager.beginTransaction()
        fragTrans.replace(R.id.fragcontainer,frag)
        fragTrans.addToBackStack(null)
        fragTrans.commit()
    }

    private fun loadFragment(frag: Fragment) {
        val fragTrans= supportFragmentManager.beginTransaction()
        fragTrans.add(R.id.fragcontainer,frag)
        fragTrans.addToBackStack(null)
        fragTrans.commit()
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this,"Click Boton",Toast.LENGTH_SHORT).show()
    }

}