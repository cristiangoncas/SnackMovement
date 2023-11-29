package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cristiangoncas.snackmovement.databinding.FragmentMovementDetailBinding
import com.cristiangoncas.snackmovement.view.viewmodel.MovementDetailViewModelImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMovementDetail : Fragment() {

    private val viewModel: MovementDetailViewModelImpl by viewModel()
    private lateinit var binding: FragmentMovementDetailBinding
    private var startingSnack: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMovementDetailBinding.inflate(inflater)
        val args: FragmentMovementDetailArgs by navArgs()
        if (args.startingSnack) {
            binding.start.visibility = View.VISIBLE
        }
        if (args.movementId > -1) {
            viewModel.fetchMovementById(args.movementId)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            state.movement?.let { movement ->
                binding.name.text = movement.name
                binding.difficulty.text = movement.difficulty.stringValue
                binding.description.text = movement.description
            }
        }
    }
}
