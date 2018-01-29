package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Samples {

    // Default Routines
    public static ArrayList<Routine> getDefaultRoutines() {
        ArrayList<Routine> defaultRoutines = new ArrayList<Routine>();

        Routine stretchRoutine = new Routine();
        stretchRoutine.Name = "Stretch Routine";
        defaultRoutines.add(stretchRoutine);

        Routine yogaRoutine = new Routine();
        yogaRoutine.Name = "Yoga Routine";
        defaultRoutines.add(yogaRoutine);

        Routine liftRoutine = new Routine();
        liftRoutine.Name = "Lift Routine";
        defaultRoutines.add(liftRoutine);

        return defaultRoutines;
    }

}
