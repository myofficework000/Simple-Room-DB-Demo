package com.example.firstroomdbproject.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MIGRATION_2_3 : Migration(2,3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        //add new column to a existing table
        database.execSQL("ALTER TABLE MyUser ADD COLUMN full_name TEXT;")
    }
}