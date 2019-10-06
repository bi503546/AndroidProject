package com.example.tp2.adaptateur

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.R
import com.example.tp2.models.Article
import java.net.URL

class ArticleAdapter(private val dataset: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle =
                root.findViewById<TextView>(R.id.article_title)
            val txtDesc = root.findViewById<TextView>(R.id.article_description)
            val img = root.findViewById<ImageView>(R.id.imageView)
            if (item.image.isNotBlank()) {
                val url = URL(item.image)
                val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                if(bmp != null) {
                    img.setImageBitmap(bmp)
                }
            }
            txtTitle.text = item.title
            txtDesc.text = item.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return ViewHolder(rootView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
               holder.bind(dataset[position])
    }
    override fun getItemCount() = dataset.size
}

