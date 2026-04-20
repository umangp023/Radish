package com.codingwithme.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reddish.databinding.ItemRvMainCategoryBinding
import com.example.reddish.entities.CategoryItems

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var arrMainCategory = ArrayList<CategoryItems>()

    class RecipeViewHolder(val binding: ItemRvMainCategoryBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(arrData : List<CategoryItems>){
        arrMainCategory = ArrayList(arrData)
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.tvDishName.text = arrMainCategory[position].strcategory
        Glide.with(holder.itemView.context).load(arrMainCategory[position].strcategorythumb).into(holder.binding.imgDish)
        holder.binding.root.setOnClickListener {
            listener?.onClicked(arrMainCategory[position].strcategory)
        }
    }

    interface OnItemClickListener{
        fun onClicked(categoryName:String)
    }
}
