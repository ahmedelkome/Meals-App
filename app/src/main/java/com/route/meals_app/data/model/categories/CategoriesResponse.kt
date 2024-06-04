package com.route.meals_app.data.model.categories

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(

	@field:SerializedName("categories")
	val categories: List<CategoryItem?>? = null
)