package com.example.zoo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Animal (
    val color: String,
    val size : String,
    val weight: String) : Parcelable





