package com.example.splash

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var cancel: Button
    private val TAG = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.ed_username)
        password = findViewById(R.id.ed_password)
        login = findViewById(R.id.bt_login)
        cancel = findViewById(R.id.bt_cancel)

        login.setOnClickListener {
            var userDetails = username.text.toString()
            var passDetails = password.text.toString()

            if(userDetails.length >= 3 && passDetails.length >= 3) {
                var sP: SharedPreferences = getSharedPreferences("LoginDetails", MODE_PRIVATE)
                var editor: SharedPreferences.Editor = sP.edit()
                editor.putString("userDetails", userDetails)
                editor.putString("passDetails", passDetails)
                editor.apply()

                var intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Enter valid Credentials",Toast.LENGTH_LONG).show()
            }

        }

    }
}