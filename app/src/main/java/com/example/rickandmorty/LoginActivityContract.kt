package com.example.rickandmorty

import android.content.Context

interface LoginActivityContract {
    interface View{

    }
    interface Presenter{
        fun checkLogin(context: Context):Boolean
        fun makeLogin(context: Context)
    }
}