package com.limin.mywod.entity.workout;

public class WorkoutFactory {

    public static Object createWorkout(WorkoutType type, String rawWorkout)
    {
        switch (type){
            case SETS:
                return createSetWorkout(rawWorkout);

        }

        return null;
    }

    public static SetsWorkout createSetWorkout(String rawWorkoutString)
    {

        return null;
    }

}
