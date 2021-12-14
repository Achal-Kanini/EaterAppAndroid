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