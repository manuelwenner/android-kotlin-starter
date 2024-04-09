package de.manuelwenner.kotlinstarter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemNameTextView: TextView = itemView.findViewById(R.id.superheroName)
    val itemTeam: TextView = itemView.findViewById(R.id.superheroTeam)
}