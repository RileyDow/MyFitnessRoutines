package com.devindow.myfitnessroutines;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Step implements Serializable {

    public Pose Pose;
    public int Duration;
    public int RestDuration;


    // Constructors
    public Step(Pose pose, int duration) {
        this.Pose = pose;
        this.Duration = duration;
        this.RestDuration = 0;
    }

    public Step(Pose pose, int duration, int restDuration) {
        this.Pose = pose;
        this.Duration = duration;
        this.RestDuration = restDuration;
    }

}
