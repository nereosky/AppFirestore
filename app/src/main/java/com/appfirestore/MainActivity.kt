package com.appfirestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_logout = findViewById<Button>(R.id.button_logout)
        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val tv_user = findViewById<TextView>(R.id.usename)
        val tv_email = findViewById<TextView>(R.id.email)

        tv_user.text = "User ID :: $userId"
        tv_email.text = "Email ID :: $emailId"

        button_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }

    }
}