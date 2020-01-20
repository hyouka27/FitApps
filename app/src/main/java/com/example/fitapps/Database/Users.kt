package com.example.fitapps.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "User")
data class Users(@PrimaryKey(autoGenerate = true) val id: Int?,
@ColumnInfo(name = "Name") val nAme: String?,
@ColumnInfo(name = "Age") val aGe: Int?,
@ColumnInfo(name = "Hight") val aHight: Int?,
@ColumnInfo(name = "Gross") val gRoss: Int?)


