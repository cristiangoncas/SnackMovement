package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.FragmentHomeBinding
import com.cristiangoncas.snackmovement.view.adapter.TopChallengesAdapter
import com.cristiangoncas.snackmovement.view.viewmodel.HomeViewModelImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentHome : Fragment() {

    private val viewModel: HomeViewModelImpl by viewModel()

    private val adapter: TopChallengesAdapter = TopChallengesAdapter()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statistics.setOnClickListener { findNavController().navigate(R.id.action_fragmentMain_to_fragmentStatistics) }
        binding.challenges.setOnClickListener { findNavController().navigate(R.id.action_fragmentMain_to_fragmentChallenges) }
        binding.topList.adapter = adapter

        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            adapter.updateList(state.topList)
            binding.todayCounter.text = state.todaySnackCount.toString()
            binding.yesterdayCounter.text = state.yesterdaySnackCount.toString()
            binding.averageCounter.text = state.averageSnackCount.toString()
        }
    }
}
