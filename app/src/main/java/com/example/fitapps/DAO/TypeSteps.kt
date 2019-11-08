package com.example.fitapps.DAO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.zip.DataFormatException

class TypeSteps {
    @Entity(tableName = "TypeSteps")
    data class TypeSteps(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "Description") val DescriptionName: String?
    )
}