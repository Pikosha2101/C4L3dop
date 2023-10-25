package com.example.c4l3dop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.c4l3dop.R
import com.example.c4l3dop.databinding.SecondRecyclerItemBinding
import com.example.c4l3dop.models.SecondRecyclerModel
import com.squareup.picasso.Picasso

class SecondRecyclerAdapter(private var items : List<SecondRecyclerModel>) :
    RecyclerView.Adapter<SecondRecyclerAdapter.Holder>(){

    class Holder(item : View) : RecyclerView.ViewHolder(item){
        private val binding = SecondRecyclerItemBinding.bind(item)
        fun bind(secondRecyclerModel: SecondRecyclerModel) = with(binding){
            Picasso.get().load(secondRecyclerModel.image).into(imageView)
            //imageView.setImageResource(secondRecyclerModel.image)
            nameTextView.text = secondRecyclerModel.name
            ratingTextView.text = secondRecyclerModel.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        return Holder(
            inflater.inflate(R.layout.second_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(
            items[position]
        )
    }

}