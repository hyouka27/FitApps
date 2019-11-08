package com.example.fitapps.DAO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.zip.DataFormatException

class Steps {

    @Entity(tableName = "MySteps")
    data class Steps(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name="activity_type") val activityType: Int?,
        @ColumnInfo(name="Start") val StartSteps: Int?,
        @ColumnInfo(name = "End") val EndSteps: Int?,
        @ColumnInfo(name = "Description") val DescriptionName: String?,
        @ColumnInfo(name="Time") val TimeSteps: Int?,
        @ColumnInfo(name="Calories") val CaloriesSteps: Int?,
        @ColumnInfo(name="Date") val DateSteps: DataFormatException?
    )
}