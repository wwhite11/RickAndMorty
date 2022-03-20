package com.example.rickandmorty

import android.content.Context
import android.widget.ImageView
import android.widget.TextView

interface DetailsFragmentContract {
    interface View{

    }

    interface Presenter{
        fun populateData(character: Character, textView: TextView, imageView: ImageView, context: Context)
        fun logout(context: Context)
    }
}