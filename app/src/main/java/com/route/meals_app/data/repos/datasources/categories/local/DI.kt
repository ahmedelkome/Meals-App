package com.route.meals_app.data.repos.datasources.categories.local

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    @Binds
    abstract fun provideLocalDataSource(
        localDataSourceCategoriesImpl: LocalDataSourceCategoriesImpl
    ): LocalDataSourceCategories
}