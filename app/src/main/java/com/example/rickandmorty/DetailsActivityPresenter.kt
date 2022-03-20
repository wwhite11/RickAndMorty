package com.example.rickandmorty

import android.os.Bundle
import androidx.navigation.NavController

class DetailsActivityPresenter(): DetailsActivityContract.Presenter{
    //initializing navigation graph of  navigation

    override fun startIgniting(
        character: Character,
        navController: NavController
    ) {
        val bundle = Bundle()
        bundle.putParcelable("character", character)
        navController.setGraph(R.navigation.nav_graph, bundle)
    }
}