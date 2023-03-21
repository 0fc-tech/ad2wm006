package com.example.mod9room.dao

import androidx.room.*
import com.example.mod9room.bo.Patisserie
@Dao
interface PatisserieDao {
    @Insert
    fun insert(patisserie: Patisserie) : Long

    @Insert
    fun insertAll(patisseries: List<Patisserie>) : List<Long>

    @Query("SELECT * FROM Patisserie")
    fun getAllPatisseries() : List<Patisserie>
    @Query("SELECT * FROM Patisserie WHERE id = :id")
    suspend fun getPatisserie(id : Long) : Patisserie

    @Update
    fun update(patisserie:Patisserie) : Int
    @Delete
    fun delete(patisserie:Patisserie) : Int
}