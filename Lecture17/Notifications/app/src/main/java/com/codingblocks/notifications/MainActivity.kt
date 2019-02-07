package com.codingblocks.notifications

import android.app.*
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.graphics.BitmapFactory
import android.graphics.Bitmap


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(
                NotificationChannel(
                    "first",
                    "Default",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
            nm.createNotificationChannel(
                NotificationChannel(
                    "second",
                    "Misc",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        }


        btnSimple.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("Hello There")
                .setContentText("General Kenobi!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

            nm.notify(System.currentTimeMillis().toInt(), simpleNotification)
        }

        btnIntent.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi: PendingIntent = PendingIntent.getActivity(this, 12345, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification = NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("Hello There")
                .setContentText("General Kenobi!")
                .setContentIntent(pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

            nm.notify(2, clickableNotification)
        }

        btnLongText.setOnClickListener {

            val bigTextStyle = NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("Hello There")
                .setContentText("General Kenobi!")
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("Oh, I don't think so... Oh, I don't think so... Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...Oh, I don't think so...")
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

            nm.notify(3, bigTextStyle)
        }

        btnAction.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi: PendingIntent = PendingIntent.getActivity(this, 12345, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val actionedNotification = NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("Hello There")
                .setContentText("General Kenobi!")
                .addAction(R.mipmap.ic_launcher, "Click", pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

            nm.notify(4, actionedNotification)
        }

        btnExpanding.setOnClickListener {

            val icon = BitmapFactory.decodeResource(
                this.resources,
                R.drawable.ic_icon
            )

            val actionedNotification = NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("Hello There")
                .setContentText("General Kenobi!")
                .setLargeIcon(icon)
                .setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(icon)
                        .bigLargeIcon(null)
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

            nm.notify(5, actionedNotification)
        }

    }
}
