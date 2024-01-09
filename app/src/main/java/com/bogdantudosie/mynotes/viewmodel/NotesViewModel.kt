package com.bogdantudosie.mynotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bogdantudosie.mynotes.data.Note
import com.bogdantudosie.mynotes.data.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository): ViewModel() {
    val allNotes: LiveData<List<Note>> = repository.getAllNotes()
    val foundNote = repository.foundNote
    fun insert (note: Note) = viewModelScope.launch {
        repository.insert(note)
    }
    fun update ( note: Note ) = viewModelScope.launch {
        repository.update(note)
    }
    fun delete (note: Note ) = viewModelScope.launch {
        repository.delete(note)
    }
}

class NoteViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}