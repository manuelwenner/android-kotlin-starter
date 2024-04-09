package de.manuelwenner.kotlinstarter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.manuelwenner.kotlinstarter.data.Hero

class SuperheroAdapter(private val items: List<Hero>) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.superhero_item_layout, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTextView.text = item.name
        holder.itemTeam.text = item.team
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
