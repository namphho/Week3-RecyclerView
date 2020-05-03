package com.hnam.recyclerview_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun startProfileScreen(idol: Idol){
        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
        intent.putExtra(IDOL_NAME_KEY, idol.name)
        intent.putExtra(IDOL_AVATAR_KEY, idol.avatar)
        intent.putExtra(IDOL_JOB_KEY, idol.job)
        startActivity(intent)
    }
}
