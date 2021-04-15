package com.jackandphantom.libtest.TestLearn

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.jackandphantom.libtest.R
import org.junit.Test

class UserRegistrationUtilsTest {

    private val resourceComparare = UserRegistrationUtils()

    @Test
    fun stringResourceSameAsProvidedString_ReturnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        Truth.assertThat(resourceComparare.validateUser(context, R.string.app_name, "LibTest")).isTrue()
    }
    @Test
    fun stringResourceNotSameAsProvidedString_ReturnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        Truth.assertThat(resourceComparare.validateUser(context, R.string.app_name, "LibTesting")).isFalse()
    }


}