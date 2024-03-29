package com.jackandphantom.libtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo ( @SerializedName("status") @Expose var status: Int,
    @SerializedName("message") @Expose var message: String)