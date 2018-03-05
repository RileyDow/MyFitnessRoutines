package com.devindow.myfitnessroutines.util;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Devin on 3/5/2018.
 */

public class Arrow {

	// Constants
	public static final float width = 0.5f;
	public static final float headSize = 3;


	// Public Fields
	public Point start;
	public Point end;
	public Feet	feet;


	// Constructors
	public Arrow(float startX, float startY, float endX, float endY, Feet feet) {
		this.start = new Point(startX, startY);
		this.end = new Point(endX, endY);
		this.feet = feet;
	}

	public Arrow(Point start, Point end, Feet feet) {
		this.start = start;
		this.end = end;
		this.feet = feet;
	}


	// Public Methods
	public void draw(Canvas canvas, boolean mirror) {
		Paint paint = new Paint();
		Colors.setFootColor(paint, feet, true, mirror);
		paint.setStrokeWidth(width);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);

		canvas.drawLine(start.x, start.y, end.x, end.y, paint);

		Angle angle = new Angle(start.y - end.y, start.x - end.x);
		Angle angle1 = angle.add(45);
		Angle angle2 = angle.add(-45);
		Point tip1 = angle1.polar(end, headSize);
		Point tip2 = angle2.polar(end, headSize);
		canvas.drawLine(end.x, end.y, tip1.x, tip1.y, paint);
		canvas.drawLine(end.x, end.y, tip2.x, tip2.y, paint);
	}

	public void shorten(boolean head, boolean tail, float distance) {
		if (head) {
			start.offset(distance, end);
		}

		if (tail) {
			end.offset(distance, start);
		}
	}

}
