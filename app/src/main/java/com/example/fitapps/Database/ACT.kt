package com.example.fitapps.Database

import androidx.room.*

@Dao
interface ACT {
    @Query("SELECT * FROM Activity")
    fun getAll():List<Action>

    @Insert
    fun insertAll(vararg action: Action)

    @Delete
    fun delete(action: Action)

    @Update
    fun updateAct(vararg action: Action)


}