package com.example.assignment.ui.screen.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModel() {


    private val _singleUserData = MutableStateFlow("")
    val singleUserData = _singleUserData.asStateFlow()

    fun readData(id: String) {
        viewModelScope.launch {
            userDao.getSingleUser(id).collect { data ->
                _singleUserData.value = data.toString()
            }
        }
    }
}
