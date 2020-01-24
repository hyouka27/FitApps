package com.example.fitapps
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Database.DAOHelp
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.btnsave

class UserActivity : AppCompatActivity() {

    //Widok profilu użytkonwika
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val db = DAOHelp(this)
        //Pobieranie danych z bazy
        val names=db.getUserDao().getName()
        editNames.text=names[0].nAme
        val gross=db.getUserDao().getGross()
        editGrosss.text=gross[0].gRoss.toString()
        val age=db.getUserDao().getAge()
        editAges.text=age[0].aGe.toString()
        val hight=db.getUserDao().getHight()
        editHeights.text=hight[0].aHight.toString()
        btnsave.setOnClickListener {
            val intent = Intent(this, UserEditActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
