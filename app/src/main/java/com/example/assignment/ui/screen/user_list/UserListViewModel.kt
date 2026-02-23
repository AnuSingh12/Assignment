package com.example.assignment.ui.screen.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModel() {

    private val _userData = MutableStateFlow<List<UserData>>(emptyList())
    val userData = _userData.asStateFlow()

    fun readUserData(){
        viewModelScope.launch {
            userDao.getUserData().collect {data ->
                _userData.value = data
            }
        }
    }

}