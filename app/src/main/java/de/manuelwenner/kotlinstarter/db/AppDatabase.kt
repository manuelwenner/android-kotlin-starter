package de.manuelwenner.kotlinstarter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import de.manuelwenner.kotlinstarter.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}