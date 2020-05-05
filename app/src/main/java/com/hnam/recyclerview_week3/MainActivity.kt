package com.hnam.recyclerview_week3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val JSON_ARRAY =
            "[{\"avatar\":2131230813,\"job\":\"Footballer\",\"name\":\"Anh Duc\"},{\"avatar\":2131230826,\"job\":\"Manager\",\"name\":\"Cong Vinh\"},{\"avatar\":2131230880,\"job\":\"Comedian\",\"name\":\"Vinh Rau\"}]"
        private const val JSON_DATA =
            "{\"avatar\":2131230825,\"job\":\"Footballer\",\"name\":\"Cong Phuong\"}"
        private const val JSON_CUSTOMIZE_KEY = """{"key_name": "Mark","key_address": "London, 12000"}"""
        private const val JSON_NESTED_OBJECT = """
                                    {
                                       "name": "Alex",
                                       "address": {
                                            "city": "Rome",
                                            "post": "1000"
                                        }
                                     } """
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertJsonArrayStringToList()
        convertDataToJson()
        convertJsonToData()
        convertJsonDataWithCustomKey()
        convertNestedJsonStringToObject()
        convertNestedObjectToJsonString()
        skippingNestedObjectWhileParsing()
    }

    fun convertDataToJson() {
        val idol = Idol("Cong Phuong", "Footballer", R.drawable.congphuong)
        val json = Gson().toJson(idol)
        Log.e(TAG, json)
    }

    fun convertListToJsonArrayString() {
        val idol1 = Idol("Anh Duc", "Footballer", R.drawable.anhduc)
        val idol2 = Idol("Cong Vinh", "Manager", R.drawable.conhvinh)
        val idol3 = Idol("Vinh Rau", "Comedian", R.drawable.vinhrau)
        val list = listOf(idol1, idol2, idol3)
        val jsonString = Gson().toJson(list)
        Log.e(TAG, jsonString)
    }

    fun convertJsonArrayStringToList() {
        val typeToken = object : TypeToken<List<Idol>>() {}.type
        val listOfIdol = Gson().fromJson<List<Idol>>(JSON_ARRAY, typeToken)
        Log.e(TAG, listOfIdol.toString())
    }

    fun convertJsonToData() {
        val idol = Gson().fromJson(JSON_DATA, Idol::class.java)
        Log.e(TAG, idol.toString())
    }

    //customize json key
    fun convertJsonDataWithCustomKey() {
        val student = Gson().fromJson(JSON_CUSTOMIZE_KEY, CustomizeStudent::class.java)
        Log.e(TAG, student.toString())
    }

    //parse json object lồng json object
    fun convertNestedJsonStringToObject(){
        val student = Gson().fromJson(JSON_NESTED_OBJECT, Student::class.java)
        Log.e(TAG, student.toString())
    }

    fun convertNestedObjectToJsonString(){
        val student = Student("Ronaldo", null)
        val jsonString = Gson().toJson(student)
        Log.e(TAG, jsonString)
    }

    //Skipping nested hierarchy while parsing
    fun skippingNestedObjectWhileParsing(){
        val gson = GsonBuilder().registerTypeAdapter(People::class.java, PeopleDeserializer()).create()
        val people = gson.fromJson(JSON_NESTED_OBJECT, People::class.java)
        Log.e(TAG, people.address!!)
    }
}
