package com.example.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }
        login_button.setOnClickListener {
            showLogIn()
        }
        save.setOnClickListener {
            handler.insertUserData(name.text.toString(),email.text.toString(),password_register.text.toString())
        }
        login_button.setOnClickListener {
            handler.userPresent(login_email.text.toString(),login_password.text.toString())
            showHome()
        }
    }

    private fun showRegistration() {
        registration_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_01.visibility=View.GONE
    }
    private fun showLogIn() {
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_01.visibility=View.GONE
    }
    private fun showHome() {
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_01.visibility=View.VISIBLE
    }

}