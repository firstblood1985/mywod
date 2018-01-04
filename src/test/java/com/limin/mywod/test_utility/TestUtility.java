package com.limin.mywod.test_utility;

import com.limin.mywod.entity.movement.Movement;
import com.limin.mywod.entity.movement.MovementType;
import com.limin.mywod.entity.movement.MovementUnit;
import com.limin.mywod.entity.user.User;
import com.limin.mywod.entity.user.repository.UserRepository;
import com.limin.mywod.entity.workout.SetsWorkout;
import com.limin.mywod.entity.workout.WorkoutMovement;
import com.limin.mywod.entity.workout.WorkoutSet;
import com.limin.mywod.entity.workout.WorkoutType;
import com.limin.mywod.request.logged_workout.LoggedWorkoutRequest;
import com.limin.mywod.request.published_workout.PublishedWorkoutRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class TestUtility {

    @Autowired
    private UserRepository userRepository;


    public LoggedWorkoutRequest createLoggedWorkoutRequest()
    {
        LoggedWorkoutRequest lwr = new LoggedWorkoutRequest();
        lwr.setPublishedWorkoutId(new Long(1));
        lwr.setRequestBy("limin");
        lwr.setRequestWhen(new Date());
        lwr.setComments("feels good");
        lwr.setReps(0);
        lwr.setSets(3);
        lwr.setTotalReps(180);
        lwr.setDuration(Duration.ofMinutes(15).plusSeconds(23));
        String results = "{\n" +
                "\"duration\": "+ Duration.ofMinutes(15).plusSeconds(23).toString()+","+
                "\n\"totalReps\": 180,"+
                "\n\"sets\": 3,"+
                "\n\"reps\": 0,"+
                "}\n";
        lwr.setResults(results);

        return lwr;

    }
    public PublishedWorkoutRequest createPublishedWorkoutRequest()
    {
        PublishedWorkoutRequest pwr = new PublishedWorkoutRequest();
        pwr.setRequestBy("limin");
        pwr.setRequestWhen(new Date());
        pwr.setBenchmark(false);
        pwr.setComments("keep pace not blow out");
        pwr.setName("casual workout on Fri");
        pwr.setType(WorkoutType.SETS);
        pwr.setWorkout_details(createSetsWorkout().toJson());
        return pwr;
    }

    public SetsWorkout createSetsWorkout(){

        SetsWorkout sw = new SetsWorkout();

        sw.setSameSet(true);
        sw.setTotalSet(3);
        sw.setRx(createWorkoutSets());
        return sw;
    }

    public List<WorkoutSet>  createWorkoutSets(){

        WorkoutSet ws = new WorkoutSet();
        WorkoutMovement wm = new WorkoutMovement();
       // wm.setMv(new Movement());
        Movement mv = new Movement();
        mv.setName("Back Squat");
        mv.setId(3);
        mv.setType(MovementType.WEIGHT);

        wm.setMovement(mv);
        wm.setLoad(100);
        wm.setRep(3);
        wm.setMovementUnit(MovementUnit.KG);

        ws.setWorkoutMovements((List<WorkoutMovement>)Arrays.asList(new WorkoutMovement[]{wm}));
        return new ArrayList<WorkoutSet>(){{add(ws);}};
    }
}
