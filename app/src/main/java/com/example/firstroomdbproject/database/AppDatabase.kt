package com.example.firstroomdbproject.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.firstroomdbproject.database.dao.UserDao
import com.example.firstroomdbproject.database.entities.User
import com.example.firstroomdbproject.database.migrations.MIGRATION_1_2
import com.example.firstroomdbproject.database.migrations.MIGRATION_2_3

@Database(entities = [User::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "yur database name")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}