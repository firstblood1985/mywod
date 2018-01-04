package com.limin.mywod.entity.movement;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum MovementType implements Serializable{

    WEIGHT("Weight", Arrays.asList(MovementUnit.KG,MovementUnit.POUND)),
    GYM("Gymnastic", Arrays.asList()),
    ENDUR("Endurance",Arrays.asList(MovementUnit.METER,MovementUnit.MILE,MovementUnit.CAL)),
    ISOLATED("Isolated",Arrays.asList()),
    FUNCTIONAL_BODYBUILDING("Functional Bodybuding",Arrays.asList());

    private final String displayName;
    private final List<MovementUnit> movementUnits;

    MovementType (String s, List<MovementUnit> movementUnits)
    {
        this.displayName = s;
        this.movementUnits = movementUnits;
    }
}
