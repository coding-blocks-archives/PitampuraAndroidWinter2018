package com.codingblocks.roomdatabase

import android.arch.persistence.room.*

@Entity(tableName = "notesTable")
open class Note(
//    @Ignore //Excludes this column and its values from the database
    @ColumnInfo(name = "note_title")
    val title: String,
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @Embedded
    val url: Url
)