package com.codingblocks.roomdatabase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

@Dao
interface FavNotesDao {

    @Insert
    fun insertFavNote(note: FavouriteNote): Long

}