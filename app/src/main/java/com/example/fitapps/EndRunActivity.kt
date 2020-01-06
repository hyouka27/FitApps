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
        println("endo")
        val end=Stepglobal.stepglobal
        val ended2=StepActivity.sum2
        println("endo")
        val score=ended2-end
        println("ends")
        val startcalo=Stepglobal.calos
        val endcalo=StepActivity.endcalo
        val scorec=endcalo-startcalo
        val time_start=StepActivity.startime
        val time_end=StepActivity.endtime

        val score_time=(time_end-time_start.second)
        val scoretimeminuts=score_time/60
        textView.text=score.toString()+" Kroki/ów " +scorec.toString()+" Kalorie/ów " +scoretimeminuts+" Minut"
        beck.setOnClickListener {
         val intent = Intent(this, StepToday::class.java)
    // start your next activity
        startActivity(intent)
}
    }
}
