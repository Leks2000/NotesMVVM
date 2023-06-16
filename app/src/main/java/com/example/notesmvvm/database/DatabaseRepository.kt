package com.example.notesmvvm.database

import androidx.lifecycle.LiveData
import com.example.notesmvvm.model.Note

interface DatabaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)

    fun signOut() {

    }
    fun connectToDataBase(onSuccess: () -> Unit, onFail: (String) -> Unit) {

    }
}