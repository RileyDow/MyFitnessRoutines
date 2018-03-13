package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Point;

/**
 * Created by Devin on 2/23/2018.
 */

public class Band extends Prop {

	// Constants
	public static final float thickness = 3;


	// Private Fields
	private Point p1;
	private Point p2;


	// Constructor
	public Band(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}


	// Overrides
	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(thickness);
		paint.setColor(Color.GRAY);

		canvas.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
	}

}
