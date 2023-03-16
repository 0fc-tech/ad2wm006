package com.example.mod5navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Singe(
    val race : String,
    val nom: String,
    val age:Int,
    val couleur: String
) : Parcelable
