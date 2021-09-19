package com.example.classworkdependencyinjection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.classworkdependencyinjection.model.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    lateinit var liveData: MutableLiveData<List<Users>>

    init {
        liveData = MutableLiveData()
    }
    fun giveLiveDataObserver(): MutableLiveData<List<Users>> {
        return liveData
    }

    fun loadListOfUsers(){
        repository.makeCall(liveData)
    }
}