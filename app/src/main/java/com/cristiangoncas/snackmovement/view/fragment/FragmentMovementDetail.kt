package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cristiangoncas.snackmovement.databinding.FragmentMovementDetailBinding
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.view.viewmodel.MovementDetailViewModelImpl
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
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
        binding.start.setOnClickListener {
            val snack: Snack = viewModel.viewState().value?.movement?.let { movement ->
                Snack(
                    movementId = movement.id,
                    movementName = movement.name,
                    movementDifficulty = movement.difficulty,
                )
            } ?: throw Exception("FragmentMovementDetail::ViewState should contain a non null movement.")
            val action =
                FragmentMovementDetailDirections.actionFragmentMovementDetailToFragmentSnackInProgress(
                    snack = Json.encodeToString(snack),
                )
            findNavController().navigate(action)
        }
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
