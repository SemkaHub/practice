package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvTitle: TextView = findViewById(R.id.details_title)
        val tvSummary: TextView = findViewById(R.id.details_description)
        val ivImage: ImageView = findViewById(R.id.details_image)

        tvTitle.text = intent.getStringExtra("title")
        tvSummary.text = intent.getStringExtra("summary")
        Picasso.get().load(intent.getStringExtra("imageURL")).into(ivImage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}