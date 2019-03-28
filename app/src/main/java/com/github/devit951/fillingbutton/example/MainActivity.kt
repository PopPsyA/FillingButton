package com.github.devit951.fillingbutton.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fb_first.onButtonFilled = { showFillButtonToast(fb_first) }

        fb_second.onButtonFilled = { showFillButtonToast(fb_second) }

        fb_third.onButtonFilled = { showFillButtonToast(fb_third) }
    }

    private fun showFillButtonToast(button: Button){
        Toast.makeText(this, "${button.text} filled!", Toast.LENGTH_SHORT).show()
    }
}
