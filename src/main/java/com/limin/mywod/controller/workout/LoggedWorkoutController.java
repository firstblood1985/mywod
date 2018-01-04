package com.limin.mywod.controller.workout;

import com.limin.mywod.entity.logged_workout.LoggedWorkout;
import com.limin.mywod.entity.logged_workout.repository.LoggedWorkoutRepository;
import com.limin.mywod.request.logged_workout.LoggedWorkoutRequest;
import com.limin.mywod.response.logged_workout.LoggedWorkoutReponse;
import com.limin.mywod.service.logged_workout.LoggedWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/logged_workout")
public class LoggedWorkoutController {

    @Autowired
    LoggedWorkoutRepository loggedWorkoutRepository;

    @Autowired
    LoggedWorkoutService loggedWorkoutService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<LoggedWorkout>> getAllLoggedWorkouts()
    {

        return new ResponseEntity<List<LoggedWorkout>> ((List<LoggedWorkout>) this.loggedWorkoutRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public ResponseEntity<LoggedWorkoutReponse> createLoggedWorkouts(@RequestBody LoggedWorkoutRequest loggedWorkoutRequest)
    {

          return null;
//        return new ResponseEntity<LoggedWorkoutReponse>(,HttpStatus.OK);

    }
}
