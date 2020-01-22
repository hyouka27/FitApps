package com.example.fitapps

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapps.Database.Action
import com.example.fitapps.Database.ActivityViewModel
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_run.*
import kotlinx.android.synthetic.main.activity_run.btn
import org.jetbrains.anko.doAsync
import java.util.*

class History : AppCompatActivity() {

    private lateinit var  model: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        model = ViewModelProviders.of(this).get(ActivityViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        // Observe the model
        model.allActivity.observe(this, Observer{ action->
            // Data bind the recycler view
            recyclerView.adapter = RecyclerViewAdapter(action)
        })

    }
}
