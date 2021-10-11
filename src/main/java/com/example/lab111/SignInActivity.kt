package com.example.lab111


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {

    private var emailTextInputLayout: TextInputLayout? = null
    private var emailTextInputEdit: TextInputEditText? = null

    private var passwordTextInputLayout: TextInputLayout? = null
    private var passwordTextInputEdit: TextInputEditText? = null


    private var signInButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)


        emailTextInputLayout = findViewById(R.id.email_layout)
        emailTextInputEdit = findViewById(R.id.email_input_edit_text)

        passwordTextInputLayout = findViewById(R.id.password_layout)
        passwordTextInputEdit = findViewById(R.id.password_input_edit_text)

        signInButton = findViewById(R.id.sign_in_button)

        signInButton?.setOnClickListener {
            emailTextInputLayout?.error = null
            passwordTextInputLayout?.error = null
            val validEmail: Boolean = Validator.validateEmail(emailTextInputEdit, emailTextInputLayout)
            val validPassword: Boolean = Validator.validatePassword(passwordTextInputEdit, passwordTextInputLayout)

            if (validEmail && validPassword) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("You have successfully signed in!")
                builder.show()
            }
        }
    }
}