package com.example.fitapps
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Database.DAOHelp
import com.example.fitapps.Database.Users
import kotlinx.android.synthetic.main.activity_user_edit.*

class UserEditActivity : AppCompatActivity() {

    //Edycja profilu użytkownika
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit)
       val db = DAOHelp(this)

        btnsave.setOnClickListener {
            val editNam = editName.text.toString()
            val editGro=editGross.text.toString()
            val editAge=editAge.text.toString()
            val editHei=editHeight.text.toString()

            //Zapis danych do bazy
            db.getUserDao().updateUsers(Users(1,editNam,editAge.toInt(),editHei.toInt(),editGro.toInt()))
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }
}
