package net.kikipryd.mymvvmkotlin.api

import retrofit2.Call

class ApiManager(private val apiService: ApiService) {

    val questions: Call<Any>
        get() = apiService.question

}
