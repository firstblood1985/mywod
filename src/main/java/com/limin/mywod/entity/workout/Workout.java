package com.limin.mywod.entity.workout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class Workout{

    public static final Logger LOGGER = LoggerFactory.getLogger(Workout.class);

    private String name;

    private WorkoutType type;

    private int totalReps;

    private Duration duration;

    private boolean isBenchmark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isBenchmark() {
        return isBenchmark;
    }

    public void setBenchmark(boolean benchmark) {
        isBenchmark = benchmark;
    }

    public String toJson () {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            } catch (JsonProcessingException e) {
                LOGGER.error("not able to parse to json: "+ e.getMessage());
                return null;
            }
        }

}
