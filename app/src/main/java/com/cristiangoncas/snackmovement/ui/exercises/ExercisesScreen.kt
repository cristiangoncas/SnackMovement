package com.cristiangoncas.snackmovement.ui.exercises

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.ui.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesScreen(
    viewModel: ExercisesViewModel
) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.onUiReady()
    }
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(R.string.title_exercises))
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                )
            },
        ) { padding ->
            ExercisesList(
                exercises = state.value.exercises,
                onExerciseClick = { id -> viewModel.onExerciseClick(id) },
                paddingValues = padding,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisesScreenPreview() {
    ExercisesScreen(ExercisesViewModel())
}

@Composable
fun ExercisesList(exercises: List<Exercise>, onExerciseClick: (Int) -> Unit = {}, paddingValues: PaddingValues) {
    LazyColumn(
        contentPadding = paddingValues
    ) {
        items(exercises.size) { index ->
            ExerciseItem(exercises[index], onExerciseClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisesListPreview() {
    val exercisesList = exercises
    ExercisesList(exercisesList, onExerciseClick = {}, PaddingValues(16.dp))
}