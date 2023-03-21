package com.example.mod9room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod9room.bo.Patisserie
import com.example.mod9room.dao.PatisserieDao

@Database(entities = [Patisserie::class], version = 1)
abstract class PatisserieDB : RoomDatabase() {
    //Lister toutes les dao de la BDD
    abstract fun patisserieDao() : PatisserieDao
    companion object{
        private var INSTANCE : PatisserieDB? = null
        fun getInstance(context: Context):PatisserieDB{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(context,PatisserieDB::class.java,"patisserie")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}