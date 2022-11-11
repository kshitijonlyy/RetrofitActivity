package com.kshitij.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kshitij.retrofit.models.UsersResponse
import com.kshitij.retrofit.services.MyClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingleDetailsActivity : AppCompatActivity() {

    lateinit var myClient: MyClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_details)

        myClient = MyClient()

        myClient.api.fetchSingleDetails(3692).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                val data = response.body()
                Log.d("Single", "User onResponse: $data")
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.d("Exception", "onFailure: ${t.message}")
            }

        })
    }
}