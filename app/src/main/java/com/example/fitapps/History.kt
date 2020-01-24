package com.example.fitapps
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapps.Database.ActivityViewModel
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {
    //Historia użytkownika, adapter, pobranie danych do historii z bazy -> lista aktywności
    private lateinit var  model: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        model = ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager
        model.allActivity.observe(this, Observer{ action->
            recyclerView.adapter = RecyclerViewAdapter(action)
        })

    }
}
