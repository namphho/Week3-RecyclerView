package com.hnam.recyclerview_week3

import com.google.gson.annotations.SerializedName

/**
 * Created by nampham on 5/5/20.
 */

data class CustomizeStudent(
    @SerializedName("key_name")
    var name: String? = null,
    @SerializedName("key_address")
    var address: String? = null
)