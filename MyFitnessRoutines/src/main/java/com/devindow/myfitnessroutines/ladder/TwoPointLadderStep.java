package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.*;

/**
 * Created by Devin on 3/2/2018.
 */

public class TwoPointLadderStep extends LadderStep {

	// Public Fields
	public Step left;
	public Step right;


	// Constructors
	public TwoPointLadderStep(Point left, Point right) {
		this.left = new Step(Side.LEFT, left);
		this.right = new Step(Side.RIGHT, right);
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint bodyPaint = new Paint();
		bodyPaint.setColor(Colors.bodyTrans);
		bodyPaint.setStrokeWidth(LadderStep.radius*2);
		bodyPaint.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawLine(left.point.x, left.point.y, right.point.x, right.point.y, bodyPaint);

		left.draw(canvas, stepNum);

		right.draw(canvas, stepNum);
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
		return left.point;
	}

	@Override
	public Point getRight() {
		return right.point;
	}


	@Override
	public String toString() {
		return left.toString() + ", " + right.toString();
	}
}
