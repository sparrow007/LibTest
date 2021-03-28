package com.jackandphantom.libtest.`interface`


import com.jackandphantom.libtest.model.UserInfo

import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    @FormUrlEncoded
    @POST("user/login_check")
    fun getUser(@FieldMap map: Map<String, String>): Call<UserInfo>
}