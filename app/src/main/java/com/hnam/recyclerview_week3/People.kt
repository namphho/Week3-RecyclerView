package com.hnam.recyclerview_week3

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

/**
 * Created by nampham on 5/5/20.
 */

data class People(var name: String, var address: String? = null)

class PeopleDeserializer : JsonDeserializer<People> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): People {
        json as JsonObject
        val name = json.get("name").asString
        val addressJson = json.get("address")
        val address = if (addressJson.isJsonObject)
            addressJson.asJsonObject.toString() else addressJson.asString
        return People(name, address)
    }
}