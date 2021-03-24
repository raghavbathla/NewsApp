package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class recyclerViewAdapter() : RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder>() {
    var list = ArrayList<dataClass>()
fun setListData(data: ArrayList<dataClass>){
    this.list = data
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewAdapter.MyViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.recycleitem,parent,false)
        return MyViewHolder(inflater)
     }

    override fun onBindViewHolder(holder: recyclerViewAdapter.MyViewHolder, position: Int) {
holder.bind(list[position])
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent (it.context,webView::class.java)
            intent.putExtra("URL",list[position].url)
          it.context.startActivity(intent)

        })


    }

    override fun getItemCount(): Int {
      return list.count()
    }
class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
val title : TextView = view.findViewById(R.id.title)
    var image : ImageView = view.findViewById(R.id.image)
    val description : TextView = view.findViewById(R.id.deccription)

    fun bind(titles:dataClass){
      title.text = titles.title
        description.text = titles.description

        val url = titles.urlToImage
        Glide.with(image).load(url).into(image)
    }
}
}
