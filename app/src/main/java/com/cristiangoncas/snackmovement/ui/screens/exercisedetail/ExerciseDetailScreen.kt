package com.cristiangoncas.snackmovement.ui.screens.exercisedetail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup
import com.cristiangoncas.snackmovement.ui.Screen
import kotlin.math.round

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
