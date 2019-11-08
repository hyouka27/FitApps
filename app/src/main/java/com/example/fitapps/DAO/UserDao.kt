package com.example.fitapps.DAO
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface UserDao {

    @Dao
    interface UserDao {
        @Insert
        fun insert(first_name: User)
        @Query("SELECT * FROM UserApps ORDER BY uid ASC")
        fun getAll(): List<User>

        @Query("SELECT * FROM UserApps WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1")
        fun findByName(first: String, last: String): User
        @Delete
        @Query("DELETE FROM UserApps")
        fun delete(user: User)
    }
}