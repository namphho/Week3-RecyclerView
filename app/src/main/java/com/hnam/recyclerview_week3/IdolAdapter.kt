package com.hnam.recyclerview_week3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by nampham on 5/3/20.
 */

class IdolAdapter(val ctx: Context, var data: ArrayList<Idol>, val listener: IdolListener) : RecyclerView.Adapter<IdolAdapter.IdolVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdolVH {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_idol, parent, false)
        return IdolVH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: IdolVH, position: Int) {
        val idol = data[position]
        Glide.with(ctx)
            .load(idol.avatar)
            .centerCrop()
            .into(holder.ivAvatar)
        holder.tvName.text = idol.name
        holder.tvDescription.text = idol.job

        holder.itemView.setOnClickListener{
            listener.onClick(position, idol)
        }

        holder.itemView.setOnLongClickListener {
            listener.onLongClick(position, idol)
            true
        }
    }

    fun removeIdol(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }


    class IdolVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar = itemView.findViewById<CircleImageView>(R.id.imageView)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    }

    interface IdolListener{
        fun onClick(pos: Int, idol: Idol)
        fun onLongClick(pos: Int, idol: Idol)
    }

}