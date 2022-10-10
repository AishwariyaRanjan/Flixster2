package com.example.flixster2

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity(){
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var abstractTextView: TextView
    private lateinit var releaseDateTextView: TextView
    private lateinit var voteTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("DebugDetailActivity", "very start detailactivity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.i("DebugDetailActivity", "start detailactivity")

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        abstractTextView = findViewById(R.id.mediaAbstract)
        releaseDateTextView = findViewById(R.id.mediaReleaseDate)
        voteTextView = findViewById(R.id.mediaVoteAverage)
        // TODO: Get the extra from the Intent
        val movie = intent.getSerializableExtra("MOVIE_EXTRA") as Movie
        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = movie.title
        abstractTextView.text = movie.description
        releaseDateTextView.text = movie.release_date
        voteTextView.text = movie.vote_average
        Log.i("DebugDetailActivity-title", titleTextView.text.toString())
        Log.i("DebugDetailActivity-abstract", titleTextView.text.toString())
        // TODO: Load the media image
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.movieImageUrl)
            .into(mediaImageView)
    }
}