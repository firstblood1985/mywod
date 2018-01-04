package com.limin.mywod.request.logged_workout;

import com.limin.mywod.request.Request;

import java.time.Duration;

public class LoggedWorkoutRequest extends Request{

    private Long publishedWorkoutId;

    private String results;

    private Duration duration;

    private int totalReps;

    private int sets;

    private int reps;

    private String comments;

    public Long getPublishedWorkoutId() {
        return publishedWorkoutId;
    }

    public void setPublishedWorkoutId(Long publishedWorkoutId) {
        this.publishedWorkoutId = publishedWorkoutId;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
