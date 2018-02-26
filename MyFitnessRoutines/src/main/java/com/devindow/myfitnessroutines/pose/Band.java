package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Devin on 2/23/2018.
 */

public class Band extends Prop {

	// Constants
	public static final float thickness = 3;


	// Private Fields
	private float x1;
	private float y1;
	private float x2;
	private float y2;


	// Constructor
	public Band(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}


	// Overrides
	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(thickness);
		paint.setColor(Color.GRAY);

		canvas.drawLine(x1, y1, x2, y2, paint);
	}

}
