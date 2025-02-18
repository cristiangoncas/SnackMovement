package com.cristiangoncas.snackmovement.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state get()= _state.asStateFlow()

    fun onUiReady(){
        viewModelScope.launch {
            _state.value = UIState(loading = true)
            _state.value = UIState(loading = false, exercises = listOf("Running","Walking","Cycling","Dancing"))
        }
    }

    data class UIState(
        val loading: Boolean = false,
        val motivationalQuote: String = "Keep going!\n\n Your doing a great job!",
        val exercises: List<String> = emptyList()
    )

}

data class Exercise (val id: Int, val name: String, val description: String)

val exercises =(1 until 10).map {
    Exercise(
        id = it,
        name="Exercise $it",
        "Description $it")
}


