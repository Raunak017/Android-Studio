package com.example.easymart

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        button2.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        if (l_user.text.toString().isEmpty()) {
            l_user.error = "Please Enter Email"
            l_user.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(l_user.text.toString()).matches()) {
            l_user.error = "Please Enter Correct Email"
            l_user.requestFocus()
            return
        }

        if (l_password.text.toString().isEmpty()) {
            l_password.error = "Please Enter Password"
            l_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(l_user.text.toString(), l_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                }
            }
    }

    fun signUp(view: View){
        val intent = Intent(this, SignUpAct::class.java)

        startActivity(intent)
        finish()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser : FirebaseUser?){
    if(currentUser != null){
        if(currentUser.isEmailVerified) {
            startActivity(Intent(this, ItemsAct::class.java))
            finish()
        }else {

                Toast.makeText(
                    baseContext, "Please Verify Your Email Address",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

            else {
        Toast.makeText(baseContext, "Login Failed",
            Toast.LENGTH_SHORT).show()

    }
    }
}