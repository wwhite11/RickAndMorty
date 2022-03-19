package com.example.rickandmorty

import android.os.Bundle
import androidx.navigation.NavController
import com.example.rickandmorty.type.Character

class DetailsActivityPresenter(): DetailsActivityContract.Presenter{
    //initializing navigation graph of  navigation
    override fun startIgniting(character: Character, navController: NavController) {
        val bundle = Bundle()

    }
}