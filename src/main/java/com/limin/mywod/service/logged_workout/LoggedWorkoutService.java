package com.limin.mywod.service.logged_workout;

import com.limin.mywod.entity.logged_workout.LoggedWorkout;
import com.limin.mywod.request.logged_workout.LoggedWorkoutRequest;

import java.util.List;

public interface LoggedWorkoutService {

    public LoggedWorkout createLoggedWorkout(LoggedWorkoutRequest loggedWorkoutRequest);

    public boolean deleteLoggedWorkoutById(Long id);

    public List<LoggedWorkout> findAllLoggedWorkout();
}
