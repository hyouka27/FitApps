package com.example.fitapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Database.Action
import com.example.fitapps.Database.DAOHelp
import kotlinx.android.synthetic.main.activity_end_run.*


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
    // start your next activity
            val db = DAOHelp(this)
            var baza=db.getActDao().getAll()
            if(baza!=null){
                val intent = Intent(this, StepToday::class.java)
                // start your next activity
                startActivity(intent)
                println("Testy są ok")
            }
            println("Testy są słabe") }
    }
}
