package com.example.bookfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bookfinder.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val client = OkHttpClient();


    private fun run(url: String): Response {
        val request = Request.Builder().url(url).build()

        return client.newCall(request).execute()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



        binding.findButton.setOnClickListener{
            //Setting up flags to make shorter code
            var emptyTitle = false
            var emptyAuthor = false
            var emptyPublisher = false
            var bookTitle = binding.titleEdit.text.toString()
            var bookAuthor = binding.authorEdit.text.toString()
            var bookPublisher = binding.titleEdit.text.toString()
            //Checking what fields are empty
            if(bookTitle==""){
                emptyTitle=true
            }
            if(bookAuthor==""){
                emptyAuthor=true
            }
            if(bookPublisher==""){
                emptyPublisher=true
            }
            bookTitle=bookTitle.replace(" ","+")
            Log.d("1",bookTitle)
            Log.d("2",Constants.API_URL+bookTitle)
            val t = run("https://www.googleapis.com/books/v1/volumes?q=love+math")
            Log.d("3",t.toString())
        }

    }
}