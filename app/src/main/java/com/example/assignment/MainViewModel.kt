package com.example.assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao
) : ViewModel() {

    private val _users = MutableStateFlow<List<UserData>>(emptyList())
    val users: StateFlow<List<UserData>> = _users

    init {
        generateDummyUsers()
    }

    private fun generateDummyUsers() {
        val userList = mutableListOf<UserData>()
        for (i in 1..60) { // Creates 60 dummy users
            userList.add(
                UserData(
                    id = UUID.randomUUID().toString(),
                    name = "User $i",
                    userName = "User Name $i",
                    email = "user$i@example.com",
                    phone = +91000000000,
                    webSite = "",
                    isSelected = listOf(true, false).random()
                )
            )
        }
        _users.value = userList
        viewModelScope.launch {
            userDao.insert(userList)
        }
    }
}
