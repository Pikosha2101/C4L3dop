package com.example.c4l3dop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.c4l3dop.R
import com.example.c4l3dop.databinding.FirstRecyclerItemBinding
import com.example.c4l3dop.models.FirstRecyclerModel

class FirstRecyclerAdapter(private var categories : List<FirstRecyclerModel>) : RecyclerView.Adapter<FirstRecyclerAdapter.Holder>() {
    private var originalCategories: List<FirstRecyclerModel> = categories.toList() // Сохраните оригинальные данные
    class Holder(item : View) : RecyclerView.ViewHolder(item){
        private val binding = FirstRecyclerItemBinding.bind(item)
        fun bind(firstRecyclerModel: FirstRecyclerModel) = with(binding){
            categoryNameTextView.text = firstRecyclerModel.categoryName
            firstRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            firstRecyclerView.adapter = SecondRecyclerAdapter(firstRecyclerModel.list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        return Holder(
            inflater.inflate(R.layout.first_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(
            categories[position]
        )
    }

    fun filterByName(name: String) {
        //categories = originalCategories
        // Примените фильтр ко внутреннему списку данных
        categories = originalCategories
        // Пройдитесь по каждому FirstRecyclerModel
        val filteredList = categories.map { firstRecyclerModel ->
            val filteredList = firstRecyclerModel.list.filter { secondRecyclerModel ->
                secondRecyclerModel.name.contains(name, true)
            }
            // Верните FirstRecyclerModel с обновленным списком SecondRecyclerModel
            firstRecyclerModel.copy(list = filteredList)
        }.filter { firstRecyclerModel ->
            // Оставьте только те FirstRecyclerModel, у которых есть хотя бы один SecondRecyclerModel после фильтрации
            firstRecyclerModel.list.isNotEmpty()
        }

        // Обновите список данных и вызовите notifyDataSetChanged() для обновления RecyclerView
        categories = filteredList
        notifyDataSetChanged()
    }
}