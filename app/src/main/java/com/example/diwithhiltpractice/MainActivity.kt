package com.example.diwithhiltpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.diwithhiltpractice.apiCallingRetrofit.Models.ResponsePojo
import com.example.diwithhiltpractice.apiCallingRetrofit.adapter.NowPlayingMovieAdapter
import com.example.diwithhiltpractice.apiCallingRetrofit.di.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var book: Book
    private val mainViewModel:MainViewModel by viewModels()


    lateinit var  nowPlayingMovieAdapter : NowPlayingMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtView = findViewById<TextView>(R.id.txtView)
        var edPageNum = findViewById<EditText>(R.id.edNum)
        var btnGo = findViewById<Button>(R.id.btnGo)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        Log.e("TAG", "onCreate: ${book.e_author}" )

        mainViewModel.getNowPlayingMovie().observe(this, Observer {
            txtView ?.text= it.total_pages.toString()
            nowPlayingMovieAdapter = NowPlayingMovieAdapter(it.results as List<ResponsePojo.Result>)
            recyclerView.adapter = nowPlayingMovieAdapter
            edPageNum.hint = "Total Page available is "+it.total_pages.toString()
        })


        btnGo?.setOnClickListener {
            val num = edPageNum.text
            if (num.trim().isNotEmpty()){
                mainViewModel.getNowPlayingWithPageNum(num.toString().toInt()).observe(this,
                    Observer {
                        nowPlayingMovieAdapter = NowPlayingMovieAdapter(it.results as List<ResponsePojo.Result>)
                        recyclerView.adapter = nowPlayingMovieAdapter
                    })
            }else{
                Toast.makeText(this,"Enter page number",Toast.LENGTH_SHORT).show()
            }
        }


    }
}