package com.example.fitapps
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.fitapps.Position.desc
import com.example.fitapps.Position.positions

object Position{
    //Coś w stylu klasy statycznej, używamy do przesłania zmiennej do kolejnej aktywności w celu dobrania obliczeń według typu aktywności
    var positions=0
    var desc=""
}
    //Lista aktywności
class ListSteps : AppCompatActivity() {
    var array = arrayOf("Bieg", "Marsz", "Spacer")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_steps)
        val adapter = ArrayAdapter(this,
            R.layout.rlist, array)
        val listView:ListView = findViewById(R.id.rlists)
        listView.setAdapter(adapter)
        val intent = Intent(this, RunActivity::class.java)
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {
                val itemValue = listView.getItemAtPosition(position) as String
                Position.positions
                Position.desc
                desc=itemValue
                //Przekazuje i konwertuje numer pozycji na liście przy pomocy object
                positions =position.toInt()
                startActivity(intent)
            }
        }
    }
}
