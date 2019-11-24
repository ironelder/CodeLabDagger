package com.ironelder.codelabdagger

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ironelder.codelabdagger.login.LoginError
import com.ironelder.codelabdagger.login.LoginSuccess
import com.ironelder.codelabdagger.login.LoginViewModel
import com.ironelder.codelabdagger.user.UserManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

class LoginViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel
    private lateinit var userManager: UserManager

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        viewModel = LoginViewModel(userManager)
    }

    @Test
    fun `Get username`() {
        whenever(userManager.username).thenReturn("Username")

        val username = viewModel.getUsername()

        assertEquals("Username", username)
    }

}