package com.limin.mywod.controller.workout;

import com.limin.mywod.request.published_workout.PublishedWorkoutRequest;
import com.limin.mywod.service.published_workout.PublishedWorkoutService;
import org.slf4j.Logger;
import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.entity.published_workout.repository.PublishedWorkoutRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by CBB on 17/12/14.
 */

@RestController
@RequestMapping(value="/published_workout")
public class PublishedWorkoutController {
    private static final  Logger LOGGER = LoggerFactory.getLogger(PublishedWorkoutController.class);

    @Autowired
    private PublishedWorkoutRepository publishedWorkoutRepository;

    @Autowired
    private PublishedWorkoutService publishedWorkoutService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PublishedWorkout> getAllPublishedWorkouts(HttpServletRequest request){

        LOGGER.info("Get all published workouts");
        return (List<PublishedWorkout>) this.publishedWorkoutRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<PublishedWorkout> createPublishedWorkout(@RequestBody PublishedWorkoutRequest publishedWorkoutRequest)
    {
        LOGGER.info("create published workout \n " + publishedWorkoutRequest);

        return new ResponseEntity<PublishedWorkout>(publishedWorkoutService.createPublishedWorkout(publishedWorkoutRequest),
                HttpStatus.OK);
    }

}
