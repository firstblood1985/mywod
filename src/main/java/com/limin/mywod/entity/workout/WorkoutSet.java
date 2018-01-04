package com.limin.mywod.entity.workout;

import java.util.List;

public class WorkoutSet {

    private int setNum;

    private List<WorkoutMovement> workoutMovements;

    public int getSetNum() {
        return setNum;
    }

    public void setSetNum(int setNum) {
        this.setNum = setNum;
    }

    public List<WorkoutMovement> getWorkoutMovements() {
        return workoutMovements;
    }

    public void setWorkoutMovements(List<WorkoutMovement> workoutMovements) {
        this.workoutMovements = workoutMovements;
    }
}
