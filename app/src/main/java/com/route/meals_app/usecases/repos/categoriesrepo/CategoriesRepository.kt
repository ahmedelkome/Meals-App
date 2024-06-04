package com.route.meals_app.usecases.repos.categoriesrepo

import com.route.meals_app.data.model.categories.CategoryItem

interface CategoriesRepository {
    suspend fun getAllCategories(): List<CategoryItem>
}