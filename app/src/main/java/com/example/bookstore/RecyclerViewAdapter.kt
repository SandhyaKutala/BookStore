package com.example.bookstore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private var list: MutableList<Int>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val context : Context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(R.layout.recycle_view_item,viewGroup,shouldAttachToParentImmediately)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) , View.OnClickListener{
        private var view : View = v
        private var imageView : ImageView

        init {
            imageView = view.findViewById(R.id.image_view)
        }

        fun bind(image : Int) {
            imageView.setImageResource(image)
        }
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }


    }
}