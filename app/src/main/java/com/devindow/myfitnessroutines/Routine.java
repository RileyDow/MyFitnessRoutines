package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Routine {
    public String Name;
    public ArrayList<Step> Steps;

    public int getDuration() {
        int duration = 0;
        for (Step step : Steps) {
            duration += step.Duration;
        }
        return duration;
    }


    public class Step {
        public Pose Pose;
        public int Duration;
        public int RestDuration;
    }
}
