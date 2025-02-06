package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.TypeConverter
import com.cristiangoncas.snackmovement.framework.local.model.ExerciseDifficulty
import com.cristiangoncas.snackmovement.framework.local.model.GoalType
import com.cristiangoncas.snackmovement.framework.local.model.MuscleGroup
import com.cristiangoncas.snackmovement.framework.local.model.NotificationFrequency
import com.cristiangoncas.snackmovement.framework.local.model.NotificationType

class Converters {

    @TypeConverter
    fun fromExerciseDifficulty(difficulty: ExerciseDifficulty): Int = difficulty.id

    @TypeConverter
    fun toExerciseDifficulty(id: Int): ExerciseDifficulty = ExerciseDifficulty.fromId(id)

    @TypeConverter
    fun fromMuscleGroup(muscleGroup: MuscleGroup): Int = muscleGroup.id

    @TypeConverter
    fun toMuscleGroup(id: Int): MuscleGroup = MuscleGroup.fromId(id)

    @TypeConverter
    fun fromGoalType(type: GoalType): Int = type.id

    @TypeConverter
    fun toGoalType(id: Int): GoalType = GoalType.fromId(id)

    @TypeConverter
    fun fromNotificationType(type: NotificationType): Int = type.id

    @TypeConverter
    fun toNotificationType(id: Int): NotificationType = NotificationType.fromId(id)

    @TypeConverter
    fun fromNotificationFrequency(frequency: NotificationFrequency): Int = frequency.id

    @TypeConverter
    fun toNotificationFrequency(id: Int): NotificationFrequency = NotificationFrequency.fromId(id)
}