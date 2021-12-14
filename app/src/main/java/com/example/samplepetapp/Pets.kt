package com.example.samplepetapp

import com.google.gson.annotations.SerializedName
import org.w3c.dom.ls.LSInput

data class TimeStamps(
//    @SerializedName("id")
    var email: String = "",
    var orderedDishes: String = "",
)

data class History(
    var users: List<TimeStamps>
)