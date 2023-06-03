  package com.argent.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

  class MainActivity : AppCompatActivity(),OnFragmentActionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
    }
}