package com.example.samplepetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpecificDishActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<SpecificDishAdapter.MyViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_dish)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDish)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = SpecificDishAdapter()
        recyclerView.adapter = adapter

        val petsApplication = application as PetsApplication
        val petService = petsApplication.pets

        println("decoded result is ***********************************************")
        CoroutineScope(Dispatchers.IO).launch {
            val decodeddish = petService.getDishes()
            println("decoded result is %%%%%%%%%%%%%%%%%*************************")
            withContext(Dispatchers.Main)
            {
                adapter.setData(decodeddish)
            }
        }
    }
}