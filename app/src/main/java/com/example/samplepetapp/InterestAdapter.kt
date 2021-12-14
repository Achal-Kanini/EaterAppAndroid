package com.example.samplepetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class InterestAdapter: RecyclerView.Adapter<InterestAdapter.MyViewHolder>() {
//    var newpetInterests = emptyList<PetInterestList>()
    var newpets= emptyList<TimeStamps>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.interest_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newpets[position]

    }

    override fun getItemCount(): Int {
        return newpets.size
    }

    fun setData(pets: List<TimeStamps>)
    {
        this.newpets=pets
        notifyDataSetChanged()
    }
}