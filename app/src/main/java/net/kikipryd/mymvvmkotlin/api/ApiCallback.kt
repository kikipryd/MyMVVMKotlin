package net.kikipryd.mymvvmkotlin.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class ApiCallback<RESPONSE> : Callback<RESPONSE> {

    override fun onResponse(call: Call<RESPONSE>, response: Response<RESPONSE>) {
        onResponse(response.body())
    }

    override fun onFailure(call: Call<RESPONSE>, throwable: Throwable) {
        onFailure(throwable.toString())
    }

    abstract fun onResponse(response: RESPONSE?)

    abstract fun onFailure(message: String)
}
