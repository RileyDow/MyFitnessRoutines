package com.devindow.myfitnessroutines.util;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Devin on 3/5/2018.
 */

public class Arrow {

	// Constants
	public static final float width = 0.5f;
	public static final float headSize = 2;


	// Public Fields
	public Point start;
	public Point end;
	public Feet feet;


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
	public void draw(Canvas canvas) {
		draw(canvas, 0);
	}

	public void draw(Canvas canvas, int stepNum) {
		draw(canvas, stepNum, false);
	}

	public void draw(Canvas canvas, int stepNum, boolean mirror) {
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

	public void shorten(float distance) {
		shorten(distance, true, true);
	}

	public void shorten(float distance, boolean head, boolean tail) {
		if (head) {
			end = end.offset(-distance, start);
		}

		if (tail) {
			start = start.offset(-distance, end);
		}
	}

	public Arrow shortened(float distance) {
		return this.shortened(distance, true, true);
	}

	public Arrow shortened(float distance, boolean head, boolean tail) {
		Point end = this.end;
		if (head) {
			end = this.end.offset(-distance, this.start);
		}

		Point start = this.start;
		if (tail) {
			start = this.start.offset(-distance, this.end);
		}

		return new Arrow(start, end, feet);
	}

}
