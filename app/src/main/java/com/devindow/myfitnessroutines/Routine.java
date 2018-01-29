package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Routine {

    // Public Properties
    public String Name;
    public ArrayList<Step> Steps = new ArrayList<Step>();


    // Public Fields
    public int getDuration() {
        int duration = 0;
        for (Step step : Steps) {
            duration += step.Duration;
        }
        return duration;
    }


    // Constructors
    public Routine(String name) {
        this.Name = name;
    }


    // Overrides
    @Override
    public String toString() {
        return Name;
    }

}
