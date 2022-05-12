package com.example.diwithhiltpractice.apiCallingRetrofit.di

import com.example.diwithhiltpractice.apiCallingRetrofit.MovieDBApi
import com.example.diwithhiltpractice.apiCallingRetrofit.Repository.DefaultMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(movieDBApi: MovieDBApi) = DefaultMovieRepository(movieDBApi)

}