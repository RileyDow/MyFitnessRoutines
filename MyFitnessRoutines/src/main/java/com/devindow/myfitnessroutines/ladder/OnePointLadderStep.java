package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;

import com.devindow.myfitnessroutines.util.*;

/**
 * Created by Devin on 3/2/2018.
 */

public class OnePointLadderStep extends LadderStep {

	// Public Fields
	public Step step;


	// Constructors
	public OnePointLadderStep(Point point) {
		this(Feet.BOTH, point);
	}

	public OnePointLadderStep(Feet feet, Point point) {
		this.step = new Step(feet, point);
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		step.draw(canvas, stepNum);
	}


	// Overrides
	@Override
	public boolean hasLeft() {
		return step.feet.hasLeft();
	}

	@Override
	public boolean hasRight() {
		return step.feet.hasRight();
	}

	@Override
	public boolean hasBoth() {
		return step.feet.hasBoth();
	}


	@Override
	public Point getLeft() {
		return step.point;
	}

	@Override
	public Point getRight() {
		return step.point;
	}


	@Override
	public String toString() {
		return step.toString();
	}

}
