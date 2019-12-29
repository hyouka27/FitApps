package com.example.fitapps.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fitapps.R
import com.example.fitapps.StepToday
import kotlinx.android.synthetic.main.activity_create_new_user.*

class CreateNewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)

        btnsave.setOnClickListener {
            val intent = Intent(this, StepToday::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
