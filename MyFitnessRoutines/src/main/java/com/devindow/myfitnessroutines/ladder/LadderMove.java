package com.devindow.myfitnessroutines.ladder;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.devindow.myfitnessroutines.routine.*;
import com.devindow.myfitnessroutines.util.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 2/22/2018.
 */

public class LadderMove extends Move implements Serializable {

	// Constants
	public static final int BITMAP_INCHES = (int)Math.round(2.5*Ladder.rungGap + Step.radius + Step.radius);
	public static final int PIXELS_PER_INCH = 10;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * PIXELS_PER_INCH;


	// Public Fields
	public ArrayList<LadderStep> ladderSteps = new ArrayList<>();


	// Constructors
	public LadderMove(String name) {
		super(name);
	}

	public LadderMove(String name, boolean twoSides) {
		super(name, twoSides);
	}

	public LadderMove(String name, Category category) {
		super(name, category);
	}

	public LadderMove(String name, String description) {
		super(name, description);
	}

	public LadderMove(String name, Category category, String description) {
		super(name, description, category);
	}

	public LadderMove(String name, Category category, boolean twoSides) {
		super(name, category, twoSides);
	}

	public LadderMove(String name, boolean twoSides, String description) {
		super(name, description, twoSides);
	}

	public LadderMove(String name, Category category, boolean twoSides, String description) {
		super(name, description, category, twoSides);
	}


	// Overrides
	@Override
	public Bitmap getBitmap(boolean mirrored) {
		Bitmap bitmap = Bitmap.createBitmap(BITMAP_PIXELS, BITMAP_PIXELS, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		drawFrame(canvas, BITMAP_PIXELS);
		canvas.translate(BITMAP_PIXELS/2, BITMAP_PIXELS-1); // Origin at bottom center
		canvas.scale(PIXELS_PER_INCH, PIXELS_PER_INCH); // Scale to Inches
		canvas.scale(1, -1); // up is positive Y
		canvas.translate(0, Ladder.rungGap/2 + Step.radius); // Origin moved up for starting point

		Ladder.draw(canvas);

		drawSteps(canvas);

		return bitmap;
	}


	// Private Methods
	private void drawSteps(Canvas canvas) {
		if (ladderSteps.size() == 0) {
			return;
		}

		// Draw start Step
		LadderStep start = ladderSteps.get(0);
		start.draw(canvas, 0);

		// Pre-set last Step to start Step
		LadderStep lastLeft = start;
		LadderStep lastRight = start;

		for (int i = 1; i< ladderSteps.size(); i++) {
			LadderStep ladderStep = ladderSteps.get(i);

			// Draw line from last Step to the Step
			if (ladderStep.hasLeft()) {
				Arrow arrow = new Arrow(lastLeft.getLeft(), ladderStep.getLeft(), Side.LEFT);
				arrow.shorten(Step.radius + 1, false, true);
				arrow.draw(canvas);
				lastLeft = ladderStep;
			}

			if (ladderStep.hasRight()) {
				Arrow arrow = new Arrow(lastRight.getRight(), ladderStep.getRight(), Side.RIGHT);
				arrow.shorten(Step.radius + 1, false, true);
				arrow.draw(canvas);
				lastRight = ladderStep;
			}

			// Draw Step
			ladderStep.draw(canvas, i);
		}
	}

}
