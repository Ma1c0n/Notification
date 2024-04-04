package com.ma1c0n.notification

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ma1c0n.notification.databinding.ActivityMainBinding

private const val NOTIFICATION_PERMISSION_REQUEST_CODE = 110
private const val CHANNEL_ID = "my_channel"
private const val NOTIFICATION_ID = 100

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestNotificationsPermission()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.sendNotificationButton.setOnClickListener {
            createAndSendNotification()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun createAndSendNotification() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Channel Name",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(NOTIFICATION_ID, buildNotification())
    }

    private fun buildNotification() = Notification.Builder(this, CHANNEL_ID)
        .setContentTitle("Notificaton Example")
        .setContentText("This is my Notification example")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setTicker("Ticker text")
        .setOngoing(true)
        .build()

    private fun requestNotificationsPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS),
            NOTIFICATION_PERMISSION_REQUEST_CODE
        )
    }
}

