package com.example.rickandmorty

import android.content.Context

interface MainActivityContract {
    interface View{
        fun errorReceived()
        fun callSuccess(list: List<CharacterListQuery.Result?>)
    }
    interface Presenter{
        suspend fun consumeEndpoint()
        fun logout(context: Context)
    }
}