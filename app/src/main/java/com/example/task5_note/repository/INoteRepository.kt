package com.example.task5_note.repository

import androidx.lifecycle.LiveData
import com.example.task5_note.model.models.Note


interface INoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    fun getAllData(): LiveData<List<Note>>
}
