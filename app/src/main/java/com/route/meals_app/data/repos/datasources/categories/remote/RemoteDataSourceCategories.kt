package com.route.meals_app.data.repos.datasources.categories.remote

import com.route.meals_app.data.model.categories.CategoryItem

interface RemoteDataSourceCategories {
    suspend fun getAllCategories(): List<CategoryItem>
}