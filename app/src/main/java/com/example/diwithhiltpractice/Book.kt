package com.example.diwithhiltpractice

import android.content.Context
import android.widget.Toast
import javax.inject.Inject


class Book @Inject constructor(name : String,price : String,author :String) : Product {
    var e_name: String = ""
    var e_price:String = ""
    var e_author : String = ""
    init {
        e_name = name
        e_price = price
        e_author = author
    }

    override suspend fun seeReview(context: Context) {
        TODO("Not yet implemented")
        Toast.makeText(context,e_name,Toast.LENGTH_SHORT).show()
    }

}