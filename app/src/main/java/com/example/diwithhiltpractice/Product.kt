package com.example.diwithhiltpractice

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

interface Product {
    suspend fun seeReview(@ApplicationContext context: Context)
}