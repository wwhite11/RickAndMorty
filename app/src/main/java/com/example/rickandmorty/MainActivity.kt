package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var presenter: MainActivityContract.Presenter

    lateinit var charactersListAdapter: CharactersListAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressbar: CircularProgressIndicator
    lateinit var errorText: MaterialTextView
    lateinit var logout: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
        logout = findViewById(R.id.main_logout)
        errorText = findViewById(R.id.main_error_text)
        progressbar = findViewById(R.id.main_progressbar)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        logout.setOnClickListener{
            presenter.logout(this)
            finish()
        }

        lifecycleScope.launchWhenResumed {
            presenter.consumeEndpoint()
        }
    }

    override fun errorReceived() {
        progressbar.visibility = View.GONE
        errorText.visibility = View.VISIBLE
    }

    override fun callSuccess(list: List<CharacterListQuery.Result?>) {
        charactersListAdapter = CharactersListAdapter(list)
        recyclerView.adapter = charactersListAdapter
        errorText.visibility = View.GONE
        progressbar.visibility = View.GONE

    }
}