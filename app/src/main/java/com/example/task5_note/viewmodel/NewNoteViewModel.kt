package com.example.task5_note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task5_note.model.models.Note
import com.example.task5_note.repository.INoteRepository
import com.example.task5_note.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class NewNoteViewModel(private val repository: INoteRepository) : ViewModel() {

    val onAttemptSaveEmptyNote = SingleLiveEvent<Unit>()
    val onSaveSuccessEvent = SingleLiveEvent<Unit>()
    fun tryToSaveNote(title: String, content: String) {
        if (title.isEmpty() || content.isEmpty()) {
            onAttemptSaveEmptyNote.call()
        } else {
            val note = Note(getCurrentDate(), title, content)
            viewModelScope.launch {
                repository.insertNote(note)
                onSaveSuccessEvent.call()
            }
        }
    }

    private fun getCurrentDate(): String {
        val date = SimpleDateFormat("dd.M.yyyy", Locale.ENGLISH)
        return date.format(Date())
    }
}