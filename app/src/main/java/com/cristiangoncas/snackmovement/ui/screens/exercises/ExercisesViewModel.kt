package com.cristiangoncas.snackmovement.ui.screens.exercises

import androidx.lifecycle.ViewModel
import com.cristiangoncas.snackmovement.domain.models.DifficultyLevel
import com.cristiangoncas.snackmovement.domain.models.Exercise
import com.cristiangoncas.snackmovement.domain.models.MuscleGroup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExercisesViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun onUiReady() {
        _state.value = UiState(exercises = exercises)
    }

    fun onExerciseClick(id: Int) {
        // Handle exercise click event
    }

    data class UiState(
        val exercises: List<Exercise> = emptyList()
    )
}


val exercises = listOf(
    Exercise(
        0,
        "Bodyweight Squat",
        "Stand with feet shoulder-width apart and lower your hips as if sitting on a chair, then return to standing.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
        false
    ),
    Exercise(
        1,
        "Forward Lunge",
        "Step one foot forward, lower your hips until both knees form 90-degree angles, then push back to the starting position.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
        false
    ),
    Exercise(
        2,
        "Push-Up",
        "Start in a plank position and lower your chest toward the floor by bending your elbows, then press back up.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.CHEST, MuscleGroup.ARMS, MuscleGroup.SHOULDERS),
        false
    ),
    Exercise(
        3,
        "Plank",
        "Hold a push-up position on your forearms, keeping your body in a straight line from head to heels.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.CORE),
        false
    ),
    Exercise(
        4,
        "Side Plank",
        "Lie on your side, prop yourself up on one forearm, and lift your hips off the floor, forming a straight line.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.CORE),
        false
    ),
    Exercise(
        5,
        "Mountain Climbers",
        "From a plank position, drive your knees toward your chest in a running motion, alternating legs quickly.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE, MuscleGroup.SHOULDERS),
        false
    ),
    Exercise(
        6,
        "Burpees",
        "From standing, drop into a squat, kick your feet back into a plank, do a push-up (optional), then jump up explosively.",
        DifficultyLevel.ADVANCED,
        listOf(MuscleGroup.LEGS, MuscleGroup.CHEST, MuscleGroup.CORE, MuscleGroup.SHOULDERS),
        false
    ),
    Exercise(
        7,
        "Glute Bridge",
        "Lie on your back, knees bent, feet on the floor. Lift your hips by squeezing your glutes, then lower slowly.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
        false
    ),
    Exercise(
        8,
        "Jumping Jacks",
        "From a standing position, jump feet out to the sides while raising arms overhead, then return to start.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.SHOULDERS),
        false
    ),
    Exercise(
        9,
        "Kettlebell Swing",
        "Hinge at the hips to swing the kettlebell forward to shoulder height, using glutes and hamstrings.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.LEGS, MuscleGroup.BACK, MuscleGroup.SHOULDERS),
        true
    ),
    Exercise(
        10,
        "Goblet Squat",
        "Hold a kettlebell or dumbbell at chest height and perform a squat, keeping your back straight.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE),
        true
    ),
    Exercise(
        11,
        "Deadlift",
        "Hinge at the hips and lift the weight from the ground to standing, keeping your back neutral.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.LEGS, MuscleGroup.BACK, MuscleGroup.CORE),
        true
    ),
    Exercise(
        12,
        "Overhead Press",
        "Press weights straight overhead from shoulder level, keeping your core engaged.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.SHOULDERS, MuscleGroup.ARMS),
        true
    ),
    Exercise(
        13,
        "Bent-Over Row",
        "Hinge at the hips with a flat back, pulling weight toward your torso and squeezing shoulder blades together.",
        DifficultyLevel.INTERMEDIATE,
        listOf(MuscleGroup.BACK, MuscleGroup.ARMS),
        true
    ),
    Exercise(
        14,
        "Farmer’s Carry",
        "Walk forward holding weights by your sides, maintaining an upright posture and tight core.",
        DifficultyLevel.BEGINNER,
        listOf(MuscleGroup.LEGS, MuscleGroup.CORE, MuscleGroup.ARMS),
        true
    ),
    Exercise(
        15,
        "Thruster",
        "Perform a front squat and then immediately transition into an overhead press in one fluid motion.",
        DifficultyLevel.ADVANCED,
        listOf(MuscleGroup.LEGS, MuscleGroup.SHOULDERS, MuscleGroup.CORE),
        true
    )
)

private val exercisesJson = """{
  "exercises": [
    {
      "name": "Bodyweight Squat",
      "description": "Stand with feet shoulder-width apart and lower your hips as if sitting on a chair, then return to standing.",
      "difficulty": "Beginner",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": false
    },
    {
      "name": "Forward Lunge",
      "description": "Step one foot forward, lower your hips until both knees form 90-degree angles, then push back to the starting position.",
      "difficulty": "Beginner",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": false
    },
    {
      "name": "Push-Up",
      "description": "Start in a plank position and lower your chest toward the floor by bending your elbows, then press back up.",
      "difficulty": "Intermediate",
      "muscle_group": "Upper Body (chest, shoulders, triceps), Core",
      "requires_equipment": false
    },
    {
      "name": "Plank",
      "description": "Hold a push-up position on your forearms, keeping your body in a straight line from head to heels.",
      "difficulty": "Beginner",
      "muscle_group": "Core, Shoulders",
      "requires_equipment": false
    },
    {
      "name": "Side Plank",
      "description": "Lie on your side, prop yourself up on one forearm, and lift your hips off the floor, forming a straight line.",
      "difficulty": "Intermediate",
      "muscle_group": "Core, Obliques",
      "requires_equipment": false
    },
    {
      "name": "Mountain Climbers",
      "description": "From a plank position, drive your knees toward your chest in a running motion, alternating legs quickly.",
      "difficulty": "Intermediate",
      "muscle_group": "Full Body (core, shoulders, legs)",
      "requires_equipment": false
    },
    {
      "name": "Burpees",
      "description": "From standing, drop into a squat, kick your feet back into a plank, do a push-up (optional), then jump up explosively.",
      "difficulty": "Advanced",
      "muscle_group": "Full Body (legs, chest, core, cardio)",
      "requires_equipment": false
    },
    {
      "name": "Glute Bridge",
      "description": "Lie on your back, knees bent, feet on the floor. Lift your hips by squeezing your glutes, then lower slowly.",
      "difficulty": "Beginner",
      "muscle_group": "Lower Body (glutes, hamstrings), Core",
      "requires_equipment": false
    },
    {
      "name": "Bird Dog",
      "description": "Kneel on all fours and simultaneously extend one arm and the opposite leg, keeping your back straight.",
      "difficulty": "Beginner",
      "muscle_group": "Core, Lower Back, Shoulders",
      "requires_equipment": false
    },
    {
      "name": "Bear Crawl",
      "description": "Start on all fours with knees slightly off the ground. Move forward on hands and feet, keeping knees close to the floor.",
      "difficulty": "Intermediate",
      "muscle_group": "Full Body (shoulders, core, legs)",
      "requires_equipment": false
    },
    {
      "name": "Jumping Jacks",
      "description": "From a standing position, jump feet out to the sides while raising arms overhead, then return to start.",
      "difficulty": "Beginner",
      "muscle_group": "Full Body (cardio, shoulders, legs)",
      "requires_equipment": false
    },
    {
      "name": "High Knees",
      "description": "Run in place while lifting knees as high as possible, pumping your arms to maintain balance.",
      "difficulty": "Intermediate",
      "muscle_group": "Legs, Core, Cardio",
      "requires_equipment": false
    },
    {
      "name": "Inchworm",
      "description": "From standing, bend forward to touch the floor, walk your hands into a plank, then walk them back to your feet.",
      "difficulty": "Intermediate",
      "muscle_group": "Full Body (shoulders, core, hamstrings)",
      "requires_equipment": false
    },
    {
      "name": "Skaters",
      "description": "Hop laterally from one foot to the other, swinging your arms for balance, mimicking a speed skater’s motion.",
      "difficulty": "Intermediate",
      "muscle_group": "Lower Body (glutes, quads), Core, Cardio",
      "requires_equipment": false
    },
    {
      "name": "Reverse Lunge with Knee Drive",
      "description": "Step one leg back into a lunge, then drive the back knee forward and up explosively, returning to standing.",
      "difficulty": "Intermediate",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": false
    },
    {
      "name": "Kettlebell Swing",
      "description": "Hinge at the hips to swing the kettlebell forward to shoulder height, using glutes and hamstrings.",
      "difficulty": "Intermediate",
      "muscle_group": "Full Body (glutes, hamstrings, core)",
      "requires_equipment": true
    },
    {
      "name": "Goblet Squat",
      "description": "Hold a kettlebell or dumbbell at chest height and perform a squat, keeping your back straight.",
      "difficulty": "Beginner",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": true
    },
    {
      "name": "Bent-Over Row",
      "description": "Hinge at the hips with a flat back, pulling weight toward your torso and squeezing shoulder blades together.",
      "difficulty": "Intermediate",
      "muscle_group": "Upper Body (back, biceps), Core",
      "requires_equipment": true
    },
    {
      "name": "Overhead Press",
      "description": "Press weights straight overhead from shoulder level, keeping your core engaged.",
      "difficulty": "Intermediate",
      "muscle_group": "Upper Body (shoulders, triceps), Core",
      "requires_equipment": true
    },
    {
      "name": "Farmer’s Carry",
      "description": "Walk forward holding weights by your sides, maintaining an upright posture and tight core.",
      "difficulty": "Beginner",
      "muscle_group": "Full Body (grip, shoulders, core, legs)",
      "requires_equipment": true
    },
    {
      "name": "Deadlift",
      "description": "Hinge at the hips and lift the weight from the ground to standing, keeping your back neutral.",
      "difficulty": "Intermediate",
      "muscle_group": "Lower Body (glutes, hamstrings), Back, Core",
      "requires_equipment": true
    },
    {
      "name": "Thruster",
      "description": "Perform a front squat and then immediately transition into an overhead press in one fluid motion.",
      "difficulty": "Advanced",
      "muscle_group": "Full Body (legs, shoulders, core)",
      "requires_equipment": true
    },
    {
      "name": "Resistance Band Squat",
      "description": "Stand on a loop band, hold the handles/ends at shoulder height, and perform a squat with band tension.",
      "difficulty": "Beginner",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": true
    },
    {
      "name": "Resistance Band Row",
      "description": "Anchor a band at waist height, grab the handles, step back, and pull towards your torso.",
      "difficulty": "Beginner",
      "muscle_group": "Upper Body (back, biceps), Core",
      "requires_equipment": true
    },
    {
      "name": "Single-Arm Suitcase Carry",
      "description": "Hold a weight in one hand at your side and walk, keeping your torso upright to resist lateral bending.",
      "difficulty": "Intermediate",
      "muscle_group": "Core (obliques), Grip, Shoulders",
      "requires_equipment": true
    },
    {
      "name": "Medicine Ball Slam",
      "description": "Raise a medicine ball overhead and slam it to the ground forcefully, bending at the knees and hips.",
      "difficulty": "Intermediate",
      "muscle_group": "Full Body (core, shoulders, legs)",
      "requires_equipment": true
    },
    {
      "name": "TRX Row",
      "description": "Lean back holding the TRX handles, pull your chest towards the handles by bending the elbows.",
      "difficulty": "Intermediate",
      "muscle_group": "Upper Body (back, biceps), Core",
      "requires_equipment": true
    },
    {
      "name": "Landmine Twist",
      "description": "Place one end of a barbell in a landmine pivot or corner, hold the other end, and rotate side to side.",
      "difficulty": "Intermediate",
      "muscle_group": "Core, Shoulders",
      "requires_equipment": true
    },
    {
      "name": "Weighted Step-Up",
      "description": "Hold weights by your sides, step onto a sturdy box or bench, drive through the heel, and step down carefully.",
      "difficulty": "Intermediate",
      "muscle_group": "Lower Body (quads, glutes), Core",
      "requires_equipment": true
    },
    {
      "name": "Weighted Hip Thrust",
      "description": "Rest your upper back on a bench, place a weight over your hips, and drive hips upward, squeezing the glutes.",
      "difficulty": "Intermediate",
      "muscle_group": "Lower Body (glutes, hamstrings), Core",
      "requires_equipment": true
    }
  ]
}
"""