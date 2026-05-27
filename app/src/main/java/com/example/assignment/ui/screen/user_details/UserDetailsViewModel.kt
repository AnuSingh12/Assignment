package com.example.assignment.ui.screen.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.address.AddressData
import com.example.assignment.database.company.CompanyDao
import com.example.assignment.database.company.CompanyData
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao,
    private val companyDao: CompanyDao
) : ViewModel() {

    private val _singleUserData = MutableStateFlow<UserData?>(null)
    val singleUserData = _singleUserData.asStateFlow()

    private val _addressData = MutableStateFlow<AddressData?>(null)
    val addressData = _addressData.asStateFlow()

    private val _companyData = MutableStateFlow<CompanyData?>(null)
    val companyData = _companyData.asStateFlow()

    fun readData(id: String) {

        viewModelScope.launch {
            userDao.getSingleUser(id)
                .collect { data ->
                    _singleUserData.value = data
                }
        }

        viewModelScope.launch {
            addressDao.getAddressByUserId(id)
                .collect { data ->
                    _addressData.value = data
                }
        }

        viewModelScope.launch {
            companyDao.getCompanyByUserId(id)
                .collect { data ->
                    _companyData.value = data
                }
        }
    }
}