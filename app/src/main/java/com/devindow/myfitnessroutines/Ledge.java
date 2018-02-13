package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Devin on 2/13/2018.
 */

public class Ledge extends Prop {

	// Private Fields
	private float x1;
	private float x2;
	private float height;


	// Constructor
	Ledge(float x1, float x2, float height) {
		this.x1 = x1;
		this.x2 = x2;
		this.height = height;
	}


	// Overrides
	@Override
	public void draw(Canvas canvas) {
		Paint p = new Paint();
		p.setStrokeWidth(1);

		canvas.drawLine(x1, 0, x1, height, p);
		canvas.drawLine(x1, height, x2, height, p);
	}

}
