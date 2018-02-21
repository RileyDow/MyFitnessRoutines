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
	public ArrayList<Step> steps = new ArrayList<Step>();


	// Public Properties
	public int getDuration() {
		int duration = 0;
		for (Step step : steps) {
			duration += step.getTotalDuration();
		}
		return duration;
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
		int minutes = (int)Math.round(1.0 * getDuration() / 60);
		return name + " - " + minutes + " min";
	}

}
