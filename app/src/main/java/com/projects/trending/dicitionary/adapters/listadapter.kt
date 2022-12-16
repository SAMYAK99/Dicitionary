package com.projects.trending.dicitionary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projects.trending.dicitionary.R
import com.projects.trending.dicitionary.model.Definition

class listadapter(val mList : List<Definition> ,val context: Context) : RecyclerView.Adapter<listadapter.ViewHolder>(){


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        val tv_view  : TextView = view.findViewById(R.id.tv_type)
        val tv_desp  : TextView = view.findViewById(R.id.tv_defination)
        val img : ImageView = view.findViewById(R.id.img_def)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view , parent ,false   ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

         val child = mList[position]
        holder.tv_view.text = child.type
        holder.tv_desp.text = child.definition

        Glide
            .with(context)
            .load(child.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.dict)
            .into(holder.img);

    }

    override fun getItemCount(): Int {
        return  mList.size
    }
}