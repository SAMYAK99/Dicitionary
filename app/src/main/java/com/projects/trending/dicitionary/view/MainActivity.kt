package com.projects.trending.dicitionary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.trending.dicitionary.adapters.listadapter
import com.projects.trending.dicitionary.data.MainRepository
import com.projects.trending.dicitionary.databinding.ActivityMainBinding
import com.projects.trending.dicitionary.model.Definition
import com.projects.trending.dicitionary.viewmodels.MainViewModel
import com.projects.trending.dicitionary.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var movieAdapter: listadapter
    lateinit var list: ArrayList<Definition>
//    private  lateinit var mList : Definition

    private var mQuestions: MutableList<Definition> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        prepareRecyclerView()
         fetchPost()
    }


    private fun prepareRecyclerView() {
        movieAdapter = listadapter(mQuestions, context = this)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }

    private fun fetchPost() {
        val repository = MainRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val questions = response.body()
                mQuestions.addAll(questions!!.definitions)
                movieAdapter!!.notifyDataSetChanged()
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

}