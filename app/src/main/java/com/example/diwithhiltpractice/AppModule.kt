package com.example.diwithhiltpractice

import android.content.Context
import com.example.diwithhiltpractice.apiCallingRetrofit.Constants.BASE_URL
import com.example.diwithhiltpractice.apiCallingRetrofit.MovieDBApi
import com.example.diwithhiltpractice.apiCallingRetrofit.Repository.DefaultMovieRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBookData(): Book {
        return Book("XYZ","200","Anil")
    }

    @Provides
    @Singleton
    fun provideOkHTTPClient():OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideMovieDBApi(okHttpClient: OkHttpClient):MovieDBApi{
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(MovieDBApi::class.java)
    }

}