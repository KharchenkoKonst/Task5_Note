package com.example.task5_note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task5_note.repository.RepositoryImpl

class NewNoteViewModelFactory(private val repository: RepositoryImpl) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        NewNoteViewModel(repository) as T
}