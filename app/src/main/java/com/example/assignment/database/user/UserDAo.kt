package com.example.assignment.database.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAo {
    @Upsert
    suspend fun insert(users: MutableList<UserData>)

    @Query("SELECT * FROM user_data ")
    fun getUserData() : Flow<List<UserData>>

}