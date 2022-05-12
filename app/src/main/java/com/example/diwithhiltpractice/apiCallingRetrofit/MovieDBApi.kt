package com.example.diwithhiltpractice.apiCallingRetrofit

import com.example.diwithhiltpractice.apiCallingRetrofit.Models.ResponsePojo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBApi {

    @GET("movie/top_rated?api_key=e6503da7d6f60fc032a4958a91afee62")
    suspend fun getNowPlayingMovie():Response<ResponsePojo>

    @GET("movie/top_rated?api_key=e6503da7d6f60fc032a4958a91afee62")
    suspend fun getNowPlayingMovieByPage(@Query("page") page : Int):Response<ResponsePojo>

}