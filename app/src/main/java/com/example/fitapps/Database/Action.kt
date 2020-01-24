package com.example.fitapps.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*


//Schemat bazy danych Aktywności
@Entity(tableName = "Activity")
data class Action(
                  @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Date") val dAte: Int?,
                  @ColumnInfo(name = "Name") val nAmes: String?,
                  @ColumnInfo(name = "Type") val aType: Int?,
                  @ColumnInfo(name = "Calo") val cAlo: Int?,
                  @ColumnInfo(name = "Steps") val sTeps: Int?,
                  @ColumnInfo(name = "Time") val tIme: Int?){

    constructor(): this(null,"",1,0,0,0)
}