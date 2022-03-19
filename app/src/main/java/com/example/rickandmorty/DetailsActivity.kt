package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.rickandmorty.type.Character

class DetailsActivity : AppCompatActivity(), DetailsActivityContract.View {

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    lateinit var character: Character

    lateinit var presenter: DetailsActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        presenter = DetailsActivityPresenter()


        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        presenter.startIgniting(character, navController)
    }
}