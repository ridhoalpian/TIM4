package com.example.tugasdua.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE app_username = :username AND password = :password")
    fun checkUserPass(username: String, password: String): List<User>

    @Insert
    fun insertAll(vararg users: String): List<Long>

    @Delete
    fun delete(user: User)
}
