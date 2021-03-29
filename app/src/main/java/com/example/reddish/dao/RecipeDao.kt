package com.example.reddish.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reddish.entities.Recipies

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM recipes ORDER BY id DESC")
    val allRecipe: List<Recipies>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertRecipe(recipes: Recipies)
}