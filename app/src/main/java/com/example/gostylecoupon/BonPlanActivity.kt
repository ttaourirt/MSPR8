package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BonPlanActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var BonPlan : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //initialisation
        BonPlan = findViewById(R.id.bouton2)

        // creation de notre intent
//        val monIntent : Intent =  Intent(this,MainActivity3::class.java)

//        //clic sur le bouton
//        BonPlan.setOnClickListener {
//            startActivity(monIntent)
//        }
    }
}