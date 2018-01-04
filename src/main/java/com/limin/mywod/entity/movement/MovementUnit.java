package com.limin.mywod.entity.movement;

import java.io.Serializable;

public enum MovementUnit implements Serializable{

    KG("kgs"),
    POUND("pounds"),
    METER("meters"),
    MILE("miles"),
    CAL("Calories");

    private String displayName;
    MovementUnit(String s) {
        this.displayName = s;
    }
}
