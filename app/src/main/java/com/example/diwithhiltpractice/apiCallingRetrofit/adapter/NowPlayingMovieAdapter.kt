package com.example.diwithhiltpractice.apiCallingRetrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diwithhiltpractice.R
import com.example.diwithhiltpractice.apiCallingRetrofit.Models.ResponsePojo
import com.squareup.picasso.Picasso
import javax.inject.Inject

class NowPlayingMovieAdapter constructor(private val list : List<ResponsePojo.Result>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val result = list.get(position)
        Picasso.get().load("https://image.tmdb.org/t/p/original"+result.poster_path).into(holder.movieImage)
        holder.movieOriginalLanguage.text= "Language \n"+result.original_language
        holder.moviePopularity.text = "Popularity \n"+result.popularity.toString()
        holder.movieTitle.text = result.title
        holder.movieRelease.text = "Release Date \n"+result.release_date
        holder.movieDescription.text = result.overview
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
    val movieRelease = itemView.findViewById<TextView>(R.id.movieRelease)
    val movieOriginalLanguage = itemView.findViewById<TextView>(R.id.movieOriginalLanguage)
    val moviePopularity = itemView.findViewById<TextView>(R.id.moviePopularity)
    val movieDescription = itemView.findViewById<TextView>(R.id.movieDescription)
    val movieImage = itemView.findViewById<ImageView>(R.id.movieImage)

}