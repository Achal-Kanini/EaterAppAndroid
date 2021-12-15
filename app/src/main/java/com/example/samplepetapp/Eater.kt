package com.example.samplepetapp

import com.google.gson.annotations.SerializedName
import org.w3c.dom.ls.LSInput

data class User(
//    @SerializedName("id")
    var email: String = "",
    var orderedDishes: String = "",
)

data class Users(
    var users: List<User>
)

data class TimeStamp(
//    @SerializedName("id")
    var loginTimestamp: Long = 0,
)

data class History(
    var loginEntries: List<TimeStamp>
)

data class Dish(
//    @SerializedName("id")
    var id:Int = 0,
    var url: String = "",
    var name: String = "",
    var price:Int = 0,
    var contents: String = "",
    var type: String = "",
)

data class Dishes(
    var dishes: List<Dish>
)