package com.hnam.recyclerview_week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getAndDisplayData()
    }

    private fun getAndDisplayData() {
        val data = intent.extras

        if (data != null) {
            val name = data.getString(IDOL_NAME_KEY)
            val job = data.getString(IDOL_JOB_KEY)
            val avatar = data.getInt(IDOL_AVATAR_KEY)


            tvName.text = name
            tvFullName.text = name
            tvJob.text = job
            Glide.with(this)
                .load(avatar)
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .into(ivHeader)
        }
    }
}
