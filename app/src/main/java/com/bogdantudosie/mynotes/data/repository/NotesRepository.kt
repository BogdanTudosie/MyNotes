package com.bogdantudosie.mynotes.data.repository

import android.support.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bogdantudosie.mynotes.data.Note
import com.bogdantudosie.mynotes.data.dao.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesRepository(private val notesDao: NoteDao) {

    val foundNote = MutableLiveData<Note>()
    fun getAllNotes(): LiveData<List<Note>> = notesDao.getAllNotes()

    // add a coroutine
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insert(note: Note) {
        coroutineScope.launch(Dispatchers.IO) {
            notesDao.insertNote(note)
        }
    }

    fun update(note: Note) {
        coroutineScope.launch(Dispatchers.IO) {
            notesDao.updateNote(note)
        }
    }

    fun delete(note: Note) {
        coroutineScope.launch(Dispatchers.IO) {
            notesDao.deleteNote(note)
        }
    }
}