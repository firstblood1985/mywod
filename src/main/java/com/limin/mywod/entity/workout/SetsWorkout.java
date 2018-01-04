package com.limin.mywod.entity.workout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SetsWorkout extends Workout {

    public static final Logger LOGGER = LoggerFactory.getLogger(SetsWorkout.class);

    private int totalSet;

    private boolean sameSet;

    private List<WorkoutSet> rx;

    private List<WorkoutSet> scale1;

    private List<WorkoutSet> scale2;

    public SetsWorkout()
    {
        super();
    }

    public int getTotalSet() {
        return totalSet;
    }

    public void setTotalSet(int totalSet) {
        this.totalSet = totalSet;
    }

    public boolean isSameSet() {
        return sameSet;
    }

    public void setSameSet(boolean sameSet) {
        this.sameSet = sameSet;
    }

    public List<WorkoutSet> getRx() {
        return rx;
    }

    public void setRx(List<WorkoutSet> rx) {
        this.rx = rx;
    }

    public List<WorkoutSet> getScale1() {
        return scale1;
    }

    public void setScale1(List<WorkoutSet> scale1) {
        this.scale1 = scale1;
    }

    public List<WorkoutSet> getScale2() {
        return scale2;
    }

    public void setScale2(List<WorkoutSet> scale2) {
        this.scale2 = scale2;
    }
}
