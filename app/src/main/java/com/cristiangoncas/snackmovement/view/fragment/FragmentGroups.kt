package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.FragmentGroupsBinding
import com.cristiangoncas.snackmovement.view.adapter.GroupsAdapter
import com.cristiangoncas.snackmovement.view.viewmodel.GroupsViewModelImpl

class FragmentGroups : Fragment() {

    private val viewModel: GroupsViewModelImpl by viewModels()
    private val adapter: GroupsAdapter = GroupsAdapter()
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
        binding.groupsList.adapter = adapter

        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            adapter.updateList(state.groupsList)
        }
        viewModel.loadGroups()
    }
}
