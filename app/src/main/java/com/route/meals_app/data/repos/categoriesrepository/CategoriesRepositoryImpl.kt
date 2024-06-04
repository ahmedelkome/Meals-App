package com.route.meals_app.data.repos.categoriesrepository

import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.data.repos.datasources.categories.local.LocalDataSourceCategories
import com.route.meals_app.data.repos.datasources.categories.remote.RemoteDataSourceCategories
import com.route.meals_app.data.utils.ConnectivityChecker
import com.route.meals_app.usecases.repos.categoriesrepo.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val remoteDataSourceCategories: RemoteDataSourceCategories
    ,private val localDataSourceCategories: LocalDataSourceCategories
): CategoriesRepository {
    override suspend fun getAllCategories(): List<CategoryItem> {
        return try {
            if (ConnectivityChecker.isNetworkAvailable()){
                remoteDataSourceCategories.getAllCategories()
            }else{
                localDataSourceCategories.getAllCategories()
            }
        }catch (e:Exception){
            throw e
        }
    }

}