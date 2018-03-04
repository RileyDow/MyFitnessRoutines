package com.devindow.myfitnessroutines.routine;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Task implements Serializable {

	// Public Fields
	public String moveName;
	public String instructions;
	public int moveSeconds;
	public int restSeconds;


	// Public Properties
	public int getTotalSeconds() {
		return moveSeconds + restSeconds;
	}


	// Constructors
	public Task(String moveName, int moveSeconds) {
		this(moveName, moveSeconds, 0);
	}

	public Task(String moveName, int moveSeconds, int restSeconds) {
		this(moveName, moveSeconds, restSeconds, "");
	}

	public Task(String moveName, int moveSeconds, String instructions) {
		this(moveName, moveSeconds, 0, instructions);
	}

	public Task(String moveName, int moveSeconds, int restSeconds, String instructions) {
		this.moveName = moveName;
		this.moveSeconds = moveSeconds;
		this.restSeconds = restSeconds;
		this.instructions = instructions;
	}


	// Overrides
	@Override
	public String toString() {
		return moveName + " " + moveSeconds + " sec";
	}
}
