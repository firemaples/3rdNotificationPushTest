package com.workdo.networktester

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object NetworkTester {
    private val TAG = NetworkTester::class.java.simpleName

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private val service by lazy { retrofit.create(GitHubService::class.java) }

    fun test(user: String) {
        Log.i(TAG, "Run test, user: $user")
        val call = service.listRepos(user)
        GlobalScope.launch {
            val result = call.execute()
            if (result.isSuccessful) {
                Log.i(TAG, "Success: ${result.body()?.string()}")
            } else {
                Log.i(TAG, "Failed: ${result.errorBody()?.string()}")
            }
        }
    }
}

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<ResponseBody>
}