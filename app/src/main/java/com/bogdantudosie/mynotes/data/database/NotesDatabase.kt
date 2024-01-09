package com.bogdantudosie.mynotes.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bogdantudosie.mynotes.data.dao.NoteDao

public abstract class NotesDatabase: RoomDatabase() {
    abstract fun notesDao(): NoteDao

    // companion object for singleton instance
    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                                    NotesDatabase::class.java,
                              "notes").build()
                INSTANCE = instance
                instance
            }
        }
    }
}