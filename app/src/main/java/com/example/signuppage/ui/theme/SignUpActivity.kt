
package com.example.signuppage
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val confirmPassword =
            findViewById<EditText>(R.id.etConfirmPassword)

        val signUpButton = findViewById<Button>(R.id.btnSignUp)
        val loginText = findViewById<TextView>(R.id.tvLogin)

        signUpButton.setOnClickListener {

            val fullName = name.text.toString().trim()
            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString()
            val confirm = confirmPassword.text.toString()

            when {
                fullName.isEmpty() ||
                        userEmail.isEmpty() ||
                        userPassword.isEmpty() ||
                        confirm.isEmpty() -> {
                    showMessage("Please fill in all fields")
                }

                !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() -> {
                    email.error = "Enter a valid email"
                }

                userPassword.length < 8 -> {
                    password.error =
                        "Password must be at least 8 characters"
                }

                userPassword != confirm -> {
                    confirmPassword.error = "Passwords do not match"
                }

                else -> {
                    showMessage("Sign up successful!")

                    // Connect your backend API here.
                }
            }
        }

        loginText.setOnClickListener {
            showMessage("Login screen coming soon")
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
