package com.limin.mywod.json_test;


import com.limin.mywod.entity.movement.MovementUnit;
import com.limin.mywod.entity.workout.WorkoutType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {

    @Test
    public void testJson()
    {
        JSONParser parser = new JSONParser();

        try {
            JSONObject a = (JSONObject) parser.parse(new FileReader("/Users/CBB/Documents/work/mywod/src/test/java/com/limin/mywod/json_test/diff_sets.json"));
            WorkoutType t  = WorkoutType.valueOf((String)a.get("type"));
            String name = (String)a.get("name");
            JSONArray sets = (JSONArray) a.get("Sets");
            Iterator<JSONObject> setIterator = sets.iterator();
            while (setIterator.hasNext())
            {
                JSONObject set = setIterator.next();
                Long setId = (Long)set.get("setId");
                System.out.println("Set id: " + setId);

                JSONArray movements = (JSONArray) set.get("movements");
                Iterator<JSONObject> movementsIterator = movements.iterator();
                while (movementsIterator.hasNext())
                {
                    JSONObject movement = movementsIterator.next();
                    Long movementId = (Long)movement.get("movementId");
                    System.out.println("Movement id: " + movementId);
                    Long rep = (Long)movement.get("rep");
                    Long load;
                    MovementUnit mu;
                    if(movement.containsKey("load")) {
                        load = (Long) movement.get("load");
                    }
                    if(movement.containsKey("unit")) {
                        mu = MovementUnit.valueOf((String) movement.get("unit"));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
