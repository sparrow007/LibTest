package com.jackandphantom.libtest

import com.google.common.truth.Truth.assertThat
import com.jackandphantom.libtest.TestLearn.EmailValidator
import org.junit.Test



class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnTrue() {
       assertThat(EmailValidator.validate("ankit.loma@gmail.com")).isTrue()
    }

    @Test
    fun emailValidator_IncorrectEmailSimple_ReturnFalse() {
        assertThat(EmailValidator.validate("akakkala")).isFalse()
    }

    @Test
    fun emailValidator_EmptyEmail_ReturnFalse() {
        assertThat(EmailValidator.validate("")).isFalse()
    }

}