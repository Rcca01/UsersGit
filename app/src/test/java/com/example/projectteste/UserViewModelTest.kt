package com.example.projectteste

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projectteste.models.User
import com.example.projectteste.repositories.UserRepository
import com.example.projectteste.sealed.NetworkViewState
import com.example.projectteste.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val userServices = mock<UserRepository>()
    private lateinit var viewModel: UserViewModel
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Success state works`() = runBlocking {
        val list = listOf(User(1, "Nome", "http"))
        whenever(userServices.getAllUsers()).thenReturn(list)
        viewModel = UserViewModel(userServices)
        viewModel.getAllUsers()
        Assert.assertEquals(NetworkViewState.Success(list), viewModel.listUsers().value)
    }

    @Test
    fun `Error empty list state works`() = runBlocking {
        val message = "Lista vazia"
        whenever(userServices.getAllUsers()).thenReturn(emptyList())
        viewModel = UserViewModel(userServices)
        viewModel.getAllUsers()
        Assert.assertEquals(NetworkViewState.Error(message), viewModel.listUsers().value)
    }
}
