package com.route.meals_app.data.room

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import com.route.meals_app.data.model.categories.CategoryItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DI {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): MyDataBase {
        return Room.databaseBuilder(
            context,
            MyDataBase::class.java,
            MyDataBase.MY_DATA_BASE_NAME
        ).build()
    }

    @Provides
    fun provideDao(dataBase: MyDataBase):MealsDao{
        return dataBase.getMealsDao()
    }
}