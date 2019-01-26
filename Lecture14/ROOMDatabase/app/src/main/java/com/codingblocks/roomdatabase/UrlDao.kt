package com.codingblocks.roomdatabase

import android.arch.persistence.room.Insert

interface UrlDao {

    @Insert
    fun insertUrl(url: Url): Long

}