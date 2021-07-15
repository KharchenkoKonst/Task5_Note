package com.example.task5_note.repository

import android.content.Context
import com.example.task5_note.model.database.AppDatabase
import com.example.task5_note.model.models.Note
import kotlinx.coroutines.coroutineScope

class RepositoryImpl(context: Context) : INoteRepository {
    private val dao = AppDatabase.getDatabase(context).noteDao()

    override suspend fun insertNote(note: Note) {
        dao.insert(note)
    }

    override suspend fun updateNote(note: Note) {
        dao.update(note)
    }

}