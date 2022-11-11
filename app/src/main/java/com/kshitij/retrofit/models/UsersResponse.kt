package com.kshitij.retrofit.models

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    val id : Int? = 0,
    @SerializedName("name")
    val name : String? = null,
    @SerializedName("email")
    val email : String? = null,
    @SerializedName("gender")
    val gender : String? = null,
    @SerializedName("status")
    val status : String? = null
)