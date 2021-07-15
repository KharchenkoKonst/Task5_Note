package com.example.task5_note.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.task5_note.model.models.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note WHERE id = :id")
    fun getById(id: Long): LiveData<Note>

    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<Note>>

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}
