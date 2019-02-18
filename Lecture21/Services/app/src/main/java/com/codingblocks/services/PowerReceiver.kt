package com.codingblocks.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {

        Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()

    }

}