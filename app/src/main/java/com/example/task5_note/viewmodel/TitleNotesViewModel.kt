package com.example.task5_note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.task5_note.model.models.Note
import com.example.task5_note.repository.INoteRepository

class TitleNotesViewModel(private val repository: INoteRepository) : ViewModel() {

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllData()
    }
}