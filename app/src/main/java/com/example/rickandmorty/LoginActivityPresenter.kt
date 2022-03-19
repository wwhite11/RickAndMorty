package com.example.rickandmorty

import android.content.Context
import android.content.Intent


class LoginActivityPresenter(): LoginActivityContract.Presenter {
    //Checking if user if logged in or not
    //getting value from shared preference
    //0 means user is not logged in
    //if user is not logged in, we'll keep them on login screen
    //but if user is logged in, we'll redirect them to main activity
    override fun checkLogin(context: Context): Boolean{
        // reading  Shared preferences
        val sharedPref =
            context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val check = sharedPref.getInt(context.getString(R.string.login_value_key),0)
        //if it's not zero, that means user is logged in
        //redirect them to main activity
        if (check != 0){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            return true
        }
        //returning false because on basis of this return value
        // we decide if we need to close login activity or not
        //if user is logged in, redirect them to main activity and close the current activity
        return false
    }
    override fun makeLogin(context: Context){
        //user has pressed login button on login activity
        // write a value 99 in shared preference
        // so that next time i can just login user
        val sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putInt(context.getString(R.string.login_value_key), 99)
            apply()
        }
        // redirect them to main activity
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}