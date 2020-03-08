package com.example.fitapps
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapps.Database.Action
import kotlinx.android.synthetic.main.custom_view.view.*

//Adapter dla widoku historii
class RecyclerViewAdapter(val actions: List<Action>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerViewAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view,parent,false)
        return ViewHolder(v)
    }

    //Przypisuje zmienne do widoku
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.id.text = actions[position].dAte.toString()
        holder.name.text = actions[position].nAmes
        holder.steps.text="Kroki:  "+actions[position].sTeps.toString()
        holder.calo.text="Kalorie:  "+actions[position].cAlo.toString()
        holder.time.text="Czas:  "+actions[position].tIme.toString()
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

    //Pobiera zmienne z widoku
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val id = itemView.Id
        val name = itemView.Name
        val steps=itemView.Steps
        val calo=itemView.Calo
        val time=itemView.Time
    }
}