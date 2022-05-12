package com.example.diwithhiltpractice.apiCallingRetrofit.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diwithhiltpractice.apiCallingRetrofit.Models.ResponsePojo
import com.example.diwithhiltpractice.apiCallingRetrofit.MovieDBApi
import javax.inject.Inject

class DefaultMovieRepository @Inject constructor(private val movieDBApi: MovieDBApi) {

    val _data = MutableLiveData<ResponsePojo>()
    val data : LiveData<ResponsePojo>
    get() = _data

    suspend fun callAPI(){
        val result = movieDBApi.getNowPlayingMovie()
        if (result.isSuccessful)
        _data.postValue(result.body())
    }
    suspend fun callAPIByPageNum(page : Int){
        val result = movieDBApi.getNowPlayingMovieByPage(page)
        if(result.isSuccessful)
        _data.postValue(result.body())
    }
}