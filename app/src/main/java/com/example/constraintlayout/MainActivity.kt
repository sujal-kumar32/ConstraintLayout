package com.example.constraintlayout

import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnEmail = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.bt1)
        val btnSms = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.bt2)
        val btnDial = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.bt3)
        val btnUrl = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.bt4)
        val etName = findViewById<android.widget.EditText>(R.id.et1)
        val btnSubmit = findViewById<android.widget.Button>(R.id.bt5)

        btnEmail.setOnClickListener {
            val emailIntent = android.content.Intent(android.content.Intent.ACTION_SENDTO).apply {
                data = android.net.Uri.parse("sujalstark12345@gmail.com")
                putExtra(android.content.Intent.EXTRA_SUBJECT, "o7services.com")
                putExtra(android.content.Intent.EXTRA_TEXT, "hellow")
            }
            startActivity(emailIntent)
        }

        btnSms.setOnClickListener {
            val smsIntent = android.content.Intent(android.content.Intent.ACTION_VIEW).apply {
                data = android.net.Uri.parse("sms:9117718846")
                putExtra("sms_body", "Hello" )
            }
            startActivity(smsIntent)
        }

        btnDial.setOnClickListener {
            val phoneNumber = "9117718846"
            val dialIntent = android.content.Intent(android.content.Intent.ACTION_DIAL)
            dialIntent.data = android.net.Uri.parse("tel:$phoneNumber")
            startActivity(dialIntent)
        }

        btnUrl.setOnClickListener {
            val urlIntent = android.content.Intent(android.content.Intent.ACTION_VIEW)
            urlIntent.data = android.net.Uri.parse("https://o7services.com/")
            startActivity(urlIntent)
        }

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val intent = android.content.Intent(this, welcome::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}