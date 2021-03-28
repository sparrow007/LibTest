package com.jackandphantom.libtest.network

import android.util.Log
import com.jackandphantom.libtest.`interface`.RestApi
import com.jackandphantom.libtest.model.UserInfo
import com.jackandphantom.libtest.network.provider.ServiceBuilder
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

     fun calledUser() {
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)

         val map = HashMap<String, String>()
       val reqBody = RequestBody.create(MediaType.parse("text/plain"), "roshan@plaxonic.com")
         map["username"] = "roshan@plaxonic.com"

         retrofit.getUser(map).enqueue(object : Callback<UserInfo> {
            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.e("MY TAG", "ERROR " + t.localizedMessage + t.stackTrace)
            }

             override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                 Log.e("MY TAG", "RESPONSE " + response.isSuccessful)
                 Log.e("MY TAG", "RESPONSE " + response.body())
                 Log.e("MY TAG", "RESPONSE " + response.errorBody())
               //  Log.e("MY TAG", "RESPONSE " + response.headers())
               //  Log.e("MY TAG", "RESPONSE " + response.message())
                //// Log.e("MY TAG", "RESPONSE " + response.code())
             }
        })

    }
}


