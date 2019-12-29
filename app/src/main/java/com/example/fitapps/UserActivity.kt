package com.example.fitapps

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_step_today.*
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        btnsave.setOnClickListener {
            val intent = Intent(this, UserEditActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
