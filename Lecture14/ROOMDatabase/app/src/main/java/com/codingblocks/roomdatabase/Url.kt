package com.codingblocks.roomdatabase

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Url(
    val url: String,
    val urlDescriptiom: String,
    @PrimaryKey(autoGenerate = true)
    val urlId: Int = 0
)