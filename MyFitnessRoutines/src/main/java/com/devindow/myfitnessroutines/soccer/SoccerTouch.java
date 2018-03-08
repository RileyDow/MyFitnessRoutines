package com.devindow.myfitnessroutines.soccer;

import android.graphics.Canvas;

import com.devindow.myfitnessroutines.util.Arrow;

/**
 * Created by Devin on 3/6/2018.
 */

public class SoccerTouch extends SoccerMotion {

	// Public Fields
	public Arrow arrow;


	// Constructor
	public SoccerTouch(Arrow arrow) {
		this.arrow = arrow;
	}


	// SoccerMotion implementation
	public void draw(Canvas canvas, int stepNum, boolean mirror) {
		arrow.draw(canvas, stepNum, mirror);
	}

}
