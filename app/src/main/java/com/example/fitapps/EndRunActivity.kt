package com.example.fitapps
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapps.Caloplus.caloplus
import com.example.fitapps.Database.Action
import com.example.fitapps.Database.DAOHelp
import com.example.fitapps.Position.desc
import kotlinx.android.synthetic.main.activity_end_run.*
import java.time.Duration
import java.time.format.DateTimeFormatter

//Zmienna globalna coś jak statyczna klasa.
object Caloplus{
    var caloplus: Int=0
}

class EndRunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_run)
        StepActivity.sum
        val end=Stepglobal.stepglobal
        val ended2=StepActivity.sum2
        val score=ended2-end
        val endcalo=StepActivity.endcalo
        //Warunek jeżeli nie ma kroków nie spala się kalori, zabezpieczenie.
        if(score==0){
            Caloplus.caloplus
            val scorec=0
            caloplus=scorec
            Toast.makeText(this, "Za krótka aktywność, rusz się!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, StepToday::class.java)
            startActivity(intent)
        }
        else if(score>0){
            caloplus=endcalo
        }
        val time_start=StepActivity.startime
        val time_end=StepActivity.endtime
        val time=Duration.between(time_start,time_end)
        //Zapis czasu formatowanie
        val timese=time.toMinutes()
        var calominus: String= caloplus.toString()
        //Wyświetlenie informacji o zakończonej aktywności
        textView.text=score.toString()+" Kroki/ów " + calominus+" Kalorie/ów " +timese+" Minut"
        val id=Position.positions
        Position.desc
        //Zapis aktywności do bazy danych
        val db = DAOHelp(this)
        if (score!=0)
            db.getActDao().insertAll(Action(null,desc,id, caloplus,score,timese.toInt()))
        beck.setOnClickListener {
            val db = DAOHelp(this)
            var baza=db.getActDao().getAll()
            if(baza!=null){
                val intent = Intent(this, StepToday::class.java)
                startActivity(intent)
            }
            onBackPressed() }
    }
    override fun onBackPressed() {
    }
}
