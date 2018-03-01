package com.devindow.myfitnessroutines.routine;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Routine implements Serializable {

	// Public Fields
	public String name;
	public Category category;
	public String description;
	public ArrayList<Step> steps = new ArrayList<Step>();


	// Public Properties
	public Step getStep(int stepNum) { // starting with stepNum = 1
		if (stepNum > steps.size() || stepNum < 1) {
			return null;
		}
		return steps.get(stepNum-1);
	}

	public int getTotalSeconds() {
		int duration = 0;
		for (Step step : steps) {
			duration += step.getTotalSeconds();
		}
		return duration;
	}

	public String getTotalMinutesString() {
		int minutes = (int)Math.round(1.0 * getTotalSeconds() / 60);
		return minutes + " min";
	}

	public String getRemainingString(int stepNum) {
		if (stepNum >= steps.size()) {
			return "";
		}

		int stepsRemaining = 0;
		int secondsRemaining = 0;
		for (int i=stepNum+1; i<=steps.size(); i++) {
			Step step = getStep(i);
			stepsRemaining++;
			secondsRemaining += step.getTotalSeconds();
		}
		int minutesRemaining = (int) Math.round(1.0 * secondsRemaining / 60);
		return stepsRemaining + " steps=" + minutesRemaining + "min";
	}


	// Constructors
	public Routine(String name) {
		this(name, "");
	}

	public Routine(String name, Category category) {
		this(name, category, "");
	}

	public Routine(String name, String description) {
		this(name, Category.NONE, description);
	}

	public Routine(String name, Category category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
	}


	// Overrides
	@Override
	public String toString() {
		return name + " - " + getTotalMinutesString();
	}

}
