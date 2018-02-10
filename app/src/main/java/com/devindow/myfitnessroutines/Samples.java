package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Samples {

    // Default Routines
    public static ArrayList<Routine> getSampleRoutines() {
        ArrayList<Routine> defaultRoutines = new ArrayList<Routine>();

        defaultRoutines.add(getTestSample());

        defaultRoutines.add(get7MinuteSample());

        defaultRoutines.add(getStretchSample());

        defaultRoutines.add(getYogaSample());

        defaultRoutines.add(getLiftSample());

        defaultRoutines.add(getCardioSample());

        defaultRoutines.add(getWarmupSample());

        defaultRoutines.add(getMeditationSample());

        return defaultRoutines;
    }


    // Private Methods
    private static Routine getTestSample() {
        Routine routine = new Routine("Test Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PUSHUPS), 5, 3));

        return routine;
    }

    private static Routine get7MinuteSample() {
        Routine routine = new Routine("7 Minute Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.JUMPING_JACKS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.WALL_SIT), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PUSHUPS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.CRUNCHES), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.STEP_UPS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.SQUATS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.CHAIR_DIPS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PLANK), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.HIGH_KNEES), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.LUNGES), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PUSHUP_ROLL), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.SIDE_PLANK), 30));

        return routine;
    }

    private static Routine getStretchSample() {
        Routine routine = new Routine("Stretch Routine");

        routine.Steps.add(new Step(new FrontalPose("Touch Toes", Category.STRETCH), 30));

        return routine;
    }

    private static Routine getYogaSample() {
        Routine routine = new Routine("Yoga Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.DOWNDOG), 30));

        return routine;
    }

    private static Routine getLiftSample() {
        Routine routine = new Routine("Lift Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PUSHUPS), 30));

        return routine;
    }

    private static Routine getCardioSample() {
        Routine routine = new Routine("Cardio Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.JUMPING_JACKS), 30));
        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.PUSHUPS), 30));

        return routine;
    }

    private static Routine getWarmupSample() {
        Routine routine = new Routine("Warmup Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.JUMPING_JACKS), 30));

        return routine;
    }

    private static Routine getMeditationSample() {
        Routine routine = new Routine("Meditation Routine");

        routine.Steps.add(new Step(PoseLibrary.Poses.get(PoseLibrary.LOTUS), 30));

        return routine;
    }

}
