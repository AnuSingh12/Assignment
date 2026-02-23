package com.example.assignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment.database.address.AddressDao
import com.example.assignment.database.address.AddressData
import com.example.assignment.database.user.UserDAo
import com.example.assignment.database.user.UserData

@Database(
    entities = [
        UserData::class,
        AddressData:: class
    ],

    version = 6,
    exportSchema = false
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
                    "user_database"
                ).fallbackToDestructiveMigration(false).build()

                INSTANCE = instance
                instance
            }
        }
    }
}