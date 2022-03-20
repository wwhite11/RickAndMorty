package com.example.rickandmorty

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsFragmentPresenter(private val view: DetailsFragmentContract.View): DetailsFragmentContract.Presenter{
    override fun populateData(
        character: Character,
        textView: TextView,
        imageView: ImageView,
        context: Context
    ) {
        textView.text = "Status: ${character!!.status}"
        Glide.with(context).load(character.image).into(imageView)
    }

    override fun logout(context: Context) {
        val sharedPref = context.getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putInt("value_key", 0)
            apply()
        }

        val intent = Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }
}