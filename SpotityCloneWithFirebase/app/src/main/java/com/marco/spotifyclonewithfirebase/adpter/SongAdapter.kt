package com.marco.spotifyclonewithfirebase.adpter

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.marco.spotifyclonewithfirebase.R
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

class SongAdapter @Inject constructor(
        private val glide: RequestManager) : BaseSongAdapter(R.layout.list_item){

    //differ atualiza apenas os itens que mudaram
    override val differ =  AsyncListDiffer(this, diffCallback)



    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        var song = songs[position]
        holder.itemView.apply {
            tvPrimary.text = song.title
            tvSecondary.text = song.subtitle
            glide.load(song.imageUrl).into(ivItemImage)

            setOnClickListener {
                onItemClickListener?.let { click->
                    click(song)
                }
            }
        }
    }


}