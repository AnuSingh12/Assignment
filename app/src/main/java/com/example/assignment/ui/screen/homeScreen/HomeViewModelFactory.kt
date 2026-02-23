package com.example.assignment.ui.screen.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo
import kotlin.jvm.java

class HomeViewModelFactory(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(userDao , addressDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
