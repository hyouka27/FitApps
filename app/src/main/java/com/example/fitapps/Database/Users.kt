package com.example.fitapps.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User")
data class Users(@PrimaryKey @ColumnInfo(name = "Name")
val nAme: String, @ColumnInfo(name = "Email")
val eMail: String, @ColumnInfo(name = "Password")
val pAssword: String, @ColumnInfo(name = "Age")
val aGe: Int)