package com.example.assignment.ui.screen.company

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.database.company.CompanyDao
import com.example.assignment.database.company.CompanyData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompanyViewModel(
    private val companyDao: CompanyDao
) : ViewModel() {

    private val _companyList = MutableStateFlow<List<CompanyData>>(emptyList())
    val companyList = _companyList.asStateFlow()

    init {
        readCompany()
    }

    private fun readCompany() {

        viewModelScope.launch {
            companyDao
                .getCompanies()
                .collect { data ->
                    _companyList.value = data
                }
        }
    }
}