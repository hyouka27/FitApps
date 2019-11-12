package com.example.fitapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitapps.StepActivity.sum
import kotlinx.android.synthetic.main.activity_end_run.*
import kotlinx.android.synthetic.main.activity_step_today.*

class EndRunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_run)
        StepActivity.sum
        textView.text=sum.toString()
        beck.setOnClickListener {
         val intent = Intent(this, StepToday::class.java)
    // start your next activity
        startActivity(intent)
}
    }
}
