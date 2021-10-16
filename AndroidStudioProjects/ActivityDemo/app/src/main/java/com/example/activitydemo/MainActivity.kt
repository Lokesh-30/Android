package com.example.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val TAG = "Life cycle"
    private lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG,"Main Activity onCreate called")

        val button = findViewById<Button>(R.id.Bt_next)
        var name:EditText = findViewById(R.id.Ed_name)
        text = findViewById(R.id.tv_saveInstance)

        //button.setOnClickListener(View.OnClickListener {  })
        button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"Main Activity onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"Main Activity onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"Main Activity onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"Main Activity onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"Main Activity onDestroy called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("HighScore",321)
        Log.i(TAG,"Main Activity onSaveInstanceState called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var content = savedInstanceState.getInt("HighScore")
        text.setText("$content")
        Log.i(TAG,"Main Activity onRestoreInstanceState called")
    }
}