package com.example.firstroomdbproject.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MIGRATION_1_2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        //create a new table
        //copy of data from old table
        //remove of old table
        //rename a table

        //add new column to a existing table
        database.execSQL("ALTER TABLE MyUser ADD COLUMN middle_name TEXT;")
    }
}