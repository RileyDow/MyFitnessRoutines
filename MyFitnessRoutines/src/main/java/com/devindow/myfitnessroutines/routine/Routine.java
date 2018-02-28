package com.devindow.myfitnessroutines.routine;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Routine implements Serializable {

	// Public Fields
	public String name;
	public String description;
	public Category category;
	public ArrayList<Step> steps = new ArrayList<Step>();


	// Public Properties
	public Step getStep(int stepNum) { // starting with stepNum = 1
		if (stepNum > steps.size() || stepNum < 1) {
			return null;
		}
		return steps.get(stepNum-1);
	}

	public int getDuration() {
		int duration = 0;
		for (Step step : steps) {
			duration += step.getTotalDuration();
		}
		return duration;
	}

	public String getMinutesString() {
		int minutes = (int)Math.round(1.0 * getDuration() / 60);
		return minutes + " min";
	}

	public String getRemaining(int stepNum) {
		if (stepNum >= steps.size()) {
			return "";
		}

		int stepsRemaining = 0;
		int secondsRemaining = 0;
		for (int i=stepNum+1; i<=steps.size(); i++) {
			Step step = getStep(i);
			stepsRemaining++;
			secondsRemaining += step.getTotalDuration();
		}
		int minutesRemaining = (int) Math.round(1.0 * secondsRemaining / 60);
		return stepsRemaining + " steps=" + minutesRemaining + "min";
	}


	// Constructors
	public Routine(String name) {
		this(name, "");
	}

	public Routine(String name, String description) {
		this.name = name;
		this.description = description;
	}


	// Overrides
	@Override
	public String toString() {
		return name + " - " + getMinutesString();
	}

}
