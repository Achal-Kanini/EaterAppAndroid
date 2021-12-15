package com.example.samplepetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpecificDishAdapter: RecyclerView.Adapter<SpecificDishAdapter.MyViewHolder>()  {

    var dishList = emptyList<Dish>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.specificdish_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dishList[position]
//        if(currentItem.id == 1) {
            holder.itemView.findViewById<TextView>(R.id.ordered).text = currentItem.name
            holder.itemView.findViewById<TextView>(R.id.pet_name).text = currentItem.contents
//            holder.itemView.findViewById<TextView>(R.id.type).text = currentItem.type
//            holder.itemView.findViewById<TextView>(R.id.price).text = currentItem.price.toString()
//            val imageview = holder.itemView.findViewById<ImageView>(R.id.image2)
//            Picasso.get().load(currentItem.url).into(imageview)
//        }
    }

    override fun getItemCount(): Int {
        return dishList.size
    }

    fun setData(dishes: Dishes)
    {
        this.dishList=dishes.dishes
        notifyDataSetChanged()
    }
}