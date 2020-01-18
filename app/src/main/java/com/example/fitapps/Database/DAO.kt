package com.example.fitapps.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAO {

    @Query("SELECT * FROM User where Email= :mail and Password= :password")
    fun getUser(mail: String?, password: String?): Users?

    @Insert
    fun insert(user: Users?)

    @Query("SELECT * from User ORDER BY Age ASC")
    fun getAlphabetizedWords(): List<Users>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Users)

    @Query("DELETE FROM User")
    suspend fun deleteAll()

}