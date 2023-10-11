package com.cristiangoncas.snackmovement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cristiangoncas.snackmovement.databinding.FragmentGroupsBinding

class FragmentGroups : Fragment() {

    private lateinit var binding: FragmentGroupsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentGroupsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.groupStatistics.setOnClickListener { findNavController().navigate(R.id.action_fragmentGroups_to_fragmentGroupStatistics) }
        binding.groupDetails.setOnClickListener { findNavController().navigate(R.id.action_fragmentGroups_to_fragmentGroupDetails) }
    }
}
