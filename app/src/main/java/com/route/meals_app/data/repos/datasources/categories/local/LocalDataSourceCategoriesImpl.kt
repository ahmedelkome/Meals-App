package com.route.meals_app.data.repos.datasources.categories.local

import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.data.room.MyDataBase
import javax.inject.Inject

class LocalDataSourceCategoriesImpl
@Inject constructor(
    private val myDataBase: MyDataBase
) : LocalDataSourceCategories {
    override suspend fun getAllCategories(): List<CategoryItem> {
        return myDataBase.getMealsDao().getAllCategory()
    }

}