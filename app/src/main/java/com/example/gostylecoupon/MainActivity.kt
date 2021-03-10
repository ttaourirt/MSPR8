package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var boutonChanger : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation
        boutonChanger = findViewById(R.id.bouton1)

        // creation de notre intent
        val monIntent : Intent =  Intent(this,MainActivity2::class.java)

        //clic sur le bouton
        boutonChanger.setOnClickListener {
            startActivity(monIntent)
        }
    }
}