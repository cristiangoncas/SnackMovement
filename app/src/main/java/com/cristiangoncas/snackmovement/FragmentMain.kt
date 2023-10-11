package com.cristiangoncas.snackmovement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cristiangoncas.snackmovement.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statistics.setOnClickListener { findNavController().navigate(R.id.action_fragmentMain_to_fragmentStatistics) }
        binding.challenges.setOnClickListener { findNavController().navigate(R.id.action_fragmentMain_to_fragmentChallenges) }
        binding.groups.setOnClickListener { findNavController().navigate(R.id.action_fragmentMain_to_fragmentGroups) }
    }
}
