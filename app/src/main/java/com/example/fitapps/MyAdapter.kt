package com.example.fitapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_row.view.*

class MyAdapter :RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater =LayoutInflater.from(parent.context)
        val historyRow=layoutInflater.inflate(R.layout.history_row,parent,false)
        return MyViewHolder(historyRow)
    }

    override fun getItemCount(): Int {
        return 3
        //return ActivityDataBase.ActivityId.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name=holder.view.Typeactivity
        val times=holder.view.Timeactivity
        val calories=holder.view.Calories
/*
        name.setText(ActivityDataBase.TypeList[position])
        times.setText(ActivityDataBase.TimeList[position])
        calories.setText(ActivityDataBase.CaloriesList[position])
*/
    }


}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)