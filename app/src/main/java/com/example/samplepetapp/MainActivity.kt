package com.example.samplepetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

        val petsApplication = application as PetsApplication
        val petService = petsApplication.pets

            CoroutineScope(Dispatchers.IO).launch {
                val decodedpets = petService.getPets()
                println("decoded result is :${decodedpets.users[0]}")
                withContext(Dispatchers.Main)
                {
                    adapter.setData(decodedpets)
                }
            }
    }
}

