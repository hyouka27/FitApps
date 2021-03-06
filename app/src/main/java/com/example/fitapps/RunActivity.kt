package com.example.fitapps
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
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
import com.example.fitapps.StepActivity.sum
import com.example.fitapps.StepActivity.sum2
import java.time.LocalDateTime

//Globalnie dostępne zmienne
object StepActivity{
    var sum=0
    var sum2=0
    var endcalo=0
    var startime=LocalDateTime.now()
    var endtime=LocalDateTime.now()
    var caloactivity: Double=0.0
}
class RunActivity  : AppCompatActivity(), SensorEventListener {

    //Zmienne dla SensorManagera
    var running=true
    var sensorManager:SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run)
        val intent = Intent(this, EndRunActivity::class.java)
        //Chronometr do licznika czasu
        val times = Chronometer(this)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        println(times.toString())
        times.setTextColor(Color.BLACK)
        times.setTextSize(TypedValue.COMPLEX_UNIT_IN,0.75f)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        layoutParams.setMargins(30, 40, 120, 40)
        times.layoutParams = layoutParams
        var currentDateTime=LocalDateTime.now()
        StepActivity.startime=currentDateTime
        val linearLayout = findViewById<LinearLayout>(R.id.l_layout)
        linearLayout?.addView(times)
        //access the button using id
        val btn = findViewById<Button>(R.id.btn)

        //Start/ stop i zapis danych do zmiennych globalnych
        btn?.setOnClickListener(object : View.OnClickListener {
            var isWorking = false
            override fun onClick(v: View) {
                if (!isWorking) {
            times.start()
            isWorking = true
            val startos=0
            sum=startos
        } else {
            times.stop()
            val ended=StepActivity.sum2
                    sum2=ended
                    var currentsDateTime=LocalDateTime.now()
                    endtime=currentsDateTime
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

    //Użycie sensora podczas włączenia aplikacji true
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

    //Użycje sensora podczas pauzy - false
    override fun onPause() {
        super.onPause()
        running = false
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    //Zapis i wyświetlanie kroków plus data bieżąca
    override fun onSensorChanged(event: SensorEvent) {
        if (running==true) {
            //Liczenie ile kroków to kaloria, musi być float gdyż przelicznik jest zbyt mały by robić to na incie
            val activitytype: Int=Position.positions
            StepActivity.caloactivity
            if(activitytype<1){
                caloactivity=0.08
                println(caloactivity)
                //Dla pierwszej aktywności id=0
            }
            else if(activitytype>0||activitytype<2){
                caloactivity=0.07
                println(caloactivity)
                //Dla drugiej aktywności id=1
            }
            else{caloactivity=0.06
            println(caloactivity)
                //Dla trzeciej aktywności id=2
            }

            val calotodays=caloactivity*((sum2-sum)+500)
            val calotodayint=calotodays.toInt()
            val stepse=event.values[0].toInt()
            //Zapisanie aktualnych kroków.
            StepActivity.sum2
            StepActivity.sum2 =stepse
            StepActivity.sum =stepse
            StepActivity.endcalo
            StepActivity.endcalo =calotodayint
        }
    }
}