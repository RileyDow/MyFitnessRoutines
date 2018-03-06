package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.devindow.myfitnessroutines.util.*;

/**
 * Created by Devin on 3/2/2018.
 */

public class OnePointStep extends Step {

	// Public Fields
	public Feet feet;
	public Point point;


	// Constructors
	public OnePointStep(Point point) {
		this(Feet.BOTH, point);
	}

	public OnePointStep(Feet feet, Point point) {
		this.feet = feet;
		this.point = point;
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint paint = new Paint();

		String text = Integer.toString(stepNum);
		if (feet.hasBoth()) {
			Colors.setFootColor(paint, Feet.LEFT);
			canvas.drawArc(new RectF(point.x-radius, point.y-radius, point.x+radius, point.y+radius), 90, 180, true, paint);
			Colors.setFootColor(paint, Feet.RIGHT);
			canvas.drawArc(new RectF(point.x-radius, point.y-radius, point.x+radius, point.y+radius), 270, 180, true, paint);
		} else if (feet.hasLeft()) {
			Colors.setFootColor(paint, Feet.LEFT);
			canvas.drawCircle(point.x, point.y, radius, paint);
			text += "-L";
		} else if (feet.hasRight()) {
			Colors.setFootColor(paint, Feet.RIGHT);
			canvas.drawCircle(point.x, point.y, radius, paint);
			text += "-R";
		}

		Text.draw(canvas, text, point);
	}


	// Overrides
	@Override
	public boolean hasLeft() {
		return feet.hasLeft();
	}

	@Override
	public boolean hasRight() {
		return feet.hasRight();
	}

	@Override
	public boolean hasBoth() {
		return feet.hasBoth();
	}


	@Override
	public Point getLeft() {
		return point;
	}

	@Override
	public Point getRight() {
		return point;
	}


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
