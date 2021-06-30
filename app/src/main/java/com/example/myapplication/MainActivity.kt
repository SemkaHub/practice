package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.NewsModel
import com.example.myapplication.model.SpaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()
    }

    private fun getNews() {
        SpaceAPI.Factory.spaceAPI.getNews().enqueue(object : Callback<MutableList<NewsModel>> {
            override fun onFailure(call: Call<MutableList<NewsModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<MutableList<NewsModel>>,
                response: Response<MutableList<NewsModel>>
            ) {
                createList(response.body() as MutableList<NewsModel>)
            }
        })
    }

    private fun createList(newsList: MutableList<NewsModel>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = RecyclerAdapter(newsList, object : ClickListener{
            override fun onClicked(position: Int) {
                val intent: Intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("title", newsList[position].title)
                intent.putExtra("summary", newsList[position].summary)
                intent.putExtra("imageURL", newsList[position].imageUrl)
                startActivity(intent)
            }
        })
        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}