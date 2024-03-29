package com.example.reddish

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithme.recipeapp.adapter.MainCategoryAdapter
import com.codingwithme.recipeapp.adapter.SubCategoryAdapter
import com.codingwithme.recipeapp.database.RecipeDatabase
import com.example.reddish.entities.CategoryItems
import com.example.reddish.entities.MealsItems
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.coroutines.launch

class MainActivity5 : MainActivity9() {

    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<MealsItems>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

  //  val search_view = findViewById<SearchView>(R.id.search_view)
  //  var search = SearchRecipe()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        //getDataFromDb()

        //mainCategoryAdapter.setClickListener(onCLicked)
        //subCategoryAdapter.setClickListener(onCLickedSubItem)


    }


    private val onCLicked = object : MainCategoryAdapter.OnItemClickListener {
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }

    private val onCLickedSubItem = object : SubCategoryAdapter.OnItemClickListener {
        override fun onClicked(id: String) {
            var intent = Intent(this@MainActivity5, MainActivity8::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }

    private fun getDataFromDb() {
        launch {
            this.let {
                var cat =
                    RecipeDatabase.getDatabase(this@MainActivity5).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()

                getMealDataFromDb(arrMainCategory[0].strcategory)
                mainCategoryAdapter.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(
                    this@MainActivity5,
                    LinearLayoutManager.HORIZONTAL, false
                )
                rv_main_category.adapter = mainCategoryAdapter
            }


        }
    }

    private fun getMealDataFromDb(categoryName: String) {
        tvCategory.text = "$categoryName Category"
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@MainActivity5).recipeDao()
                    .getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategoryAdapter.setData(arrSubCategory)
                rv_sub_category.layoutManager = LinearLayoutManager(
                    this@MainActivity5,
                    LinearLayoutManager.HORIZONTAL, false
                )
                rv_sub_category.adapter = subCategoryAdapter
            }


        }
    }
}
