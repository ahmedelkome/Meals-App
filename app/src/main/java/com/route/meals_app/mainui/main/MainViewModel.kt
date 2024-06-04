package com.route.meals_app.mainui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.usecases.categoriesusecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {
    var categoriesList = mutableStateListOf<CategoryItem>()

    suspend fun getAllCategories(): List<CategoryItem> {
        val list = categoryUseCase.execute()
        categoriesList.addAll(list)
        return categoriesList
    }
}