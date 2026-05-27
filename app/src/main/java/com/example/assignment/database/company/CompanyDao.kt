package com.example.assignment.database.company

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyDao {
    @Upsert
    suspend fun insertCompany(company: List<CompanyData>)

    @Query("SELECT * FROM companyData")
    fun getCompanies(): Flow<List<CompanyData>>

    @Query("SELECT * FROM companyData WHERE user_id = :userId")
    fun getCompanyByUserId(userId: String): Flow<CompanyData?>
}