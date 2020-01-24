package com.example.fitapps
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.fitapps.Database.DAO
import com.example.fitapps.Database.DAOHelp
import com.example.fitapps.Login.CreateNewUserActivity

class MainActivity : AppCompatActivity() {
    //Strona startowa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = DAOHelp(this)
        val empty=db.getUserDao().getItemId(1)
        //Sprawdza czy użytkownik ma juz konto, jak tak to loguje samo jak nie to pyta o utworzenie
        if(empty!=null){
            val intent = Intent(this, StepToday::class.java)
            // start your next activity
            startActivity(intent)
        }
       else{
            val intent = Intent(this, CreateNewUserActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
