package com.cristiangoncas.snackmovement.ui.screens.exercisedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup

@Composable
fun SkeletonExerciseDetailContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Top Red Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.LightGray)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 20.dp, end = 20.dp)
        ) {
            // Exercise Title Card
            Card(
                modifier = Modifier
                    .padding(top = 40.dp) // Overlapping effect
                    .align(Alignment.End)
                    .wrapContentSize(),
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black
                )
            ) {
                Text(
                    text = exercise.name,
                    modifier = Modifier
                        .padding(horizontal = 28.dp, vertical = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            ExerciseDescriptionSkeleton()
        }
    }
}

@Composable
fun ExerciseDescriptionSkeleton() {
    // Exercise Difficulty
    Text(
        text = "",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .height(18.dp)
            .width(80.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = exercise.difficulty.label.capitalize(Locale.current),
        style = MaterialTheme.typography.bodyLarge,
        color = Color.LightGray,
        modifier = Modifier
            .height(18.dp)
            .width(100.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Exercise Description
    Text(
        text = "",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .height(18.dp)
            .width(100.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = "",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Exercise Muscle group
    Text(
        text = "",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .height(18.dp)
            .width(100.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = "",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .height(18.dp)
            .width(150.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun SkeletonExerciseDetailPreview() {
    SkeletonExerciseDetailContent()
}

@Composable
fun ExerciseDetailContent(
    exercise: Exercise,
    onStartClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Top Red Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.LightGray)
        ) {
            Text(
                "Image here!",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 20.dp, end = 20.dp)
        ) {
            // Exercise Title Card
            Card(
                modifier = Modifier
                    .padding(top = 40.dp) // Overlapping effect
                    .align(Alignment.End)
                    .wrapContentSize(),
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black
                )
            ) {
                Text(
                    text = exercise.name,
                    modifier = Modifier.padding(horizontal = 28.dp, vertical = 16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            ExerciseDescription()
        }
        StartExerciseButton(Modifier.align(Alignment.BottomCenter), onStartClicked)
    }
}

@Composable
fun ExerciseDescription() {
    // Exercise Difficulty
    Text(
        text = "Difficulty:",
        style = MaterialTheme.typography.bodySmall
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = exercise.difficulty.label.capitalize(Locale.current),
        style = MaterialTheme.typography.bodyLarge
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Exercise Description
    Text(
        text = "Description:",
        style = MaterialTheme.typography.bodySmall
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = exercise.description,
        style = MaterialTheme.typography.bodyLarge
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Exercise Muscle group
    Text(
        text = "Muscle group:",
        style = MaterialTheme.typography.bodySmall
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = exercise.muscleGroups.joinToString { it.label },
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun ExerciseDetailPreview() {
    ExerciseDetailContent(
        Exercise(
            0,
            "Bodyweight Squat",
            "Stand with feet shoulder-width apart and lower your hips as if sitting on a chair, then return to standing.",
            DifficultyLevel.BEGINNER,
            listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
            false
        ),
        {}
    )
}

@Composable
fun StartExerciseButton(
    modifier: Modifier,
    onStartClicked: () -> Unit
) {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { onStartClicked() },
        modifier = modifier
            .width(120.dp)
            .height(90.dp)
            .padding(16.dp),
        contentColor = Color.Black,
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Text(
            "Start",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(12.dp),
        )
    }
}

@Preview
@Composable
fun StartExerciseButtonPreview() {
    StartExerciseButton(Modifier) { }
}