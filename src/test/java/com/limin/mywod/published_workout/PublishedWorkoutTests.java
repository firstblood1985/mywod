package com.limin.mywod.published_workout;

import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.entity.published_workout.repository.PublishedWorkoutRepository;
import com.limin.mywod.request.published_workout.PublishedWorkoutRequest;
import com.limin.mywod.service.published_workout.PublishedWorkoutService;
import com.limin.mywod.test_utility.TestUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublishedWorkoutTests extends TestUtility{

    @Autowired
    private PublishedWorkoutService publishedWorkoutService;

    @Test
    public void testCreatePublishedWorkout()
    {
        PublishedWorkoutRequest pwr = createPublishedWorkoutRequest();
        //Assert.assertEquals(pwr.);
        System.out.println(pwr.getWorkout_details());
       // Assert.assertEquals(pwr.getRequestBy());
        publishedWorkoutService.createPublishedWorkout(pwr);

        List<PublishedWorkout> publishedWorkoutList =  publishedWorkoutService.getAllPublishedWorkouts();
        Assert.assertEquals(3,publishedWorkoutList.size());
    }


}
