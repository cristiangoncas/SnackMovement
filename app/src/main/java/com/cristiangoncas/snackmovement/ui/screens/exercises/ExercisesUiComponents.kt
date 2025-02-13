package com.cristiangoncas.snackmovement.ui.screens.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup
import com.cristiangoncas.snackmovement.ui.theme.Green
import com.cristiangoncas.snackmovement.ui.theme.Orange
import com.cristiangoncas.snackmovement.ui.theme.Red

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

@Composable
fun ExerciseItem(exercise: Exercise, onClick: (Int) -> Unit) {
    Box {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable(
                    onClick = { onClick(exercise.id) },
                    role = Role.Button
                )
                .semantics {
                    contentDescription = exercise.name
                }
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
                contentDescription = "View exercise details",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
                    .rotate(degrees = 90f)
                    .weight(.2f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseItemPreview() {
    ExerciseItem(
        Exercise(
            1,
            "Exercise Name",
            "Description",
            DifficultyLevel.BEGINNER,
            listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
            false,
        ),
        {}
    )
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
fun DifficultyTrafficLightPreview() {
    DifficultyTrafficLight(DifficultyLevel.BEGINNER)
}