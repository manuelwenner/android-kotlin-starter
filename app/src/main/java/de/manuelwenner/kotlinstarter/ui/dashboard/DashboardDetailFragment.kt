package de.manuelwenner.kotlinstarter.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import de.manuelwenner.kotlinstarter.databinding.FragmentDashboardDetailBinding


class DashboardDetailFragment : Fragment() {

    private lateinit var args: DashboardDetailFragmentArgs
    private lateinit var binding: FragmentDashboardDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardDetailBinding.inflate(inflater, container, false)
        args = DashboardDetailFragmentArgs.fromBundle(requireArguments())

        val detailViewModel = ViewModelProvider(this).get(
            DashboardViewModel::class.java
        )

        detailViewModel.getHero().observe(getViewLifecycleOwner(), binding.tvWelcomeMessage::setText);
        detailViewModel.loadHero(args.hero);

        // Inflate the layout for this fragment
        return binding.root
    }
}