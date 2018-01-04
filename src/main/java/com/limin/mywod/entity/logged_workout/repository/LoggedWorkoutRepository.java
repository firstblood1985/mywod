package com.limin.mywod.entity.logged_workout.repository;

import com.limin.mywod.entity.logged_workout.LoggedWorkout;
import org.springframework.data.repository.CrudRepository;

public interface LoggedWorkoutRepository extends CrudRepository<LoggedWorkout,Long> {
}
