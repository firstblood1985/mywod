package com.limin.mywod.service.published_workout.impl;

import com.jcabi.aspects.Loggable;
import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.entity.published_workout.repository.PublishedWorkoutRepository;
import com.limin.mywod.entity.user.repository.UserRepository;
import com.limin.mywod.request.published_workout.PublishedWorkoutRequest;
import com.limin.mywod.service.published_workout.PublishedWorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PublishedWorkoutServiceImpl implements PublishedWorkoutService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishedWorkoutServiceImpl.class);

    @Autowired
    private PublishedWorkoutRepository publishedWorkoutRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Loggable(Loggable.INFO)
    public List<PublishedWorkout> getAllPublishedWorkouts() {

        return (List<PublishedWorkout>) publishedWorkoutRepository.findAll();
    }

    @Override
    @Loggable(Loggable.INFO)
    public PublishedWorkout createPublishedWorkout(PublishedWorkoutRequest publishedWorkoutRequest) {

        PublishedWorkout pw = new PublishedWorkout();
        pw.setPublisher(userRepository.findUserByLogin(publishedWorkoutRequest.getRequestBy()));
        pw.setDeleted(false);
        pw.setBenchmark(publishedWorkoutRequest.isBenchmark());
        pw.setName(publishedWorkoutRequest.getName());
        pw.setPublishedDate(publishedWorkoutRequest.getRequestWhen());
        pw.setRxVersion(publishedWorkoutRequest.getRxVersion());
        pw.setScaleVersion1(publishedWorkoutRequest.getScaleVersion1());
        pw.setScaleVersino2(publishedWorkoutRequest.getScaleVersion2());
        pw.setComment(publishedWorkoutRequest.getComments());
        pw.setType(publishedWorkoutRequest.getType());
        return publishedWorkoutRepository.save(pw);

        //  return pw;


    }

    @Override
    @Transactional
    @Loggable(Loggable.INFO)
    public boolean deletePublishedWorkoutById(Long id) {

        PublishedWorkout toBeDeleted = publishedWorkoutRepository.findOne(id);
        if (null != toBeDeleted) {
            publishedWorkoutRepository.delete(toBeDeleted);
            return true;
        }
        LOGGER.error("not able to find out published workout with id: <{}>",id);
        return false;
    }
}
