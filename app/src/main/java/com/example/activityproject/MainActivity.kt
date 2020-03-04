package com.example.activityproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var nightMode : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("MainActivity", "onCreate")

        savedInstanceState?.let {
            nightMode = savedInstanceState["night_mode"] as Boolean
        }

        if(nightMode)
            content.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_bright))

        siguienteActivity.setOnClickListener {
            val textoIngresado = palabra_ingresada.text.toString()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("palabra_ingresada", textoIngresado)
            startActivity(intent)
        }

        cambiarFondo.setOnClickListener {
            nightMode = true
            content.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_bright))
        }

    }

    /*override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }*/

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("night_mode", nightMode)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy")
    }
}
