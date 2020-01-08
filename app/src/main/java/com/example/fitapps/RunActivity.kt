package com.example.fitapps

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.util.TypedValue
import android.widget.Button
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.StepActivity.caloactivity
import com.example.fitapps.StepActivity.endcalo
import com.example.fitapps.StepActivity.endtime
import com.example.fitapps.StepActivity.startcalo
import com.example.fitapps.StepActivity.sum
import com.example.fitapps.StepActivity.sum2
import kotlinx.android.synthetic.main.activity_step_today.*
import java.time.LocalDateTime

object StepActivity{
    var sum=0
    var sum2=0
    var startcalo=0
    var endcalo=0
    var startime= LocalDateTime.now()
    var endtime=0
    var caloactivity: Double=0.0
}
class RunActivity  : AppCompatActivity(), SensorEventListener {


    var running=true
    var sensorManager:SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run)
        val intent = Intent(this, EndRunActivity::class.java)
        val times = Chronometer(this)
        println("test")
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        println(times.toString())
        times.setTextColor(Color.BLACK)
        times.setTextSize(TypedValue.COMPLEX_UNIT_IN,0.75f)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        layoutParams.setMargins(30, 40, 120, 40)
        times.layoutParams = layoutParams

        val linearLayout = findViewById<LinearLayout>(R.id.l_layout)
        linearLayout?.addView(times)
        println("testend")
        //Zapisuje z listy aktywnośći id typu aktywności
        println(Position.positions.toString())
        println("testend")
        val start =Stepglobal.stepglobal
        val calostart=Stepglobal.calos
        //access the button using id
        val btn = findViewById<Button>(R.id.btn)
        btn?.setOnClickListener(object : View.OnClickListener {
            var isWorking = false
            override fun onClick(v: View) {
                if (!isWorking) {
            times.start()
            isWorking = true
            val calostart=Stepglobal.calos
            val startos = Stepglobal.stepglobal
            StepActivity.sum
            println("suma")
            sum=startos
            startcalo=calostart
            println(sum)
            println("suma")
        } else {
            times.stop()
             val caloend=StepActivity.endcalo
                    endcalo=caloend
            val ended=StepActivity.sum2
                    sum2=ended
            val timeednd=StepActivity.endtime
                    val endtimes=LocalDateTime.now()
                    endtime=endtimes.second
            isWorking = false
            startActivity(intent)
        }

        btn.setText(if (isWorking) R.string.start else R.string.stop)

        Toast.makeText(
            this@RunActivity, getString(
                if (isWorking)
                    R.string.working
                else
                    R.string.stopped
            ),
            Toast.LENGTH_SHORT
        ).show()
    }
        })
    }

    //użycie sensora podczas włączenia aplikacji true
    override fun onResume() {
        super.onResume()
        running = true
        var stepsSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepsSensor == null) {
            Toast.makeText(this, "Sensor nie działa", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepsSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }
    //użycje sensora podczas pauzy - false
    override fun onPause() {
        super.onPause()
        running = false
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    //zapis i wyświetlanie kroków plus data bieżąca
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSensorChanged(event: SensorEvent) {
        if (running==true) {
            //liczenie ile kroków to kaloria, musi być float gdyż przelicznik jest zbyt mały by robić to na incie
            val activitytype: Int=Position.positions
            StepActivity.caloactivity
            val calo=0.05
            //caloactivity=calo
            if(activitytype<1){
                caloactivity=0.5
                println(caloactivity)
                //Dla pierwszej aktywności id=0
            }
            else if(activitytype>0||activitytype<2){
                caloactivity=0.8
                println(caloactivity)
                //Dla drugiej aktywności id=1

            }
            else{caloactivity=0.9
            println(caloactivity)
                //Dla trzeciej aktywności id=2
            }


            val calotodays=caloactivity*event.values[0]
            val calotodayint=calotodays.toInt()
            val stepse=event.values[0].toInt()
            //Zapisanie aktualnych kroków.
            StepActivity.sum2
            StepActivity.sum2 =stepse
            StepActivity.endcalo
            StepActivity.endcalo =calotodayint
            //addItem(currentuser, stepglobal.toString())
        }
    }
}