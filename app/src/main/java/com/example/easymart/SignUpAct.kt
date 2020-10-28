
package com.example.easymart

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpAct : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signButton: Button = findViewById(R.id.button1)

        auth = FirebaseAuth.getInstance()

        signButton.setOnClickListener {
            signUpUser()
        }
        backbtn.setOnClickListener{
            backToLogin()
        }
    }

    fun backToLogin() {
        val intent3 = Intent(this, MainActivity::class.java)

        startActivity(intent3)
    }

    private fun signUpUser() {

        if (s_user.text.toString().isEmpty()) {
            s_user.error = "Please Enter Email"
            s_user.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(s_user.text.toString()).matches()) {
            s_user.error = "Please Enter Correct Email"
            s_user.requestFocus()
            return
        }

        if (s_password.text.toString().isEmpty()) {
            s_password.error = "Please Enter Password"
            s_password.requestFocus()
            return
        }


        auth.createUserWithEmailAndPassword(s_user.text.toString(), s_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }


                        }
                 else {
                    Toast.makeText(
                        baseContext, "Sign Up failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}

