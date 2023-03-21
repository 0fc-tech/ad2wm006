package com.example.mod9room

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.mod9room.bo.Patisserie
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PatisserieDBTest {
    lateinit var db : PatisserieDB
    @Before
    fun createDB(){
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            PatisserieDB::class.java
        ).build()
    }
    @Test
    fun addPatisserie(){
        val id = db.patisserieDao().insert(Patisserie(
            0,
            "Pain au chocolat",
            "France",
            999f,
            false,9999
        ))
        assert(id == 1L)
        val id2 = db.patisserieDao().insert(Patisserie(
            0,
            "Croissant",
            "France",
            999f,
            false,9999
        ))
        assert(id2 == 2L)
    }
}