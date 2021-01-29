package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SignAdapter(private  val sign: List<Sign>)
    : RecyclerView.Adapter<SignAdapter.SignViewHolder>() {

        class SignViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            val imageView: ImageView = itemView.findViewById(R.id.imageView)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sign_item, parent, false)
        val sNameTextView: TextView = view.findViewById(R.id.SignName)
        return SignViewHolder(view)
    }

    override fun onBindViewHolder(holder: SignViewHolder, position: Int) {

        val s = sign[position]
        val currentUrl: String = s.url
        val sNameTextView: String = s.name


        Glide.with(holder.imageView.context)
            .load(currentUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .into(holder.imageView)

    }

    override fun getItemCount(): Int = sign.size

}