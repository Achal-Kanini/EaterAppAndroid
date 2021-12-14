package com.example.samplepetapp

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class PetsApplication: Application() {

    public lateinit var pets: PetInterface

    override fun onCreate() {
        super.onCreate()
        pets = initPetService()
    }

    private fun initPetService(): PetInterface
    {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PetInterface::class.java)
    }
}