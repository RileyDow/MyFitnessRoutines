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

        routine.Steps.add(new Step(new FrontalPose("Touch Toes", Category.STRETCH), 30));

        return routine;
    }

    private static Routine getYogaSample() {
        Routine routine = new Routine("Yoga Routine");

        routine.Steps.add(new Step(new FrontalPose("Down Dog", Category.YOGA), 30));

        return routine;
    }

    private static Routine getLiftSample() {
        Routine routine = new Routine("Lift Routine");

        ProfilePose pushup = new ProfilePose("Push-Ups", Category.LIFTING);
        pushup.headX = 30;
        pushup.headY = 24;
        pushup.waistX = 0;
        pushup.waistY = 12;
        pushup.rHandX = pushup.lHandX = 25;
        pushup.rHandY = pushup.lHandY = 0;
        pushup.rFootX = pushup.lFootX = -30;
        pushup.rFootY = pushup.lFootY = 0;
        routine.Steps.add(new Step(pushup, 30));

        return routine;
    }

}
