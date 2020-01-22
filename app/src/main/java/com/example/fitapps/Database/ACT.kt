package com.example.fitapps.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ACT {
    @Query("SELECT * FROM Activity")
    fun getAll():List<Action>

    @Insert
    fun insertAll(vararg action: Action)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(action: Action)

    @Delete
    fun delete(action: Action)

    @Update
    fun updateAct(vararg action: Action)

    @Query("SELECT Name FROM Activity")
    fun getName():List<Action>

    @Query("SELECT Type FROM Activity")
    fun getType():List<Action>

    @Query("SELECT Calo FROM Activity")
    fun getCalo():List<Action>

    @Query("SELECT Steps FROM Activity")
    fun getSteps():List<Action>


    @Query("SELECT Time FROM Activity")
    fun getTime():List<Action>

    @Query("SELECT Date FROM Activity")
    fun getDate():List<Action>

    @Query("SELECT * FROM Activity ORDER BY dAte DESC")
    fun allAction(): LiveData<List<Action>>
}