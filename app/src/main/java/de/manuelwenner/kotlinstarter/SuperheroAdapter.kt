package de.manuelwenner.kotlinstarter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
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

        holder.itemView.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hero", item.name)
            it.findNavController().navigate(R.id.action_navigation_dashboard_to_dashboardDetailFragment, bundle)

//            val action = DashboardFragmentDirections.actionNavigationDashboardToDashboardDetailFragment(item)
//            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
