package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Colors;
import com.devindow.myfitnessroutines.util.Point;
import com.devindow.myfitnessroutines.util.Text;

/**
 * Created by Devin on 3/2/2018.
 */

public class DoubleStep extends Step {

	// Public Fields
	public Point left;
	public Point right;


	// Constructors
	public DoubleStep(Point left, Point right) {
		this.left = left;
		this.right = right;
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint bodyPaint = new Paint();
		bodyPaint.setColor(Colors.bodyTrans);
		bodyPaint.setStrokeWidth(Step.radius*2);
		bodyPaint.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawLine(left.x, left.y, right.x, right.y, bodyPaint);

		Paint paint = new Paint();

		String text = Integer.toString(stepNum);

		paint.setColor(Colors.generate(0, 1, 0));
		canvas.drawCircle(left.x, left.y, radius, paint);
		Text.draw(canvas, text + "-L", left);

		paint.setColor(Colors.generate(1, 0, 0));
		canvas.drawCircle(right.x, right.y, radius, paint);
		Text.draw(canvas, text + "-R", right);
	}


	// Overrides
	@Override
	public boolean hasLeft() {
		return true;
	}

	@Override
	public boolean hasRight() {
		return true;
	}

	@Override
	public boolean hasBoth() {
		return true;
	}


	@Override
	public Point getLeft() {
		return left;
	}

	@Override
	public Point getRight() {
		return right;
	}


	@Override
	public String toString() {
		return left.toString() + "L, " + right.toString() + "R";
	}
}
