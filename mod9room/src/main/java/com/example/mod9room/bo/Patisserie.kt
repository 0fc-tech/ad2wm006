package com.example.mod9room.bo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patisserie(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val nom : String,
    val origine : String,
    @ColumnInfo(name = "qte_sucre")
    val qteSucre : Float,
    @ColumnInfo(name = "sans_lactose")
    val sansLactose : Boolean = false,
    val calorie : Int
)
