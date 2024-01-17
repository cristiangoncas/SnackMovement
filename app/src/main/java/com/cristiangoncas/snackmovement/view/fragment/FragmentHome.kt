package com.cristiangoncas.snackmovement.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cristiangoncas.snackmovement.databinding.FragmentHomeBinding
import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.view.adapter.SnackLogAdapter
import com.cristiangoncas.snackmovement.view.viewmodel.HomeViewModelImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentHome : Fragment() {

    private val viewModel: HomeViewModelImpl by viewModel()

    private val adapter: SnackLogAdapter = SnackLogAdapter()
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
        binding.logList.adapter = adapter

        viewModel.viewState().observe(
            viewLifecycleOwner,
        ) { state ->
            adapter.updateList(state.snackLog as ArrayList<SnackLog>)
            binding.todayCounter.text = state.todaySnackCount.toString()
            binding.yesterdayCounter.text = state.yesterdaySnackCount.toString()
            binding.averageCounter.text = state.averageSnackCount.toString()
        }
    }
}
