package com.example.fitapps
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Database.DAOHelp
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.btnsave

class UserActivity : AppCompatActivity() {

    //Widok profilu użytkownika
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
        val grosse=gross[0].gRoss.toString()
        val grosseInt: Int=grosse.toInt()
        val highte=hight[0].aHight.toString()
        val hightInt: Int=highte.toInt()
        //Przelicznik BMI, najpierw float
        val bmi: Float=grosseInt.toFloat()/(hightInt.toFloat()/100*hightInt.toFloat()/100)
        //Zmiana wyniku na Int
        val bmiI: Int=bmi.toInt()
        editBMI.text=bmiI.toString()
        btnsave.setOnClickListener {
            val intent = Intent(this, UserEditActivity::class.java)
            startActivity(intent)
        }
    }
}
