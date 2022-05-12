package com.example.diwithhiltpractice.apiCallingRetrofit.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diwithhiltpractice.apiCallingRetrofit.Models.ResponsePojo
import com.example.diwithhiltpractice.apiCallingRetrofit.Repository.DefaultMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val defaultMovieRepository: DefaultMovieRepository) : ViewModel() {


    fun getNowPlayingMovie():LiveData<ResponsePojo>{
        viewModelScope.launch {
            defaultMovieRepository.callAPI()
        }
        return defaultMovieRepository._data
    }

    fun getNowPlayingWithPageNum(pageNum : Int):LiveData<ResponsePojo>{
        viewModelScope.launch {
            defaultMovieRepository.callAPIByPageNum(pageNum)
        }
        return defaultMovieRepository._data
    }

}