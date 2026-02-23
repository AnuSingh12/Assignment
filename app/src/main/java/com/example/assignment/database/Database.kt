package com.example.assignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData

@Database(
    entities = [
        UserData::class,
        AddressDao:: class
    ],
    version = 5
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAo
    abstract fun addressDao(): AddressDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_databse"
                )
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}