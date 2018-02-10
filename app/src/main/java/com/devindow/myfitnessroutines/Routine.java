package com.devindow.myfitnessroutines;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Routine implements Serializable {

    // Public Properties
    public String name;
    public ArrayList<Step> steps = new ArrayList<Step>();


    // Public Fields
    public int getDuration() {
        int duration = 0;
        for (Step step : steps) {
            duration += step.poseDuration;
        }
        return duration;
    }


    // Constructors
    public Routine(String name) {
        this.name = name;
    }


    // Overrides
    @Override
    public String toString() {
        return name;
    }

}
