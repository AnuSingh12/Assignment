package com.example.assignment.ui.screen.user_list

import android.util.Log
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

    companion object {
        private const val TAG = "home_vm"
    }

    private val _userData = MutableStateFlow<List<UserData>>(emptyList())
    val userData = _userData.asStateFlow()

    fun readUserData(){
        viewModelScope.launch {
            userDao.getUserData().collect {data ->
                _userData.value = data
                Log.d(TAG , "$data")

            }
        }
    }

    private val _selected = MutableStateFlow(false)
    val selected = _selected.asStateFlow()
    fun updateSelected(){
        viewModelScope.launch {
            updateSelected()
        }
    }

    init {
        readUserData()
    }

}