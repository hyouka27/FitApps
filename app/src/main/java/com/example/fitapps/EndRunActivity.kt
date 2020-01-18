package com.example.fitapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
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
        val channelId = "1"
        var builder = NotificationCompat.Builder(this,channelId)
            .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
            .setContentTitle("Zakończono aktywność")
            .setContentText(score.toString())
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        beck.setOnClickListener {
         val intent = Intent(this, StepToday::class.java)
    // start your next activity
        startActivity(intent)
}
    }
}
