package com.jackandphantom.libtest.TestLearn

import android.content.Context
import androidx.annotation.StringRes

class UserRegistrationUtils {

    /**
     * Checks if user input is equals to resource
     * invalid constraints
     * 1. context is not passed
     * 2.invalid resource id
     * 3.empty resource
     * 3.empty userInput
     * 4.wrong userInput
     * 5.rightUserInput
     *
     */

    fun validateUser(context: Context, @StringRes resource: Int, userInput: String): Boolean {
        return context.resources.getString(resource) == userInput
    }
}