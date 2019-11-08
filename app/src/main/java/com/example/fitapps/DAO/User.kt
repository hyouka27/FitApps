package com.example.fitapps.DAO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class User {
    @Entity(tableName = "UserApps")
    data class User(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "first_name") val firstName: String?,
        @ColumnInfo(name = "last_name") val lastName: String?,
        @ColumnInfo(name="weight") val weightName: Int?,
        @ColumnInfo(name="rise") val riseName: Int?,
        @ColumnInfo(name = "age") val ageName: Int?,
        @ColumnInfo(name = "gender") val genderName: String?
    )
}