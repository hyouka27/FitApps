package com.example.fitapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Database.DAOHelp
import com.example.fitapps.Database.Users
import kotlinx.android.synthetic.main.activity_create_new_user.*
import kotlinx.android.synthetic.main.activity_step_today.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.btnsave


class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val db = DAOHelp(this)
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
    override fun onResume() {
        super.onResume()
        if(intent.hasExtra("Wiek")) editAges.setText(intent.getCharSequenceExtra("Wiek"))
        if(intent.hasExtra("Wzrost")) editHeights.setText(intent.getCharSequenceExtra("Wzrost"))
        if(intent.hasExtra("Waga")) editGrosss.setText(intent.getCharSequenceExtra("Waga"))
    }

}
