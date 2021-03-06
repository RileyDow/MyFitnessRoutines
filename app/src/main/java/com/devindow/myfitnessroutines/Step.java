package com.devindow.myfitnessroutines;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Step implements Serializable {

	public Pose pose;
	public int poseDuration;
	public int restDuration;


	// Constructors
	public Step(Pose pose, int poseDuration) {
		this.pose = pose;
		this.poseDuration = poseDuration;
		this.restDuration = 0;
	}

	public Step(Pose pose, int poseDuration, int restDuration) {
		this.pose = pose;
		this.poseDuration = poseDuration;
		this.restDuration = restDuration;
	}

}
