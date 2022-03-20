package com.example.rickandmorty

import android.content.Context
import android.content.Intent
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException

class MainActivityPresenter(private val myView:  MainActivityContract.View):
    MainActivityContract.Presenter{

    override suspend fun consumeEndpoint() {
        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()

        val characterQuery = CharacterListQuery()

        val response = try {
            apolloClient.query(characterQuery).execute()
        } catch (e: ApolloException){

            myView.errorReceived()
            null
        }
        val list = response?.data?.characters?.results?.filterNotNull()
        if(list != null && !response.hasErrors()) {
            myView.callSuccess(list)
        }else {
            myView.errorReceived()
        }
      }

    override fun logout(context: Context) {

        val sharedPref = context.getSharedPreferences(
            "login_pref",
            Context.MODE_PRIVATE
        )

        with(sharedPref.edit()) {
            putInt("value_key", 0)
            apply()
        }
        val intent = Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }


    }