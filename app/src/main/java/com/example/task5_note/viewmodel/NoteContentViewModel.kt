package com.example.task5_note.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task5_note.model.models.Note
import com.example.task5_note.repository.INoteRepository
import com.example.task5_note.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class NoteContentViewModel(private val repository: INoteRepository, private val note: Note?) :
    ViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    val onSaveNoteSuccessful = SingleLiveEvent<Unit>()
    val onErrorSaveNote = SingleLiveEvent<Unit>()

    init {
        note?.let {
            title.value = it.title
            content.value = it.content
        }
    }

    fun saveNote() {
        val title: String = this.title.value.toString()
        val content: String = this.content.value.toString()

        if (title.isEmpty() || content.isEmpty()) {
            onErrorSaveNote.call()
            return
        }

        when (note) {
            null -> {
                val note = Note(getCurrentDate(), title, content)
                viewModelScope.launch { repository.insertNote(note) }
            }
            else -> {
                note.setNoteTitle(title)
                note.setNoteContent(content)
                viewModelScope.launch { repository.updateNote(note) }
            }
        }
        onSaveNoteSuccessful.call()
    }

    private fun getCurrentDate(): String {
        val date = SimpleDateFormat("dd.M.yyyy", Locale.ENGLISH)
        return date.format(Date())
    }
}