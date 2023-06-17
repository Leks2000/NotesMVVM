package com.example.notesmvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.notesmvvm.utils.Constants.Keys.NOTES_TABLE


@Entity(tableName = NOTES_TABLE)
data class Note @Ignore constructor(@PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var title: String = "",
    @ColumnInfo
    var subtitle: String = "",
    var firebaseId: String = ""
) {
    constructor() : this(0,"", "","")
}