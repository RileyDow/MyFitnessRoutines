package com.devindow.myfitnessroutines.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Devin on 3/2/2018.
 */

public class Step {

	// Constants
	public static final float radius = 3;


	// Public Fields
	public Feet feet;
	public Point point;


	// Constructors
	public Step(Point point) {
		this(Feet.BOTH, point);
	}

	public Step(Feet feet, Point point) {
		this.feet = feet;
		this.point = point;
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		draw(canvas, stepNum, false);
	}

	public void draw(Canvas canvas, int stepNum, boolean mirror) {
		Paint paint = new Paint();

		String text = Integer.toString(stepNum);
		if (feet.hasBoth()) {
			Colors.setFootColor(paint, Feet.LEFT, false, mirror);
			canvas.drawArc(new RectF(point.x-radius, point.y-radius, point.x+radius, point.y+radius), 90, 180, true, paint);
			Colors.setFootColor(paint, Feet.RIGHT, false, mirror);
			canvas.drawArc(new RectF(point.x-radius, point.y-radius, point.x+radius, point.y+radius), 270, 180, true, paint);
		} else if (feet.hasLeft()) {
			Colors.setFootColor(paint, Feet.LEFT, false, mirror);
			canvas.drawCircle(point.x, point.y, radius, paint);
			if (mirror) {
				text += "-R";
			} else {
				text += "-L";
			}
		} else if (feet.hasRight()) {
			Colors.setFootColor(paint, Feet.RIGHT, false, mirror);
			canvas.drawCircle(point.x, point.y, radius, paint);
			if (mirror) {
				text += "-L";
			} else {
				text += "-R";
			}
		}

		Text.draw(canvas, text, point, mirror);
	}


	// Overrides
	@Override
	public String toString() {
		String string = point.toString();
		if (feet.hasLeft()) {
			string += "L";
		}
		if (feet.hasRight()) {
			string += "R";
		}
		return string;
	}

}
