package com.devindow.myfitnessroutines.soccer;

import android.graphics.Canvas;

/**
 * Created by Devin on 3/6/2018.
 */

public abstract class Motion {

	// Methods
	public void draw(Canvas canvas) {
		draw(canvas, 0);
	}

	public void draw(Canvas canvas, int stepNum) {
		draw(canvas, stepNum, false);
	}

	public abstract void draw(Canvas canvas, int stepNum, boolean mirror);

}
