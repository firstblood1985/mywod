package com.limin.mywod.request.published_workout;

import com.jcabi.aspects.Loggable;
import com.limin.mywod.entity.workout.WorkoutType;
import com.limin.mywod.request.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishedWorkoutRequest extends Request {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishedWorkoutRequest.class);

    private long id;

    private WorkoutType type;

    private String name;

    private String workout_details;

    private boolean isBenchmark;

    private String comments;

    public PublishedWorkoutRequest() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWorkout_details() {
        return workout_details;
    }

    public void setWorkout_details(String workout_details) {
        this.workout_details = workout_details;
    }

    public boolean isBenchmark() {
        return isBenchmark;
    }

    public void setBenchmark(boolean benchmark) {
        isBenchmark = benchmark;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRxVersion() {

        return parseWorkoutDetails("rx");

    }

    public String getScaleVersion1() {

        return parseWorkoutDetails("scale1");
    }

    public String getScaleVersion2() {

        return parseWorkoutDetails("scale2");

    }

    @Loggable(Loggable.INFO)
    public String parseWorkoutDetails(String key) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject published_workout = (JSONObject) parser.parse(workout_details);
            JSONArray details = (JSONArray) published_workout.get(key);
            return null == details ? null : details.toJSONString();
        } catch (ParseException e) {
            LOGGER.info("cannot retrieve json object with key: {} .\n {}",key,e.getMessage());
            return null;
        }
    }
}
