package com.route.meals_app.data.repos.datasources.categories.local

import com.route.meals_app.data.model.categories.CategoryItem

interface LocalDataSourceCategories {
    suspend fun getAllCategories(): List<CategoryItem>
}