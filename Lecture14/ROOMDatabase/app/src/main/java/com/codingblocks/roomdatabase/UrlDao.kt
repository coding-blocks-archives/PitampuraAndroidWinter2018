package com.codingblocks.roomdatabase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

@Dao
interface UrlDao {

    @Insert
    fun insertUrl(url: Url): Long

}