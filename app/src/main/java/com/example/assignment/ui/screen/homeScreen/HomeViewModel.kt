package com.example.assignment.ui.screen.homeScreen

import androidx.lifecycle.ViewModel
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo

class HomeViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModel() {


}