package com.example.task5_note.repository

import com.example.task5_note.model.models.Note


interface INoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
}
