package com.devindow.myfitnessroutines.routine;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Step implements Serializable {

	// Public Fields
	public Move move;
	public String instructions;
	public int moveSeconds;
	public int restSeconds;


	// Public Properties
	public int getTotalSeconds() {
		return moveSeconds + restSeconds;
	}


	// Constructors
	public Step(Move move, int moveSeconds) {
		this(move, moveSeconds, 0);
	}

	public Step(Move move, int moveSeconds, int restSeconds) {
		this(move, moveSeconds, restSeconds, "");
	}

	public Step(Move move, int moveSeconds, String instructions) {
		this(move, moveSeconds, 0, instructions);
	}

	public Step(Move move, int moveSeconds, int restSeconds, String instructions) {
		this.move = move;
		this.moveSeconds = moveSeconds;
		this.restSeconds = restSeconds;
		this.instructions = instructions;
	}


	// Overrides
	@Override
	public String toString() {
		return move.name;
	}
}
