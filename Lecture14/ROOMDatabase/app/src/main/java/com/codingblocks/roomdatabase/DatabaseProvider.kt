package com.codingblocks.roomdatabase

import android.content.ContentProvider
import android.content.ContentValues
import android.net.Uri

/**
 * Content providers are started before your app is started, so feel free to do some computations that require a context here
 *
 * Uses of Content Providers :
 * 1. These are used to share data across different apps
 * 2. To create observable queries/cursors
 */
class DatabaseProvider : ContentProvider() {

    override fun insert(uri: Uri, values: ContentValues?) = null

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ) = null

    override fun onCreate(): Boolean {
        context?.let {
            Utils.getRoomDb(it).getNoteDao().getAllNotes()
        }
        return true
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?) = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) = 0

    override fun getType(uri: Uri) = null
}