package com.example.fitapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapps.Database.ActivityDataBase
import kotlinx.android.synthetic.main.history_row.view.*

class MyAdapter :RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater =LayoutInflater.from(parent.context)
        val historyRow=layoutInflater.inflate(R.layout.history_row,parent,false)
        return MyViewHolder(historyRow)
    }

    override fun getItemCount(): Int {
        return 3
        //return ActivityDataBase.IdActivity.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name=holder.view.Typeactivity
        //val times=holder.view.Timeactivity
        //val calories=holder.view.Calories

        val names=ActivityDataBase.TypeList[position]
        //val timesss=(ActivityDataBase.TimeList[position]).toString()
        //val caloryy=(ActivityDataBase.CaloriesList[position]).toString()


        name.text = names
       // times.text=timesss
        //calories.text=caloryy

    }


}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)