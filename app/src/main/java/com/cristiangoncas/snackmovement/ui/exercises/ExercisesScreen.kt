package com.cristiangoncas.snackmovement.ui.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup
import com.cristiangoncas.snackmovement.ui.Screen
import com.cristiangoncas.snackmovement.ui.theme.Green
import com.cristiangoncas.snackmovement.ui.theme.Orange
import com.cristiangoncas.snackmovement.ui.theme.Red

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesScreen(
    viewModel: ExercisesViewModel
) {
    val state = viewModel.state.collectAsState()

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
                paddingValues = padding,
            )
        }
    }
    viewModel.onUiReady()
}

@Composable
fun ExercisesList(exercises: List<Exercise>, paddingValues: PaddingValues) {
    LazyColumn(
        contentPadding = paddingValues
    ) {
        items(exercises.size) { index ->
            ExerciseItem(exercises[index])
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Box {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            // Circular shape to act as a difficulty traffic light
            DifficultyTrafficLight(exercise.difficulty)

            Text(
                exercise.name,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(.8f)
                    .padding(horizontal = 8.dp)
            )
            Image(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
                    .rotate(degrees = 90f)
                    .weight(.2f)
            )
        }
    }
}

@Composable
fun DifficultyTrafficLight(difficulty: DifficultyLevel) {
    val color = when (difficulty) {
        DifficultyLevel.BEGINNER -> Green
        DifficultyLevel.INTERMEDIATE -> Orange
        DifficultyLevel.ADVANCED -> Red
    }
    Box(
        modifier = Modifier
            .width(15.dp)
            .height(15.dp)
            .background(color, shape = CircleShape)
            .padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DifficultyTrafficLight(DifficultyLevel.BEGINNER)
}

@Preview(showBackground = true)
@Composable
fun ExercisesScreenPreview() {
    ExercisesScreen(ExercisesViewModel())
}

@Preview(showBackground = true)
@Composable
fun ExerciseItemPreview() {
    ExerciseItem(
        Exercise(
            "Exercise Name",
            "Description",
            DifficultyLevel.BEGINNER,
            listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
            false
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ExercisesListPreview() {
    val exercisesList = exercises
    ExercisesList(exercisesList, PaddingValues(16.dp))
}