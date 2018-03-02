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
	public ArrayList<Task> tasks = new ArrayList<>();


	// Public Properties
	public Task getTask(int taskNum) { // starting with taskNum = 1
		if (taskNum > tasks.size() || taskNum < 1) {
			return null;
		}
		return tasks.get(taskNum-1);
	}

	public int getTotalSeconds() {
		int duration = 0;
		for (Task task : tasks) {
			duration += task.getTotalSeconds();
		}
		return duration;
	}

	public String getTotalMinutesString() {
		int minutes = (int)Math.round(1.0 * getTotalSeconds() / 60);
		return minutes + " min";
	}

	public String getRemainingString(int taskNum) {
		if (taskNum >= tasks.size()) {
			return "";
		}

		int tasksRemaining = 0;
		int secondsRemaining = 0;
		for (int i = taskNum+1; i<= tasks.size(); i++) {
			Task task = getTask(i);
			tasksRemaining++;
			secondsRemaining += task.getTotalSeconds();
		}
		int minutesRemaining = (int) Math.round(1.0 * secondsRemaining / 60);
		return tasksRemaining + " more = " + minutesRemaining + " min";
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
