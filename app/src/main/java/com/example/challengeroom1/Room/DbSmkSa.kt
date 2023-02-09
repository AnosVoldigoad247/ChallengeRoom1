package com.example.challengeroom1.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TbSiswa::class], version = 1)
abstract class DbSmkSa : RoomDatabase(){
    abstract fun Siswao() : TbSiswaDao

    companion object{
        @Volatile private var instance : DbSmkSa? = null
        private var Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DbSmkSa::class.java,
            "smksa.db"
        ).build()
    }
}