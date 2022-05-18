package com.example.firstroomdbproject.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyUser")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "middle_name") val middleName: String?,
    @ColumnInfo(name = "full_name") val fullName: String?,
) {
    constructor(firstName: String, lastName: String, middleName: String?, fullName: String?) : this(
        0,
        firstName,
        lastName,
        middleName ?: "default value",
        fullName = fullName ?: "default value"
    )
}
