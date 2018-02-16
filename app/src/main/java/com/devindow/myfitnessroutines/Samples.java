package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Samples {

    // Default Routines
    public static ArrayList<Routine> getSampleRoutines() {
        ArrayList<Routine> defaultRoutines = new ArrayList<Routine>();

        defaultRoutines.add(get7MinuteWorkout());

        if (Debug.on) {
            defaultRoutines.add(getTestSample());

            defaultRoutines.add(getSunSalutation());

            defaultRoutines.add(getStretchRoutine());

            defaultRoutines.add(getYogaRoutine());

            defaultRoutines.add(getLiftRoutine());

            defaultRoutines.add(getCardioRoutine());

            defaultRoutines.add(getWarmupRoutine());

            defaultRoutines.add(getMeditationRoutine());
        }

        return defaultRoutines;
    }


    // Private Methods
    private static Routine getTestSample() {
        Routine routine = new Routine("Test Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 3, 2));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DONE), 3, 0));

        return routine;
    }

    private static Routine get7MinuteWorkout() {
        Routine routine = new Routine("7 Minute Workout");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.WALL_SIT), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.CRUNCHES), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.STEP_UPS), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SQUATS), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.CHAIR_DIPS), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PLANK), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.HIGH_KNEES), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LUNGES), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UP_ROTATE), 30, 5));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SIDE_PLANK), 30));

        return routine;
    }

    private static Routine getSunSalutation() {
        Routine routine = new Routine("Sun Salutation");

        //routine.steps.add(new Step(new FrontalPose("Touch Toes", Category.STRETCH), 30));

        return routine;
    }

    private static Routine getStretchRoutine() {
        Routine routine = new Routine("Stretch Routine");

        //routine.steps.add(new Step(new FrontalPose("Touch Toes", Category.STRETCH), 30));

        return routine;
    }

    private static Routine getYogaRoutine() {
        Routine routine = new Routine("Yoga Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DOWN_DOG), 30));

        return routine;
    }

    private static Routine getLiftRoutine() {
        Routine routine = new Routine("Lift Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30));

        return routine;
    }

    private static Routine getCardioRoutine() {
        Routine routine = new Routine("Cardio Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 30));
        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30));

        return routine;
    }

    private static Routine getWarmupRoutine() {
        Routine routine = new Routine("Warmup Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 30));

        return routine;
    }

    private static Routine getMeditationRoutine() {
        Routine routine = new Routine("Meditation Routine");

        routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 30));

        return routine;
    }

}
