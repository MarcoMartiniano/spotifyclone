package com.marco.spotifyclonewithfirebase.adpter

import android.graphics.Color
import androidx.recyclerview.widget.AsyncListDiffer
import com.marco.spotifyclonewithfirebase.R
import kotlinx.android.synthetic.main.swipe_item.view.*
import javax.inject.Inject

class SwipeSongAdapter @Inject constructor() : BaseSongAdapter(R.layout.swipe_item){

    override val differ =  AsyncListDiffer(this, diffCallback)


    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        var song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.subtitle}"
            tvPrimary.text = text
            tvPrimary.setTextColor(Color.WHITE)

            setOnClickListener {
                onItemClickListener?.let { click->
                    click(song)
                }
            }
        }
    }


}