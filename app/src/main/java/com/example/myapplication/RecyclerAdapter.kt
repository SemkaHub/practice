package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.NewsModel
import com.squareup.picasso.Picasso

class RecyclerAdapter(
    private val newsList: MutableList<NewsModel>,
    private val onClickListener: ClickListener
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView = itemView.findViewById(R.id.title_card)
        var descriptionTextView: TextView = itemView.findViewById(R.id.description_card)
        var imageView: ImageView = itemView.findViewById(R.id.image_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_cardview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = holder.itemView.findViewById<View>(R.id.card_rv)
        card.setOnClickListener {
            onClickListener.onClicked(position)
        }
        holder.titleTextView.text = newsList[position].title
        holder.descriptionTextView.text = newsList[position].summary
        Picasso.get().load(newsList[position].imageUrl).resize(200,200).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

interface ClickListener {
    fun onClicked(position: Int)
}
