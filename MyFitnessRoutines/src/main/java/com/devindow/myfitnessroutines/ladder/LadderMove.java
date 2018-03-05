package com.devindow.myfitnessroutines.ladder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.routine.Category;
import com.devindow.myfitnessroutines.routine.Move;
import com.devindow.myfitnessroutines.util.Colors;

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
	public ArrayList<Step> steps = new ArrayList<>();


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
	public Bitmap getBitmap(boolean secondSide) {
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
		if (steps.size() == 0) {
			return;
		}

		Step start = steps.get(0);
		start.draw(canvas, 0);

		Step lastLeft = start;
		Step lastRight = start;

		Paint arrowPaint = new Paint();
		arrowPaint.setStrokeWidth(0.5f);

		for (int i=1; i<steps.size(); i++) {
			Step step = steps.get(i);

			if (step.hasLeft()) {
				arrowPaint.setColor(Colors.generate(.5f, 0,1, 0));
				canvas.drawLine(lastLeft.getLeft().x, lastLeft.getLeft().y, step.getLeft().x, step.getLeft().y, arrowPaint);
				lastLeft = step;
			}

			if (step.hasRight()) {
				arrowPaint.setColor(Colors.generate(.5f, 1,0, 0));
				canvas.drawLine(lastRight.getRight().x, lastRight.getRight().y, step.getRight().x, step.getRight().y, arrowPaint);
				lastRight = step;
			}

			step.draw(canvas, i);
		}
	}

}
