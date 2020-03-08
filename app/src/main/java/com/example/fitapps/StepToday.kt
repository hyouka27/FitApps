package com.example.fitapps
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.fitapps.Stepglobal.calos
import com.example.fitapps.Stepglobal.stepglobal
import kotlinx.android.synthetic.main.activity_step_today.*

//Zmienne dostepne globalnie
object Stepglobal{
    var stepglobal: Int=0
    var calos:Int=0
}
class StepToday : AppCompatActivity(),SensorEventListener {

    //Zmienna do zapisywania kroków
    var running=true
    var sensorManager:SensorManager? = null
    public val stepsy=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_today)
        //zmienna do użycja sensora
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        button.setOnClickListener {
            val intent = Intent(this, ListSteps::class.java)
            startActivity(intent)
        }
        onBackPressed()
    }

    //Dla menu bocznego
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    //Decyduje co jest w menu bocznym
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_1 -> {
                Toast.makeText(this, "Licznik kroków", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_2 -> {
                Toast.makeText(this, "Profil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, UserActivity::class.java)
                // start your next activity
                startActivity(intent)
                return true
            }

            R.id.menu_3 -> {
                Toast.makeText(this, "Historia aktywności", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, History::class.java)
                // start your next activity
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
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
            val calo=0.05
            val calotodays=calo*event.values[0]
            val calotodayint=calotodays.toInt()
            steps.text= "" + event.values[0].toInt()
            calotoday.text=""+calotodayint
            val stepse=event.values[0].toInt()
            //Zapisanie aktualnych kroków.
            Stepglobal.stepglobal
            stepglobal=stepse
            Stepglobal.calos
            calos=calotodayint
        }
    }
    override fun onBackPressed() {
    }

}
