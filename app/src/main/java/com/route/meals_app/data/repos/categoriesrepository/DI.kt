package com.route.meals_app.data.repos.categoriesrepository

import com.route.meals_app.usecases.repos.categoriesrepo.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun getCategoriesRepo(
        categoriesRepositoryImpl: CategoriesRepositoryImpl
    ):CategoriesRepository
}