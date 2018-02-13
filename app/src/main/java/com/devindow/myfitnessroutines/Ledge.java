package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Devin on 2/13/2018.
 */

public class Ledge extends Prop {

	// Private Fields
	private int x1;
	private int x2;
	private int height;


	// Constructor
	Ledge(int x1, int x2, int height) {
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
