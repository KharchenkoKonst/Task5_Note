package com.example.task5_note.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.task5_note.repository.INoteRepository
import com.example.task5_note.repository.RepositoryImpl

class TitleNotesViewModel(private val repository: INoteRepository) : ViewModel() {
}