package com.example.tugasdua.database

//data class User(val id: Int, val username_github: String, val email: String, val username: String, val password: String)

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")

data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "github_username") val githubUsername: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "app_username") val appUsername: String?,
    @ColumnInfo(name = "password") val password: String?
)

