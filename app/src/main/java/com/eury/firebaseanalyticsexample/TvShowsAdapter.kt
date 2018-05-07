package com.eury.firebaseanalyticsexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.itv_tv_shows.view.*

/**
 * Created by euryperez on 5/7/18.
 * Property of Instacarro.com
 */
class TvShowsAdapter(private val tvShowsList: ArrayList<TvShow>, private val clickListener: (TvShow) -> Unit) : RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.itv_tv_shows, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: TvShowsAdapter.ViewHolder, position: Int) {
        holder.bindItems(tvShowsList[position])
        holder.itemView.setOnClickListener { clickListener(tvShowsList[position]) }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return tvShowsList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: TvShow) {
            itemView.itv_tv_shows_tv_name.text = item.name
            itemView.itv_tv_shows_tv_description.text = item.description
            Glide.with(itemView).load(item.pictureUrl).into(itemView.itv_tv_shows_iv_picture)
        }
    }
}