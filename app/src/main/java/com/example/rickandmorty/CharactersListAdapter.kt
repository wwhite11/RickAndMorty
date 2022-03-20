package com.example.rickandmorty

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharactersListAdapter(private val dataSet: List<CharacterListQuery.Result?>) :
        RecyclerView.Adapter<CharactersListAdapter.ViewHolder>() {
            inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
                val id: TextView = view.findViewById(R.id.character_id)
                val name: TextView = view.findViewById(R.id.character_name)
                val species: TextView = view.findViewById(R.id.character_species)
                val image: ImageView = view.findViewById(R.id.character_photo)
                val character: ConstraintLayout = view.findViewById(R.id.character_row)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.characters_row_item, parent,  false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet[position]
        holder.id.text = "ID is : " + data!!.id
        holder.name.text = data.name
        holder.species.text = data.species
        val iconUrl = data.image
        Glide.with(holder.image.context).load(iconUrl).into(holder.image)
        holder.character.setOnClickListener{
            var intent = Intent(holder.character.context, DetailsActivity::class.java)
            var character = Character(data.id!!, data.image!!, data.name!!, data.species!!, data.status!!)
            intent.putExtra("character", character)
            holder.character.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
        }