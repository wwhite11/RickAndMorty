package com.example.rickandmorty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton


class DetailsFragment : Fragment(), DetailsFragmentContract.View {

    lateinit var presenter: DetailsFragmentContract.Presenter
    lateinit var image: ImageView
    lateinit var back: ImageView
    lateinit var status: TextView
    private lateinit var logout: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        image = view.findViewById(R.id.details_fragment_image)
        back = view.findViewById(R.id.details_fragment_back)
        status = view.findViewById(R.id.details_fragment_status)
        logout = view.findViewById(R.id.details_fragment_logout)

        presenter = DetailsFragmentPresenter(this)

        var character: Character? = requireArguments().getParcelable("character") as Character?

        presenter.populateData(character!!, status, image, requireContext())

        back.setOnClickListener{
            requireActivity().finish()
        }

        logout.setOnClickListener {
            presenter.logout(requireContext())
            requireActivity().finish()
        }
        return view
    }


}