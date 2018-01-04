package com.limin.mywod.service.published_workout;

import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.request.published_workout.PublishedWorkoutRequest;

import java.util.List;

public interface PublishedWorkoutService {

    public List<PublishedWorkout> getAllPublishedWorkouts();

    public PublishedWorkout createPublishedWorkout(PublishedWorkoutRequest publishedWorkoutRequest);

    public boolean deletePublishedWorkoutById(Long id);
}
