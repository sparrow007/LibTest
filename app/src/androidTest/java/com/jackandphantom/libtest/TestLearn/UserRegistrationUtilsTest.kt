package com.jackandphantom.libtest.TestLearn

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.jackandphantom.libtest.R
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Unit Instrument Test
 */

class UserRegistrationUtilsTest {

    //Each test cases should run independently
    private lateinit var resourceComparare:UserRegistrationUtils

    /**
     * Runs each time when particular test function are gets called
     */
    @Before
    fun setup() {
        resourceComparare = UserRegistrationUtils()
    }

    @After
    fun tearDown() {
        //Destroy the objects for example room database, you should have closed it.
    }

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