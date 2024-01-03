package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cristiangoncas.snackmovement.databinding.FragmentSnackInProgressBinding
import com.cristiangoncas.snackmovement.view.viewmodel.SnackInProgressViewModelImpl
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentSnackInProgress : Fragment() {

    private val viewModel: SnackInProgressViewModelImpl by viewModel()
    private lateinit var binding: FragmentSnackInProgressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSnackInProgressBinding.inflate(inflater)
        val args: FragmentSnackInProgressArgs by navArgs()
        viewModel.setSnack(Json.decodeFromString(args.snack))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.done.setOnClickListener {
            viewModel.markAsDone()
            val action =
                FragmentSnackInProgressDirections.actionFragmentSnackInProgressToFragmentHome()
            findNavController().navigate(action)
        }
        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            if (!binding.countDown.text.contentEquals(state.timeLeft)) {
                binding.countDown.text = state.timeLeft
            }
        }
    }
}
