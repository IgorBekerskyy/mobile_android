package com.example.lab111

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    private var SignUpButton: Button? = null

    private var usernameTextInputLayout: TextInputLayout? = null
    private var usernameTextInputEdit: TextInputEditText? = null

    private var emailTextInputLayout: TextInputLayout? = null
    private var emailTextInputEdit: TextInputEditText? = null

    private var passwordTextInputLayout: TextInputLayout? = null
    private var passwordTextInputEdit: TextInputEditText? = null

    private var repeatPasswordInputLayout: TextInputLayout? = null
    private var repeatPasswordTextInputEdit: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)


        usernameTextInputLayout = findViewById(R.id.login_layout)
        usernameTextInputEdit = findViewById(R.id.name_input_edit_text)

        emailTextInputLayout = findViewById(R.id.email_layout)
        emailTextInputEdit = findViewById(R.id.email_input_edit_text)

        passwordTextInputLayout = findViewById(R.id.password_layout)
        passwordTextInputEdit = findViewById(R.id.password_input_edit_text)

        repeatPasswordInputLayout = findViewById(R.id.confirm_password_layout)
        repeatPasswordTextInputEdit = findViewById(R.id.confirm_password_input_edit_text)

        SignUpButton = findViewById(R.id.sign_up_button)

        SignUpButton?.setOnClickListener {
            usernameTextInputLayout?.error = null
            emailTextInputLayout?.error = null
            passwordTextInputLayout?.error = null
            repeatPasswordInputLayout?.error = null

            val isValidName = Validator.validateName(usernameTextInputEdit, usernameTextInputLayout)
            val isValidEmail = Validator.validateEmail(emailTextInputEdit, emailTextInputLayout)
            val isValidPassword = Validator.validatePassword(passwordTextInputEdit, passwordTextInputLayout)
            var identicalPassword = false

            if (isValidPassword) {
                identicalPassword = passwordTextInputEdit?.text.toString() == repeatPasswordTextInputEdit?.text.toString()
                if (!identicalPassword) {
                    repeatPasswordInputLayout?.error = "Different passwords"
                }
            }

            if (isValidName && isValidEmail && isValidPassword && identicalPassword) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Done")
                builder.setMessage("You have signed up!")
                builder.show()
            }
        }
    }
}