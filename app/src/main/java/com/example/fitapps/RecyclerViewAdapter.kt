package com.example.fitapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapps.Database.Action
import kotlinx.android.synthetic.main.custom_view.view.*

class RecyclerViewAdapter(val actions: List<Action>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerViewAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.id.text = actions[position].dAte.toString()
        holder.name.text = actions[position].nAmes
        holder.steps.text="Kroki:  "+actions[position].sTeps.toString()
        holder.calo.text="Kalorie:  "+actions[position].cAlo.toString()
    }

    override fun getItemCount(): Int {
        return actions.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val id = itemView.tvId
        val name = itemView.tvName
        val steps=itemView.tvSteps
        val calo=itemView.tvCalo
    }
}