package com.example.firstroomdbproject.database.dao

import androidx.room.*
import com.example.firstroomdbproject.database.entities.User

@Dao
interface UserDao {

    @Query("Select * FROM MyUser")
    fun getUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM MyUser WHERE uid = :id")
    fun deleteById(id: Long)

    @Update
    fun updateUser(user: User)
}