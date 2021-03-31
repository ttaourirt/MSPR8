package com.example.gostylecoupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@LoginActivity

    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var cardView2: CardView
    private lateinit var textInput5 : TextInputLayout
    private lateinit var textInput6 : TextInputEditText
    private lateinit var textInput1 : TextInputLayout
    private lateinit var textInput2: TextInputEditText
    private lateinit var textInput3: TextInputLayout
    private lateinit var textInput4: TextInputEditText

    private lateinit var inputValidation: InputValidation
    private lateinit var databaseActivity: DatabaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()

        initListeners()

        initObjects()

        btnRegLogin.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
        }
    }

    private fun initViews() {
        constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout
        textInput1 = findViewById(R.id.textInput1) as TextInputLayout
        textInput3 = findViewById(R.id.textInput3) as TextInputLayout
        textInput5 = findViewById(R.id.textInput5) as TextInputLayout
        textInput2 = findViewById(R.id.textInput2) as TextInputEditText
        textInput4 = findViewById(R.id.textInput4) as TextInputEditText
        textInput6 = findViewById(R.id.textInput6) as TextInputEditText
        cardView2 = findViewById(R.id.cardView2) as CardView



    }


    private fun initListeners() {
        btnRegLogin!!.setOnClickListener(this)
    }

    private fun initObjects() {
        inputValidation = InputValidation(activity)
        databaseActivity = DatabaseActivity(activity)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnRegLogin -> verifyFromSQLite()
        }
    }
    private fun verifyFromSQLite() {

        if (!inputValidation!!.isInputEditTextFilled(textInput4!!, textInput3!!, getString(R.string.error_message_email))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInput6!!, textInput5!!, getString(R.string.error_message_email))) {
            return
        }
        if (databaseActivity!!.checkUser(textInput4!!.text.toString().trim { it <= ' ' }, textInput6!!.text.toString().trim { it <= ' ' })) {
            val accountsIntent = Intent(activity, UsersListActivity::class.java)
            accountsIntent.putExtra("EMAIL", textInput4!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            startActivity(accountsIntent)
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(constraintLayout!!, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun emptyInputEditText() {
        textInput4!!.text = null
        textInput6!!.text = null
    }

}