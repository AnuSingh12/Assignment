package com.example.assignment.database.address

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Upsert
    suspend fun insertAddress(address: List<AddressData>)

    @Query("SELECT * FROM address WHERE user_id = :userId")
    fun getAddressByUserId(userId: String): Flow<AddressData?>
}