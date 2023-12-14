package com.d121211021.hogwarts.data.models

import android.os.Parcelable
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
@Serializable
data class Wand(
    val core: String,
    val length: Double,
    val wood: String
) :Parcelable