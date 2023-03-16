package com.example.cadox.bo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
@Parcelize
data class Article(
    val id:Long,
    val intitule:String,
    val description:String,
    val prix:Double,
    val niveau:Byte,
    val url:String? = null,
    var achete :Boolean? = false,
    var dateAchat: LocalDate? = null
) : Parcelable
