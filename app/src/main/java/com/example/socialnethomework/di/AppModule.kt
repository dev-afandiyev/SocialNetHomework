package com.example.socialnethomework.di

import android.content.Context
import androidx.room.Room
import com.example.socialnethomework.data.be.BackendApi
import com.example.socialnethomework.db.IUserDao
import com.example.socialnethomework.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase (@ApplicationContext appContext: Context): UserDatabase {
        return Room.databaseBuilder (
            appContext,
            UserDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideUsersDao(appDatabase: UserDatabase): IUserDao {
        return appDatabase.usersDao()!!
    }

    @Singleton
    @Provides
    fun providePokemonApiService(): BackendApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(BackendApi::class.java)
    }

}