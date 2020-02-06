package com.example.zoo

import kotlinx.android.synthetic.main.activity_description.view.*
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_species.view.*
import kotlinx.android.synthetic.main.activity_description.view.*

class AnimalAdapter(val AnimalList : ArrayList<Animal>) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_recycler, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    //override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    // ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false))

    override fun getItemCount() = AnimalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateItem(AnimalList[position])

    }

    fun addAnimalToList(animal: Animal) {
        AnimalList.add(animal)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun populateItem(animal: Animal) {
            itemView.tvColor.text = animal.color
            itemView.tvSize.text = animal.size
            itemView.tvWeight.text = animal.weight
            itemView.setOnClickListener {
                val intent = Intent(it.context, Animal::class.java)
                intent.putExtra(Key_ANIMAL, animal)
                it.context.startActivity(intent)
            }
        }
    }


}
