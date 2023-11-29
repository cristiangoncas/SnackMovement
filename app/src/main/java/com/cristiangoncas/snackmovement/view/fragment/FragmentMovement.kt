package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cristiangoncas.snackmovement.databinding.FragmentMovementsBinding
import com.cristiangoncas.snackmovement.view.adapter.MovementsAdapter
import com.cristiangoncas.snackmovement.view.viewmodel.MovementsViewModelImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMovement : Fragment() {

    private val viewModel: MovementsViewModelImpl by viewModel()
    private lateinit var adapter: MovementsAdapter
    private lateinit var binding: FragmentMovementsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMovementsBinding.inflate(inflater)
        val args: FragmentMovementArgs by navArgs()
        adapter = MovementsAdapter { movement ->
            val action =
                FragmentMovementDirections.actionFragmentMovementsToFragmentMovementDetail(
                    startingSnack = args.startingSnack,
                    movementId = movement.id,
                )
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movementsGrid.adapter = adapter
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
