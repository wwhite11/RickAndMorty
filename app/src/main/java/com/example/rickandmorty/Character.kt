package com.example.rickandmorty

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Character(val id: String, val image: String, val mame: String, val species: String, val status: String) : Parcelable