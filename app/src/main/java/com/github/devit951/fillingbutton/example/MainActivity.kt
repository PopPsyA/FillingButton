package com.github.devit951.fillingbutton.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.github.devit951.fillingbutton.FillingButton
import com.github.devit951.fillingbutton.InternetSensableButton
import com.github.devit951.fillingbutton.InternetSensableFillingButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fb_first.onButtonFilled = { fb_first.showFillButtonToast() }

        fb_second.onButtonFilled = { fb_second.showFillButtonToast() }

        fb_third.onButtonFilled = { fb_third.showFillButtonToast() }
    }

    private fun FillingButton.showFillButtonToast(){
        Toast.makeText(context, "${this.text} filled!", Toast.LENGTH_SHORT).show()
    }
}
