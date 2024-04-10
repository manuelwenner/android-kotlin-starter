package de.manuelwenner.kotlinstarter.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.manuelwenner.kotlinstarter.SuperheroAdapter
import de.manuelwenner.kotlinstarter.data.Hero
import de.manuelwenner.kotlinstarter.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private lateinit var adapter: SuperheroAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val items = listOf(
            Hero(1, "Hulk", "Marvel"),
            Hero(2, "Batman", "DC"),
            Hero(3, "Captain America", "Marvel"),
        )

        recyclerView = binding.rvSuperheros
        adapter = SuperheroAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        Thread {
            // Do background work
            println("Thread Running")
        }.start()


//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}