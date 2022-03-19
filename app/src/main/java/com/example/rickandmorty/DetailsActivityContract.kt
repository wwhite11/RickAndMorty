package com.example.rickandmorty

import androidx.navigation.NavController
import com.example.rickandmorty.type.Character


interface DetailsActivityContract {
    interface View{

    }
    interface Presenter{
        fun  startIgniting(character: Character, navController: NavController)
    }
}