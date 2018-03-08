package com.devindow.myfitnessroutines.soccer;

import android.graphics.Canvas;

import com.devindow.myfitnessroutines.util.Arrow;
import com.devindow.myfitnessroutines.util.Step;

/**
 * Created by Devin on 3/8/2018.
 */

public class SoccerStepAndTouch extends SoccerMotion {

	// Public Fields
	public Step step;
	public Arrow arrow;


	// Constructor
	public SoccerStepAndTouch(Step step, Arrow arrow) {
		this.step = step;
		this.arrow = arrow;
	}


	// SoccerMotion implementation
	public void draw(Canvas canvas, int stepNum, boolean mirror) {
		step.draw(canvas, stepNum, mirror);
		arrow.draw(canvas, stepNum, mirror);
	}

}
