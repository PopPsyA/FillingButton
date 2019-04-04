package com.github.devit951.fillingbutton

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.Button

class InternetSensableButton (button: Button, onConnectionChanged: (Boolean) -> Unit) {

    private val internetConnectionReceiver = InternetConnectionReceiver(button, onConnectionChanged)
    private val context = button.context

    fun registerConnectionReceiver() = context.registerReceiver(internetConnectionReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))!!

    fun unregisterReceiver(){
        context.unregisterReceiver(internetConnectionReceiver)
    }

    private class InternetConnectionReceiver(private val button: Button,
                                             private val onConnectionChanged: (Boolean) -> Unit,
                                             private val disabledAlpha: Float = 0.5f): BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val connected = checkInternet(context)
            onConnectionChanged.invoke(connected)
            button.isEnabled = connected.also {
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