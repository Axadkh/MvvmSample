package com.example.samplemvvemproject.commonModel

import com.google.gson.annotations.SerializedName

data class Interest (
    @SerializedName("id"          ) var id          : String? = null,
    @SerializedName("label"       ) var label       : String? = null,
    @SerializedName("description" ) var description : String? = null,
)