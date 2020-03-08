package com.example.fitapps.Login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            val namess=editName.text.toString()
            val aGe=editAge.text.toString()
            val hIght=editHeight.text.toString()
            val gRoss=editGross.text.toString()
            if((namess=="")||(aGe=="")||(hIght=="")||(gRoss=="")){
                Toast.makeText(this, "Uzupełnij wszystkie pola poprawnie.", Toast.LENGTH_SHORT).show()
            }
            else {
                val Iage=aGe.toInt()
                val Ihight=hIght.toInt()
                val Igross=gRoss.toInt()
                val db = DAOHelp(this)
                db.getUserDao().insertAll(Users(1, namess, Iage, Ihight, Igross))
                val intent = Intent(this, StepToday::class.java)
                startActivity(intent)
            }
        }
    }
}
