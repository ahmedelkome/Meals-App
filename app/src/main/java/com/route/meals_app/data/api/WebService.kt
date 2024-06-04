package com.route.meals_app.data.api

import com.route.meals_app.data.model.categories.CategoriesResponse
import retrofit2.http.GET

interface WebService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoriesResponse
}