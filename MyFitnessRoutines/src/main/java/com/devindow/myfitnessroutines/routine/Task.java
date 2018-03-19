package com.devindow.myfitnessroutines.routine;

import com.devindow.myfitnessroutines.util.Side;

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
	public Side side;


	// Public Properties
	public int getTotalSeconds() {
		return moveSeconds + restSeconds;
	}


	// Constructors
	public Task(String moveName, int moveSeconds) {
		this(moveName, moveSeconds, Side.BOTH);
	}

	public Task(String moveName, int moveSeconds, Side side) {
		this(moveName, moveSeconds, 0, side);
	}

	public Task(String moveName, int moveSeconds, int restSeconds) {
		this(moveName, moveSeconds, restSeconds, Side.BOTH);
	}

	public Task(String moveName, int moveSeconds, int restSeconds, Side side) {
		this(moveName, moveSeconds, restSeconds, side, "");
	}

	public Task(String moveName, int moveSeconds, String instructions) {
		this(moveName, moveSeconds, Side.BOTH, instructions);
	}

	public Task(String moveName, int moveSeconds, Side side, String instructions) {
		this(moveName, moveSeconds, 0, side, instructions);
	}

	public Task(String moveName, int moveSeconds, int restSeconds, String instructions) {
		this(moveName, moveSeconds, restSeconds, Side.BOTH, instructions);
	}

	public Task(String moveName, int moveSeconds, int restSeconds, Side side, String instructions) {
		this.moveName = moveName;
		this.moveSeconds = moveSeconds;
		this.restSeconds = restSeconds;
		this.side = side;
		this.instructions = instructions;
	}


	// Overrides
	@Override
	public String toString() {
		String s = moveName + " " + moveSeconds + " sec";
		if (!side.hasBoth()) {
			s += " " + side;
		}
		return s;
	}
}
