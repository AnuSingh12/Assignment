package com.example.assignment.ui.screen.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo

class UserListViewModelFactory(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserListViewModel(userDao, addressDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}