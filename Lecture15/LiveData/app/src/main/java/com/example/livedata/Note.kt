package com.example.livedata

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)