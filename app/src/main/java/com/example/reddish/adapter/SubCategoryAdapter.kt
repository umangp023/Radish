package com.codingwithme.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reddish.databinding.ItemRvSubCategoryBinding
import com.example.reddish.entities.MealsItems

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? = null
    var arrSubCategory = ArrayList<MealsItems>()

    class RecipeViewHolder(val binding: ItemRvSubCategoryBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(arrData : List<MealsItems>){
        arrSubCategory = ArrayList(arrData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListener){
        listener = listener1
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.tvDishName.text = arrSubCategory[position].strMeal
        Glide.with(holder.itemView.context).load(arrSubCategory[position].strMealThumb).into(holder.binding.imgDish)
        holder.binding.root.setOnClickListener {
            listener?.onClicked(arrSubCategory[position].idMeal)
        }
    }

    interface OnItemClickListener{
        fun onClicked(id:String)
    }
}
