package com.jackandphantom.libtest.TestLearn

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.jackandphantom.libtest.R
import org.junit.Test

/**
 * Unit Instrument Test
 */

class UserRegistrationUtilsTest {

    //Each test cases should run independently
    private lateinit var resourceComparare:UserRegistrationUtils

    @Test
    fun stringResourceSameAsProvidedString_ReturnTrue() {
        resourceComparare = UserRegistrationUtils()
        val context = ApplicationProvider.getApplicationContext<Context>()
        Truth.assertThat(resourceComparare.validateUser(context, R.string.app_name, "LibTest")).isTrue()
    }
    @Test
    fun stringResourceNotSameAsProvidedString_ReturnFalse() {
        resourceComparare = UserRegistrationUtils()
        val context = ApplicationProvider.getApplicationContext<Context>()
        Truth.assertThat(resourceComparare.validateUser(context, R.string.app_name, "LibTesting")).isFalse()
    }


}