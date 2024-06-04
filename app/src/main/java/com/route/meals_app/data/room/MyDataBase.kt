package com.route.meals_app.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.route.meals_app.data.model.categories.CategoryItem

@Database(entities = [CategoryItem::class], version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getMealsDao():MealsDao
    companion object{
        const val MY_DATA_BASE_NAME = "My DataBase"
    }
}