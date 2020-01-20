package com.example.fitapps.Database

import android.app.LauncherActivity
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DAO {
    @Query("SELECT * FROM User")
    fun getAll():List<Users>


    @Insert
    fun insertAll(vararg users: Users)

    @Delete
    fun delete(users: Users)

    @Update
    fun updateUsers(vararg users: Users)

    @Query("SELECT Name FROM User")
    fun getName():List<Users>

    @Query("SELECT Age FROM User")
    fun getAge():List<Users>

    @Query("SELECT Hight FROM User")
    fun getHight():List<Users>

    @Query("SELECT Gross FROM User")
    fun getGross():List<Users>


}
