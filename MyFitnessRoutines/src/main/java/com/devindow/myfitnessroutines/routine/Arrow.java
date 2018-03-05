package com.devindow.myfitnessroutines.routine;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Point;

/**
 * Created by Devin on 3/5/2018.
 */

public class Arrow {

	// Constants
	public static final float width = 0.5f;


	// Public Fields
	public Point start;
	public Point end;
	public int color;


	// Constructors
	public Arrow(float startX, float startY, float endX, float endY, int color) {
		this.start = new Point(startX, startY);
		this.end = new Point(endX, endY);
		this.color = color;
	}

	public Arrow(Point start, Point end, int color) {
		this.start = start;
		this.end = end;
		this.color = color;
	}


	// Public Methods
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStrokeWidth(width);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);

		canvas.drawLine(start.x, start.y, end.x, end.y, paint);


	}

}
