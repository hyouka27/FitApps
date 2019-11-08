package com.example.fitapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

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

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(applicationContext,
                    "Position :$position\nId aktywności  : $itemValue", Toast.LENGTH_LONG)
                    .show()
                startActivity(intent)
            }
        }
    }
}
