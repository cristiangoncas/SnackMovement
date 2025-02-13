package com.cristiangoncas.snackmovement.ui.screens.exercisedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExerciseDetailViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState(exercise = null))
    val state = _state.asStateFlow()

    fun onUiReady(exerciseId: Int) {
        viewModelScope.launch {
            delay(500)
            _state.value = UiState(
                exercise = exercise
            )
        }
    }

    fun onStartClicked() {
        // TODO:  Open timer modal
    }

    data class UiState(
        val exercise: Exercise? = null
    )
}

val exercise = Exercise(
    0,
    "Bodyweight Squat",
    "Stand with feet shoulder-width apart and lower your hips as if sitting on a chair, then return to standing.",
    DifficultyLevel.BEGINNER,
    listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
    false
)
