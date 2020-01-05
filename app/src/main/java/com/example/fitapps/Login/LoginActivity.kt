package com.example.fitapps.Login

import CreateNewUserActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.fitapps.R
import com.example.fitapps.StepToday
import kotlinx.android.synthetic.main.activity_logins.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logins)

        var btnlogin=findViewById<Button>(R.id.blogin)
        var btnemail=findViewById<EditText>(R.id.editEmail)
        var btnpassword=findViewById<EditText>(R.id.editPassword)
        var email: String=btnemail.toString()
        var password: String=btnpassword.toString()
       btnlogin.setOnClickListener {
           val intent = Intent(this, StepToday::class.java)
           // start your next activity
           var save="test"
           var logintest=email+password
           if(logintest==save){
           println("OK")

       }
           startActivity(intent)
       }
        bnew.setOnClickListener {
            val intent = Intent(this, CreateNewUserActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }



}
