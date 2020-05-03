package com.hnam.recyclerview_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : IdolAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lm = LinearLayoutManager(this)
        adapter = IdolAdapter(this, generateIdols(), listener)

        rv.layoutManager = lm
        rv.adapter = adapter
    }

    private val listener = object : IdolAdapter.IdolListener{
        override fun onClick(pos: Int, idol: Idol) {
            startProfileActivity(idol)
        }

        override fun onLongClick(pos: Int, idol: Idol) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Cảnh báo")
                .setMessage("bạn có muốn xóa ${idol.name} ?")
                .setPositiveButton("Đồng ý") { _, _ ->
                    removeItem(pos)
                }
                .setNegativeButton(
                    "Hủy"
                ) { dialog, _ -> dialog?.dismiss() }

            val dialog = builder.create();
            dialog.show()
        }
    }

    private fun removeItem(position: Int){
        adapter.removeIdol(position)
    }

    private fun startProfileActivity(idol: Idol){
        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
        intent.putExtra(IDOL_NAME_KEY, idol.name)
        intent.putExtra(IDOL_AVATAR_KEY, idol.avatar)
        intent.putExtra(IDOL_JOB_KEY, idol.job)
        startActivity(intent)
    }
}
