package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.findNavController
import com.cristiangoncas.snackmovement.databinding.FragmentChallengesBinding
import com.cristiangoncas.snackmovement.view.adapter.ChallengesAdapter
import com.cristiangoncas.snackmovement.view.viewmodel.ChallengesViewModelImpl

class FragmentChallenges : Fragment() {

    private val viewModel: ChallengesViewModelImpl by viewModel()
    private val adapter: ChallengesAdapter = ChallengesAdapter()
    private lateinit var binding: FragmentChallengesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChallengesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.challengesGrid.adapter = adapter
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            println("Count: ${state.movements.size}")
            adapter.updateList(state.movements)
        }
    }
}
