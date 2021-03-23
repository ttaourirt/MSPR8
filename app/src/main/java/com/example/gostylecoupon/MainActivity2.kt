package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var BonPlan : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation
        BonPlan = findViewById(R.id.bouton2)

        // creation de notre intent
        val monIntent : Intent =  Intent(this,MainActivity3::class.java)

        //clic sur le bouton
        BonPlan.setOnClickListener {
            startActivity(monIntent)
        }
    }
}