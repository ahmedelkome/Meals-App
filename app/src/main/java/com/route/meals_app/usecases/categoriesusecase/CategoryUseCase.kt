package com.route.meals_app.usecases.categoriesusecase

import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.usecases.repos.categoriesrepo.CategoriesRepository
import javax.inject.Inject


class CategoryUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    suspend fun execute(): List<CategoryItem> {
        return categoriesRepository.getAllCategories()
    }
}