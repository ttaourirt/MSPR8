package com.example.gostylecoupon

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputEditText
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private val activity = this@RegisterActivity

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
        setContentView(R.layout.activity_register)

        initViews()

        initListeners()

        initObjects()

        btnLogRegister.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
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

    private fun postDataToSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(textInput2, textInput1, getString(R.string.error_message_name))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInput4, textInput3, getString(R.string.error_message_email))) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(textInput6, textInput5, getString(R.string.error_message_email))) {
            return
        }
        if (!databaseActivity!!.checkUser(textInput4!!.text.toString().trim())) {
            var user = User(name = textInput2!!.text.toString().trim(),
                    email = textInput4!!.text.toString().trim(),
                    password = textInput6!!.text.toString().trim())
            databaseActivity!!.addUser(user)
            // Snack Bar to show success message that record saved successfully
            Snackbar.make(constraintLayout!!, getString(R.string.success_message), Snackbar.LENGTH_LONG).show()
            emptyInputEditText()
        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(constraintLayout!!, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initListeners() {
        btnLogRegister!!.setOnClickListener(this)
    }

    private fun initObjects() {
        inputValidation = InputValidation(activity)
        databaseActivity = DatabaseActivity(activity)

    }
    override fun onClick(v: View?) {
        when (v.id) {
            R.id.btnLogRegister -> postDataToSQLite()
        }
    }


    private fun emptyInputEditText() {
        textInput2!!.text = null
        textInput4!!.text = null
        textInput6!!.text = null

    }


}