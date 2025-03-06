package com.cristiangoncas.snackmovement.ui.screens.exercisedetail

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cristiangoncas.snackmovement.ui.components.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExerciseDetailScreen(
    exerciseId: Int,
    viewModel: ExerciseDetailViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.onUiReady(exerciseId)
    }
    Screen {
        Scaffold { _ ->
            state.exercise?.let { exercise ->
                ExerciseDetailContent(
                    exercise
                ) { viewModel.onStartClicked() }
            } ?: SkeletonExerciseDetailContent()
        }
    }
}
