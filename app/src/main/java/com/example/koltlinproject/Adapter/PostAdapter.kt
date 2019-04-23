package com.example.koltlinproject.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.koltlinproject.Model.Post
import com.example.koltlinproject.R

class PostAdapter(internal var context: Context, internal var postList: List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_author.text = postList[position].userId.toString()
        holder.txt_title.text = postList[position].title
        holder.txt_content.text = StringBuilder(postList[position].body.substring(0, 20))
            .append("...").toString()
    }
}