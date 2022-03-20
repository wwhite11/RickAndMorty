package com.example.rickandmorty

import androidx.navigation.NavController


interface DetailsActivityContract {
    interface View{

    }
    interface Presenter{
        fun  startIgniting(character: Character, navController: NavController)
    }
}