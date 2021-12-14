package com.example.samplepetapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface PetInterface {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 540c0771-11fc-47e1-9c3f-f3824097bb4e"
    )

    @GET("users")
//    suspend fun getPets(): Response<PetList>
    suspend fun getPets(): History
//    suspend fun getPets(): List<Pets>
//    suspend fun getPets(token: String): List<Pets>

}