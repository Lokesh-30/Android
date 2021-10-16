package com.example.splash

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var username: TextView
    private lateinit var password: TextView
    private lateinit var backToLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        username = findViewById(R.id.tv_user)
        password = findViewById(R.id.tv_pass)
        backToLogin = findViewById(R.id.bt_cancelSecond)

        var sharedPreference: SharedPreferences = getSharedPreferences("LoginDetails", MODE_PRIVATE)
        var user = sharedPreference.getString("userDetails","")
        username.text = user
        var pass = sharedPreference.getString("passDetails","")
        password.text = pass

        backToLogin.setOnClickListener {
            var clearPreference: SharedPreferences = getSharedPreferences("LoginDetails", MODE_PRIVATE)
            var editor: SharedPreferences.Editor = clearPreference.edit()
            editor.clear()
            editor.commit()

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}