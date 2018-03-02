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
	public Point point;
	public boolean leftFoot;
	public boolean rightFoot;


	// Constructors
	public Step(Point point, boolean leftFoot, boolean rightFoot) {
		this.point = point;
		this.leftFoot = leftFoot;
		this.rightFoot = rightFoot;
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		canvas.drawCircle(point.x, point.y, radius, paint);

		String text = Integer.toString(stepNum);
		if (leftFoot ^ rightFoot) {
			if (leftFoot) text += "L";
			if (rightFoot) text += "R";
		}

		Text.draw(canvas, text, point);
	}


	// Overrides
	@Override
	public String toString() {
		String string = point.toString();
		if (leftFoot) string += "L";
		if (rightFoot) string += "R";
		return string;
	}

}
