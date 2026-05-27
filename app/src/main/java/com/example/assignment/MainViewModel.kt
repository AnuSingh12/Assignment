package com.example.assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.address.AddressData
import com.example.assignment.database.company.CompanyDao
import com.example.assignment.database.company.CompanyData
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel(
    private val userDao: UserDAo,
    private val addressDao: AddressDao,
    private val companyDao: CompanyDao
) : ViewModel() {

    private val _users = MutableStateFlow<List<UserData>>(emptyList())
    val users: StateFlow<List<UserData>> = _users

    init {
        generateDummyUsers()
    }

    private fun generateDummyUsers() {

        val userList = mutableListOf<UserData>()
        val addressList = mutableListOf<AddressData>()
        val companyList = mutableListOf<CompanyData>()

        for (i in 1..60) {

            val userId = UUID.randomUUID().toString()

            userList.add(
                UserData(
                    id = userId,
                    name = "User $i",
                    userName = "Username $i",
                    email = "user$i@gmail.com",
                    phone = 9876543210,
                    webSite = "www.user$i.com",
                    isSelected = listOf(
                        true,
                        false
                    ).random()
                )
            )

            addressList.add(
                AddressData(
                    addressId =
                        UUID.randomUUID().toString(),
                    id = userId,
                    street = "Street $i",
                    city = "Kota",
                    zipCode = "32400$i"
                )
            )

            companyList.add(
                CompanyData(
                    companyId =
                        UUID.randomUUID().toString(),
                    userid = userId,
                    name = "Company $i",
                    catchPhrase =
                        "We build future $i",
                    bs = "Business Strategy $i"
                )
            )
        }

        viewModelScope.launch {

            userDao.insert(userList)

            addressDao.insertAddress(
                addressList
            )

            companyDao.insertCompany(
                companyList
            )
        }
    }
}
