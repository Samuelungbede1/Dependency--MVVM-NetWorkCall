package com.example.classworkdependencyinjection

import androidx.lifecycle.MutableLiveData
import com.example.classworkdependencyinjection.model.Users
import com.example.classworkdependencyinjection.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(private val apiInstance: Api) {

      fun makeCall (liveData: MutableLiveData<List<Users>>) {
        val call: Call<List<Users>> = apiInstance.getUsers()
          call.enqueue(object: Callback<List<Users>>{
              override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                  liveData.postValue(response.body())
              }


              override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                  liveData.postValue(null)
              }
          })
      }
}