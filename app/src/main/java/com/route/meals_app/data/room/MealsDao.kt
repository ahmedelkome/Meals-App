package com.route.meals_app.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.route.meals_app.data.model.categories.CategoryItem

@Dao
interface MealsDao {

    @Insert
    suspend fun saveCategory(listOfCategory: List<CategoryItem>)

    @Query("SELECT * FROM categoryitem ")
    suspend fun getAllCategory(): List<CategoryItem>

    @Query("DELETE FROM CategoryItem ")
    suspend fun clearMealsList()
}