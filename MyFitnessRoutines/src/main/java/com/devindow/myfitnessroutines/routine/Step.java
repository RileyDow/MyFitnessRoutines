package com.devindow.myfitnessroutines.routine;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Step implements Serializable {

	// Public Fields
	public Move move;
	public String instructions;
	public int moveDuration;
	public int restDuration;


	// Public Properties
	public int getTotalDuration() {
		return moveDuration + restDuration;
	}


	// Constructors
	public Step(Move move, int moveDuration) {
		this(move, moveDuration, 0);
	}

	public Step(Move move, int moveDuration, int restDuration) {
		this(move, moveDuration, restDuration, "");
	}

	public Step(Move move, int moveDuration, String instructions) {
		this(move, moveDuration, 0, instructions);
	}

	public Step(Move move, int moveDuration, int restDuration, String instructions) {
		this.move = move;
		this.moveDuration = moveDuration;
		this.restDuration = restDuration;
		this.instructions = instructions;
	}


	// Overrides
	@Override
	public String toString() {
		return move.name;
	}
}
