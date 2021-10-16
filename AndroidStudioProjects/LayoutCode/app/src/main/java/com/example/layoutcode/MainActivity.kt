package com.example.layoutcode

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    private lateinit var button1:Button
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureLayout()

        button1.setOnClickListener {
            editText.setText(getString(R.string.button_tapped))
        }
    }

    private fun configureLayout() {
        button1 = Button(this)
        button1.text = getString(R.string.tap_me)
        button1.id = R.id.button1

        editText = EditText(this)
        editText.hint = getString(R.string.tap_me)
        editText.id = R.id.eT_1

        val layout = ConstraintLayout(this)
        layout.setBackgroundColor(Color.CYAN)

        layout.addView(button1)
        layout.addView(editText)

        setContentView(layout)

        val constraintSet = ConstraintSet()
        constraintSet.constrainWidth(button1.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(button1.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(button1.id,ConstraintSet.START,
            ConstraintSet.PARENT_ID,ConstraintSet.START,0)
        constraintSet.connect(button1.id,ConstraintSet.END,
            ConstraintSet.PARENT_ID,ConstraintSet.END,0)
        constraintSet.connect(button1.id,ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,ConstraintSet.TOP,0)
        constraintSet.connect(button1.id,ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,0)

        constraintSet.constrainWidth(editText.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(editText.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(editText.id,ConstraintSet.START,
            button1.id,ConstraintSet.START,0)
        constraintSet.connect(editText.id,ConstraintSet.END,
            button1.id,ConstraintSet.END,0)
        constraintSet.connect(editText.id,ConstraintSet.TOP,
            button1.id,ConstraintSet.BOTTOM,80)

        constraintSet.applyTo(layout)

    }
}