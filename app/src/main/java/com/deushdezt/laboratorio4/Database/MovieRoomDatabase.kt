package com.deushdezt.laboratorio4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.deushdezt.laboratorio4.Database.DAO.MovieDao
import com.deushdezt.laboratorio4.Database.pojos.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Movie::class], version = 1, exportSchema = false)
public abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao():MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getInstance(
            context: Context
        ): MovieRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, MovieRoomDatabase::class.java, "Movie_Database")
                    .build()
                INSTANCE=instance
                return instance
            }

        }

    }

}
