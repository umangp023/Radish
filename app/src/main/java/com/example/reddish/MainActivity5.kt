package com.example.reddish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reddish.adapter.MainCategoryAdapter
import com.example.reddish.adapter.SubCategoryAdapter
import com.example.reddish.entities.Recipies

class MainActivity5 : AppCompatActivity() {

    var arrMainCategory = ArrayList<Recipies>()
    var arrSubCategory = ArrayList<Recipies>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    val rv_main_category = findViewById<RecyclerView>(R.id.rv_main_category)
    val rv_sub_category = findViewById<RecyclerView>(R.id.rv_sub_category)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        arrMainCategory.add(Recipies(1,"Beef"))
        arrMainCategory.add(Recipies(2,"Chicken"))
        arrMainCategory.add(Recipies(3,"Dessert"))
        arrMainCategory.add(Recipies(4,"Lamb"))
        arrMainCategory.add(Recipies(5,"Mexican"))

        arrSubCategory.add(Recipies(1,"Beef Wellington"))
        arrSubCategory.add(Recipies(2,"Chicken Alfredo"))
        arrSubCategory.add(Recipies(3,"Lava Cake"))
        arrSubCategory.add(Recipies(4,"Lamb Chops Sizzled with Garlic"))
        arrSubCategory.add(Recipies(5,"Fried Avocado Tacos"))


    }
}