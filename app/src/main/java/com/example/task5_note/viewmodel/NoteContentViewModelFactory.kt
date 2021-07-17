package com.example.task5_note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task5_note.model.models.Note
import com.example.task5_note.repository.RepositoryImpl

class NoteContentViewModelFactory(private val repository: RepositoryImpl, private val note: Note?) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        NoteContentViewModel(repository, note) as T
}