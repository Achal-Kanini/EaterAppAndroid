package com.example.samplepetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InterestActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<InterestAdapter.MyViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        val recyclerView = findViewById<RecyclerView>(R.id.petInterestView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = InterestAdapter()
        recyclerView.adapter = adapter

        val petsApplication = application as PetsApplication
        val petService = petsApplication.pets

        val newpets= emptyList<User>()
        CoroutineScope(Dispatchers.IO).launch {
//            val decodedpetsInterests = petService.getPetInterests()
            val decodedpets = petService.getHistory()

            withContext(Dispatchers.Main)
            {
                adapter.setData(decodedpets.loginEntries)
            }
        }
    }
}