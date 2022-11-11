package com.kshitij.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshitij.retrofit.databinding.ActivityMainBinding
import com.kshitij.retrofit.models.UsersResponse
import com.kshitij.retrofit.services.MyClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myClient: MyClient
    private val TAG = "MainActivity"
    var arraylist = arrayListOf<UsersResponse>()

    lateinit var usersAdapter: UsersAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myClient = MyClient()

        myClient.api.fetchDetails().enqueue(object : Callback<ArrayList<UsersResponse>> {
            override fun onResponse(
                call: Call<ArrayList<UsersResponse>>,
                response: Response<ArrayList<UsersResponse>>
            ) {
                Log.e(TAG, " in response")
                arraylist.addAll(response.body() as ArrayList<UsersResponse>)
                Log.d(TAG, "onResponse: Users List $arraylist")
            }

            override fun onFailure(call: Call<ArrayList<UsersResponse>>, t: Throwable) {
                Log.e(TAG, " in failure ${t.localizedMessage}")
            }
        })


        layoutManager = LinearLayoutManager(this)
        usersAdapter = UsersAdapter(arraylist)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = usersAdapter
    }
}