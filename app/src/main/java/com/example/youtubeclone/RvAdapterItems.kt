package com.example.youtubeclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RvAdapterItems(var youTubeList: List<YouTubeList>): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home_fragment,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var currentItem= youTubeList[position]
        holder.tvDisplay.text= currentItem.imagesText

        Picasso.get()
            .load(currentItem.images)
            .into(holder.imgDisplay)
    }


    override fun getItemCount(): Int {
        return youTubeList.size
    }


}
class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var imgDisplay= itemView.findViewById<ImageView>(R.id.imgDisplay)
    var tvDisplay = itemView.findViewById<TextView>(R.id.tvDisplay)
}