package com.example.fitapps.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.fitapps.R
import com.example.fitapps.StepToday
import kotlinx.android.synthetic.main.activity_create_new_user.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.btnsave
import kotlinx.android.synthetic.main.activity_user.editEmail
import kotlinx.android.synthetic.main.activity_user.editPassword

class CreateNewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)
        btnsave.setOnClickListener {
            val intent = Intent(this, StepToday::class.java)
            // start your next activity
            startActivity(intent)
        }
        fun submitUser(view: View) {
            val intent = Intent(applicationContext, StepToday::class.java)
            intent.putExtra("Email", editEmail.text)
            intent.putExtra("Hasło", editPassword.text)
            intent.putExtra("Wiek", editAges.text)
            intent.putExtra("Wzrost", editHeights.text)
            intent.putExtra("Waga", editGrosss.text)
            intent.putExtra("Imię", editNames.text)
            intent.putExtra("Płeć", findViewById<RadioButton>(setgender.checkedRadioButtonId).text)
            startActivity(intent)
        }
            /* setgender.setOnCheckedChangeListener { group, checkedId ->
        run {
            val wybierz: Intent=Intent(applicationContext,CreateNewUserActivity::class.java)
            var RB: RadioButton = findViewById(checkedId)
            wybierz.putExtra("plec",RB.text)
            startActivity(wybierz)
        }


        }*/






    }

}
