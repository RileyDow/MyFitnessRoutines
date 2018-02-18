package com.devindow.myfitnessroutines;

import java.io.Serializable;

/**
 * Created by Devin on 1/29/2018.
 */

public class Step implements Serializable {

	// Public Fields
	public Move move;
	public int moveDuration;
	public int restDuration;


	// Public Properties
	public int getTotalDuration() {
		return moveDuration + restDuration;
	}

	// Constructors
	public Step(Move move, int moveDuration) {
		this.move = move;
		this.moveDuration = moveDuration;
		this.restDuration = 0;
	}

	public Step(Move move, int moveDuration, int restDuration) {
		this.move = move;
		this.moveDuration = moveDuration;
		this.restDuration = restDuration;
	}

}
