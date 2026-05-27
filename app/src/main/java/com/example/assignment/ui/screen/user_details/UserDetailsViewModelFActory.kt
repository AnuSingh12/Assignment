package com.example.assignment.ui.screen.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.company.CompanyDao
import com.example.assignment.database.user.UserDAo

class UserDetailsViewModelFActory(
    private val userDao: UserDAo,
    private val addressDao: AddressDao,
    private val companyDao: CompanyDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserDetailsViewModel(userDao, addressDao, companyDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}