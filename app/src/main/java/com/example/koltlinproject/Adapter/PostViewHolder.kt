package com.example.koltlinproject.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txt_author = itemView.txt_author
    val txt_title = itemView.txt_title
    val txt_content = itemView.txt_content


}