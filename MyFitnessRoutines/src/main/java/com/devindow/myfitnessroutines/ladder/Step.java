package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Point;
import com.devindow.myfitnessroutines.util.Text;

import java.io.Serializable;

/**
 * Created by Devin on 3/2/2018.
 */

public class Step implements Serializable {

	// Constants
	public static final float radius = 3;


	// Public Fields
	public Feet feet;
	public Point point;


	// Constructors
	public Step(Point point) {
		this(Feet.BOTH, point);
	}

	public Step(Point point, float xRadiiOffset, float yRadiiOffset) {
		this(Feet.BOTH, point, xRadiiOffset, yRadiiOffset);
	}

	public Step(Feet feet, Point point) {
		this(feet, point, 0, 0);
	}

	public Step(Feet feet, Point point, float xRadiiOffset, float yRadiiOffset) {
		this.feet = feet;
		this.point = point;
		point.offset(xRadiiOffset * radius, yRadiiOffset * radius);
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		canvas.drawCircle(point.x, point.y, radius, paint);

		String text = Integer.toString(stepNum);
		if (feet.hasBoth()) {
		} else if (feet.hasLeft()) {
				text += "-L";
		} else if (feet.hasRight()) {
			text += "-R";
		}

		Text.draw(canvas, text, point);
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
