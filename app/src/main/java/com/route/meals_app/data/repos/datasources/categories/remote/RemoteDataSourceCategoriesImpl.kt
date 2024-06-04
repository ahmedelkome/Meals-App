package com.route.meals_app.data.repos.datasources.categories.remote

import com.route.meals_app.data.api.WebService
import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.data.room.MyDataBase
import javax.inject.Inject

class RemoteDataSourceCategoriesImpl @Inject constructor(
    private val webService: WebService,
    private val myDataBase: MyDataBase
) : RemoteDataSourceCategories {
    override suspend fun getAllCategories(): List<CategoryItem> {
        val list = webService.getAllCategories().categories!!
        val nonNullList = list.filterNotNull()
        myDataBase.getMealsDao().clearMealsList()
        myDataBase.getMealsDao().saveCategory(nonNullList)
        return nonNullList
    }

}