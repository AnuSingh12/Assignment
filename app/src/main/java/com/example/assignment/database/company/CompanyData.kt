package com.example.assignment.database.company

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CompanyData (
    @PrimaryKey
    @ColumnInfo(name = "company_id")
    val companyId : String,
    @ColumnInfo(name = "user_id")
    val userid : String ,
    @ColumnInfo(name = "name")
    val name: String ,
    @ColumnInfo(name = "catch_phrase")
    val catchPhrase : String,
    @ColumnInfo(name = "bs")
    val bs : String
)