package com.example.classworkdependencyinjection

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.giveLiveDataObserver().observe(this, Observer {
            if(it!=null){
                Log.d(TAG, "onCreate: $it")
            }
        })

        viewModel.loadListOfUsers()

    }
}