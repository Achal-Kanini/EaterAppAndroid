package com.example.samplepetapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.time.Month

class InterestAdapter: RecyclerView.Adapter<InterestAdapter.MyViewHolder>() {
//    var newpetInterests = emptyList<PetInterestList>()
    var ts= emptyList<TimeStamp>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.interest_layout,parent,false))
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ts[position]

//        holder.itemView.findViewById<TextView>(R.id.petint_name).text= ts[0].loginTimestamp.toString()
        if (position == 0){
            val sdf = java.text.SimpleDateFormat("dd MMMM yyyy")
            var membersince = java.util.Date(currentItem.loginTimestamp * 1000)
            var newdate = sdf.format(membersince)
            holder.itemView.findViewById<TextView>(R.id.loginhistory).text= "Member since : $newdate"
        }
        else{
            val sdf = java.text.SimpleDateFormat("dd MMMM yyyy")
            var loggedin = java.util.Date(currentItem.loginTimestamp * 1000)
            var newdate = sdf.format(loggedin)
            holder.itemView.findViewById<TextView>(R.id.loginhistory).text= "Logged In : $newdate"
        }


    }

    override fun getItemCount(): Int {
        return ts.size
    }

    fun setData(pets: List<TimeStamp>)
    {
        this.ts=pets
        notifyDataSetChanged()
    }
}