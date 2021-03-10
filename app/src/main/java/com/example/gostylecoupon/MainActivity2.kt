package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var Retour : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation
        Retour = findViewById(R.id.bouton)

        // creation de notre intent
        val monIntent : Intent =  Intent(this,MainActivity::class.java)

        //clic sur le bouton
        Retour.setOnClickListener {
            startActivity(monIntent)
        }
    }
}