package com.limin.mywod.entity.workout;

import com.limin.mywod.entity.movement.Movement;
import com.limin.mywod.entity.movement.MovementUnit;

public class WorkoutMovement {

    private Movement movement;

    private int rep;

    private int load;

    private MovementUnit movementUnit;

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public MovementUnit getMovementUnit() {
        return movementUnit;
    }

    public void setMovementUnit(MovementUnit movementUnit) {
        this.movementUnit = movementUnit;
    }
}
