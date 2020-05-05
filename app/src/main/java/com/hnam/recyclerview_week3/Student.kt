package com.hnam.recyclerview_week3

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

/**
 * Created by nampham on 5/5/20.
 */

data class Student(var name: String, var address: Address?)


