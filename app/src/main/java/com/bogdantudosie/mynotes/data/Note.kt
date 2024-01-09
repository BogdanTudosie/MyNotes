package com.bogdantudosie.mynotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(@PrimaryKey(autoGenerate = true)
                val id: Long = 0,
                var name: String,
                var content: String,
                var dateCreated: Date)
