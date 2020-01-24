package com.example.fitapps.Database
import androidx.room.*

@Dao
interface DAO {
    //Wyszukuje wszystko w tabeli User
    @Query("SELECT * FROM User")
    fun getAll():List<Users>

    @Insert
    fun insertAll(vararg users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT id FROM User WHERE id = :id LIMIT 1")
    fun getItemId(id: Int?): Int?

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUsers(vararg users: Users)

    //Zapytania odniośnie wyciągania potrzebnych danych
    @Query("SELECT Name FROM User")
    fun getName():List<Users>

    @Query("SELECT Age FROM User")
    fun getAge():List<Users>

    @Query("SELECT Hight FROM User")
    fun getHight():List<Users>

    @Query("SELECT Gross FROM User")
    fun getGross():List<Users>
}
