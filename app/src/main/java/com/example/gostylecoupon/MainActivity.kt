package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var Connexion : Button
    lateinit var Inscription : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation
        Connexion = findViewById(R.id.bouton1)

        // creation de notre intent
        val monIntent = Intent(this, LoginActivity::class.java)

        //clic sur le bouton
        Connexion.setOnClickListener {
            startActivity(monIntent)
        }

        //initialisation
        Inscription = findViewById(R.id.bouton)

        // creation de notre intent
//        val monIntent2 : Intent = new Intent(MainActivity.this; RegisterActivity.class)

        //clic sur le bouton
        Inscription.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}