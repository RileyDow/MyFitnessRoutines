package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Devin on 2/13/2018.
 */

public class Wall extends Prop {

	// Private Fields
	private float x;


	// Constructor
	public Wall(float x) {
		this.x = x;
	}


	// Overrides
	@Override
	public void draw(Canvas canvas) {
		Paint p = new Paint();
		p.setStrokeWidth(1);

		canvas.drawLine(x, 0, x, 96, p);
	}

}
