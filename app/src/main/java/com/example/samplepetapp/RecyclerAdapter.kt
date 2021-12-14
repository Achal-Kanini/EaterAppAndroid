package com.example.samplepetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var petList = emptyList<TimeStamps>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = petList[position]
        holder.itemView.findViewById<TextView>(R.id.pet_name).text= currentItem.email
        var Orders = currentItem.orderedDishes
        var EmailLabel = currentItem.email[0]
        holder.itemView.findViewById<TextView>(R.id.ordered).text= "Ordered: $Orders"
        holder.itemView.findViewById<TextView>(R.id.emailLabel).text= EmailLabel.toString()

    }

    override fun getItemCount(): Int {
        return petList.size
    }

    fun setData(pets: History)
    {
        this.petList=pets.users
        notifyDataSetChanged()
    }

}