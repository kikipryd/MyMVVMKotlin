package net.kikipryd.mymvvmkotlin.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @get:GET("questions")
    val question: Call<Any>

}
