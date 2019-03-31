package com.github.devit951.fillingbutton

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.Button

class InternetSensableButton (button: Button) {

    private val internetConnectionReceiver = InternetConnectionReceiver(button)
    private val context = button.context

    init {
        context.registerReceiver(internetConnectionReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }


    fun removeConnectionReceiver(){
        context.unregisterReceiver(internetConnectionReceiver)
    }

    private class InternetConnectionReceiver(private val button: Button,
                                             private val disabledAlpha: Float = 0.5f): BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            button.isEnabled = checkInternet(context).also {
                when(it){
                    true -> button.alpha = 1f
                    false -> button.alpha = disabledAlpha
                }
            }
        }

        private fun checkInternet(context: Context?): Boolean{
            val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
        }
    }
}