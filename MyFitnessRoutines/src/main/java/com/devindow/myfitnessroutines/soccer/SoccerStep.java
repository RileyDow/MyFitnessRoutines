package com.devindow.myfitnessroutines.soccer;

import android.graphics.Canvas;

import com.devindow.myfitnessroutines.util.Step;

/**
 * Created by Devin on 3/6/2018.
 */

public class SoccerStep extends SoccerMotion {

	// Public Fields
	public Step step;


	// Constructor
	public SoccerStep(Step step) {
		this.step = step;
	}


	// SoccerMotion implementation
	public void draw(Canvas canvas, int stepNum, boolean mirror) {
		step.draw(canvas, stepNum, mirror);
	}

}
