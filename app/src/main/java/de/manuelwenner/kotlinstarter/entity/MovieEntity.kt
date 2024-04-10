package de.manuelwenner.kotlinstarter.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    @ColumnInfo(name = "summary") val overview: String
) {
    constructor(title: String, overview: String) : this(0, title, overview)
}


