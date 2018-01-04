package com.limin.mywod.logged_workout;

import com.limin.mywod.entity.logged_workout.LoggedWorkout;
import com.limin.mywod.request.logged_workout.LoggedWorkoutRequest;
import com.limin.mywod.service.logged_workout.LoggedWorkoutService;
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
public class LoggedWorkoutTest extends TestUtility {

    @Autowired
    LoggedWorkoutService loggedWorkoutService;

    @Test
    public void createLoggedWorkout()
    {
        LoggedWorkoutRequest lwr = createLoggedWorkoutRequest();
        LoggedWorkout lw = loggedWorkoutService.createLoggedWorkout(lwr);
        Assert.assertNotNull(lw);
        List<LoggedWorkout> allLoggedWorkout = loggedWorkoutService.findAllLoggedWorkout();
        Assert.assertEquals(3,allLoggedWorkout.size());

    }
}
