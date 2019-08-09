package com.example.kotlinmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailLogin = email.text.toString()
        val passwordLog = passwordLog.text.toString()

        buttonLogin.setOnClickListener {
            Log.d("LoginActivity","email " + emailLogin)
            Log.d("LoginActivity","Password: $passwordLog")

        }
        createNewAccount.setOnClickListener{
            finish()
        }

    }
}
