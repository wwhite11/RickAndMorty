package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity(), LoginActivityContract.View {
    //Seperation: all of the business logic is in presenter class

    lateinit var login: MaterialButton
    private lateinit var presenter: LoginActivityContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginActivityPresenter()

        login = findViewById(R.id.login_login)

        if (presenter.checkLogin(this)){
            finish()
        }
        login.setOnClickListener{
            //all of work is done in login presenter
            presenter.makeLogin(this)
            finish()
        }
    }
}