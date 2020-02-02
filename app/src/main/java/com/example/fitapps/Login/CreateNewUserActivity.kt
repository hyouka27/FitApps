package com.example.fitapps.Login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitapps.Database.DAOHelp
import com.example.fitapps.Database.Users
import com.example.fitapps.R
import com.example.fitapps.StepToday
import kotlinx.android.synthetic.main.activity_create_new_user.*
import kotlinx.android.synthetic.main.activity_user.btnsave

class CreateNewUserActivity : AppCompatActivity() {
    //Odpowiada za tworzenei nowego użytkownika, zapis danych do bazy.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)
        btnsave.setOnClickListener {
            val intent = Intent(this, StepToday::class.java)
            // start your next activity
            val namess=editName.text.toString()
            val aGe=editAge.text.toString()
            val Iage=aGe.toInt()
            val hIght=editHeight.text.toString()
            val Ihight=hIght.toInt()
            val gRoss=editGross.text.toString()
            val Igross=gRoss.toInt()
            val db = DAOHelp(this)
            db.getUserDao().insertAll(Users(1,namess,Iage,Ihight,Igross))
            startActivity(intent)
        }
    }
}
