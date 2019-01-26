package com.codingblocks.roomdatabase

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class FavouriteNote(
    @ColumnInfo(name = "fav_title")
    val title: String,
    @ColumnInfo(name = "fav_desc")
    val description: String,
    @ColumnInfo(name = "fav_time")
    val time: Long,
    @PrimaryKey(autoGenerate = true)
    val favId: Int = 0
) {
}