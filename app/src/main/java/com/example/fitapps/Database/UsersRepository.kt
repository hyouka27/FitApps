package com.example.fitapps.Database

import androidx.lifecycle.LiveData

class UsersRepository(private val dAO: DAO)

{

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: List<Users> = dAO.getAlphabetizedWords()

    suspend fun insert(word: Users) {
        dAO.insert(word)
    }
}