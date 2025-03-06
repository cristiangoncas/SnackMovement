package com.cristiangoncas.snackmovement.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.ui.components.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
) {

    LaunchedEffect(key1 = true) {
        viewModel.onUiReady()
    }

    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(R.string.title_home))
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                )
            },
        ) { padding ->
            val state by viewModel.state.collectAsState()
            if (state.loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "GOALS",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineMedium
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(8.dp)
                        .background(
                            MaterialTheme.colorScheme.inversePrimary,
                            RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "DAILY",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(text = "7/10")
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "WEEKLY",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(text = "10/70")
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.36f)
                        .padding(16.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(4.dp)),
                ) {
                    Text(
                        text = state.motivationalQuote,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }

                LazyColumn(
                    modifier = Modifier.padding(8.dp),
                    contentPadding = padding
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .background(MaterialTheme.colorScheme.inversePrimary)
                        ) {
                            Text(
                                text = stringResource(R.string.your_favourite_exercises),
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    items(exercises) { exercise ->
                        ExerciseItem(exercise = exercise)
                    }
                }

            }

        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = exercise.name,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
