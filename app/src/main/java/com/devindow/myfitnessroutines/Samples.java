package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Samples {

    // Default Routines
    public static ArrayList<Routine> getSampleRoutines() {
        ArrayList<Routine> defaultRoutines = new ArrayList<Routine>();

        defaultRoutines.add(getStretchSample());

        defaultRoutines.add(getYogaSample());

        defaultRoutines.add(getLiftSample());

        return defaultRoutines;
    }


    // Private Methods
    private static Routine getStretchSample() {
        Routine routine = new Routine("Stretch Routine");

        routine.Steps.add(new Step(new Pose("Touch Toes", Category.STRETCH), 30));

        return routine;
    }

    private static Routine getYogaSample() {
        Routine routine = new Routine("Yoga Routine");

        routine.Steps.add(new Step(new Pose("Down Dog", Category.YOGA), 30));

        return routine;
    }

    private static Routine getLiftSample() {
        Routine routine = new Routine("Lift Routine");

        routine.Steps.add(new Step(new Pose("Push-Ups", Category.LIFTING), 30));

        return routine;
    }

}
