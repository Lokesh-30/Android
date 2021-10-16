package com.example.activitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private val TAG = "Life cycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i(TAG,"onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy called")
    }
}