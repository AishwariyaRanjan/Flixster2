package com.example.flixster2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class MovieAdapter (private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual movie and bind to holder
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)
        private val releaseDateTextView = itemView.findViewById<TextView>(R.id.mediaReleaseDate)
        private val voteTextView = itemView.findViewById<TextView>(R.id.mediaVoteAverage)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            //abstractTextView.text = movie.description
            Log.i("DebugAdapter-title", titleTextView.text.toString())
            Log.i("DebugAdapter-abstract", titleTextView.text.toString())

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+movie.movieImageUrl)
                .into(mediaImageView)

//            releaseDateTextView.text = movie.release_data
//            voteTextView.text = movie.vote_average
        }
        override fun onClick(v: View?) {
            Log.i("DebugAdapter", "in onClick")
  //           TODO: Get selected article
            val movie = movies[absoluteAdapterPosition]
            Toast.makeText(context, "test: " + movie.title, Toast.LENGTH_LONG).show()
//            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("MOVIE_EXTRA", movie)
            context.startActivity(intent)
        }
    }

}