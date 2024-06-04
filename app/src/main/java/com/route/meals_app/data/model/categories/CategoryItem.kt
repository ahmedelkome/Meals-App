package com.route.meals_app.data.model.categories

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CategoryItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @field:SerializedName("strCategory")
    val strCategory: String? = null,

    @field:SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,

    @field:SerializedName("idCategory")
    val idCategory: String? = null,

    @field:SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null
)