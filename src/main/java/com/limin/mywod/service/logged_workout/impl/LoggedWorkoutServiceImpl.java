package com.limin.mywod.service.logged_workout.impl;

import com.jcabi.aspects.Loggable;
import com.limin.mywod.entity.logged_workout.LoggedWorkout;
import com.limin.mywod.entity.logged_workout.repository.LoggedWorkoutRepository;
import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.entity.published_workout.repository.PublishedWorkoutRepository;
import com.limin.mywod.entity.user.repository.UserRepository;
import com.limin.mywod.request.logged_workout.LoggedWorkoutRequest;
import com.limin.mywod.service.logged_workout.LoggedWorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class LoggedWorkoutServiceImpl implements LoggedWorkoutService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedWorkoutService.class);

    @Autowired
    LoggedWorkoutRepository loggedWorkoutRepository;


    @Autowired
    PublishedWorkoutRepository publishedWorkoutRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    @Loggable(Loggable.INFO)
    public LoggedWorkout createLoggedWorkout(LoggedWorkoutRequest loggedWorkoutRequest) {
        PublishedWorkout publishedWorkout = publishedWorkoutRepository.findOne(loggedWorkoutRequest.getPublishedWorkoutId());
        if(null == publishedWorkout)
        {
            LOGGER.error("unable to find out published workout with id: <{}>", loggedWorkoutRequest.getPublishedWorkoutId());
        }
        LoggedWorkout lw = new LoggedWorkout();
        lw.setLoggedBy(userRepository.findUserByLogin(loggedWorkoutRequest.getRequestBy()));
        lw.setLoggedDate(loggedWorkoutRequest.getRequestWhen());
        lw.setComments(loggedWorkoutRequest.getComments());
        lw.setDuration(loggedWorkoutRequest.getDuration());
        lw.setPublishedWorkout(publishedWorkout);
        lw.setReps(loggedWorkoutRequest.getReps());
        lw.setSets(loggedWorkoutRequest.getSets());
        lw.setResults(loggedWorkoutRequest.getResults());

        return loggedWorkoutRepository.save(lw);
    }

    @Override
    @Transactional
    @Loggable(Loggable.INFO)
    public boolean deleteLoggedWorkoutById(Long id) {

        LoggedWorkout toBedeleted = loggedWorkoutRepository.findOne(id);
        if(null!= toBedeleted)
        {
            loggedWorkoutRepository.delete(toBedeleted);
            return true;
        }
        return false;
    }

    @Override
    public List<LoggedWorkout> findAllLoggedWorkout() {
        return (List<LoggedWorkout>) loggedWorkoutRepository.findAll();
    }
}
