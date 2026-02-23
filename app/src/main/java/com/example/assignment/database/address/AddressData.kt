package com.example.assignment.database.address

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class AddressData(
    @PrimaryKey
    @ColumnInfo(name = "address_id")
    val addressId : String,
    @ColumnInfo(name = "user_id")
    val id : String,
    @ColumnInfo(name = "street")
    val street : String,
    @ColumnInfo(name = "city")
    val city  : String,
    @ColumnInfo(name = "zip_code")
    val zipCode :String
)