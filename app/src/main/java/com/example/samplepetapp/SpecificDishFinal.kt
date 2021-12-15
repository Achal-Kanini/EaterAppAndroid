package com.example.samplepetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class SpecificDishFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_dish_final)

        var dishname = "first dish"
        var dishId = 2
        var dishImg = "https://media.istockphoto.com/photos/double-bacon-cheeseburger-picture-id117150229?k=20&m=117150229&s=612x612&w=0&h=KVXwdKJRTV1s8KAl9A7C_FOv1QvnMHSmvgRLpShZOTQ="
        var dishType = "Burger"
        var dishPrice = 20
        var dishContent = "Contetns pizza burger"


        val DishName = findViewById<TextView>(R.id.dishName)
        val DishImage = findViewById<ImageView>(R.id.dishImage)
        val DishType = findViewById<TextView>(R.id.type)
        val DishContent = findViewById<TextView>(R.id.contents)
        val DishPrice = findViewById<TextView>(R.id.priceServing)
        var CreateOrd = findViewById<Button>(R.id.createorder)

        DishName.text = dishname
        DishPrice.text = "Price per serving $dishPrice"
        DishContent.text = "Contents : $dishContent"
        DishType.text = "Type : $dishType"
        Picasso.get().load(dishImg).into(DishImage)

        CreateOrd.setOnClickListener{

            val intent = Intent(this@SpecificDishFinal,CreateOrder::class.java)
            intent.putExtra("name",dishname)
            intent.putExtra("id",dishId.toString())
            intent.putExtra("img",dishImg)
            intent.putExtra("price",dishPrice.toString())
            startActivity(intent)
        }

    }
}