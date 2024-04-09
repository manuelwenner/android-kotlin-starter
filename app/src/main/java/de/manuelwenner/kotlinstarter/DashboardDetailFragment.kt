package de.manuelwenner.kotlinstarter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.manuelwenner.kotlinstarter.databinding.FragmentDashboardDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDashboardDetailBinding.inflate(inflater, container, false)
        val hero = arguments?.getString("hero")
        binding.tvWelcomeMessage.text = "Welcome ${hero}"
        // Inflate the layout for this fragment
        return binding.root
    }

}