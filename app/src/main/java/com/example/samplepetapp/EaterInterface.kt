package com.example.samplepetapp

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface EaterInterface {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 540c0771-11fc-47e1-9c3f-f3824097bb4e"
    )

    @GET("users")
//    suspend fun getPets(): Response<PetList>
    suspend fun getUsers(): Users

    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 540c0771-11fc-47e1-9c3f-f3824097bb4e"
    )

    @GET("users/me/loginHistory")
    suspend fun getHistory(): History

    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 540c0771-11fc-47e1-9c3f-f3824097bb4e"
    )

    @GET("dishes")
    suspend fun getDishes(): Dishes

    @Headers(
        "Authorization: Bearer 540c0771-11fc-47e1-9c3f-f3824097bb4e"
    )
    @POST("users/me/orders")
    suspend fun createOrder(@Body requestBody: RequestBody) : Response<ResponseBody>

}