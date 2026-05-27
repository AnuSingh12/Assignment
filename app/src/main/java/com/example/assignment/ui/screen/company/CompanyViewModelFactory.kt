package com.example.assignment.ui.screen.company

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.database.company.CompanyDao

class CompanyViewModelFactory(
    private val companyDao: CompanyDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompanyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CompanyViewModel(companyDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}