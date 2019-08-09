package com.example.kotlinmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        Log.d("MainActivity","Email is " + email)
        Log.d("MainActivity","Password: $password" )




        registerButton.setOnClickListener {
            performReg()
        }

        alreadyHaveAccount.setOnClickListener {
            Log.d("MainActivity", "Try to Show Login")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    private fun performReg() {

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter Email and Password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email is " + email)
        Log.d("MainActivity", "Password: $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                //else if successful

                Log.d("Main", "Created user: ${it.result?.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Main", "Failed To Create user: ${it.message}")
                Toast.makeText(this, "Failed To Create user", Toast.LENGTH_SHORT).show()
            }
    }
}
