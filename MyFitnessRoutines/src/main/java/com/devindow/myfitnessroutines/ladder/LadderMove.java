package com.devindow.myfitnessroutines.ladder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.devindow.myfitnessroutines.routine.Category;
import com.devindow.myfitnessroutines.routine.Move;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 2/22/2018.
 */

public class LadderMove extends Move implements Serializable {

	// Constants
	public static final int BITMAP_INCHES = 60;
	public static final int BITMAP_SCALE = 15;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * BITMAP_SCALE;


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

	public LadderMove(String name, String description, Category category) {
		super(name, description, category);
	}

	public LadderMove(String name, Category category, boolean twoSides) {
		super(name, category, twoSides);
	}

	public LadderMove(String name, String description, boolean twoSides) {
		super(name, description, twoSides);
	}

	public LadderMove(String name, String description, Category category, boolean twoSides) {
		super(name, description, category, twoSides);
	}


	// Overrides
	@Override
	public Bitmap getBitmap(boolean secondSide) {
		Bitmap bitmap = Bitmap.createBitmap(BITMAP_PIXELS, BITMAP_PIXELS, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		drawFrame(canvas, BITMAP_PIXELS);
		canvas.translate(BITMAP_PIXELS /2, BITMAP_PIXELS -1); // Origin at floor center
		canvas.scale(BITMAP_SCALE, BITMAP_SCALE); // 10x BITMAP_SCALE
		canvas.scale(1, -1); // up is positive Y
		if (secondSide) {
			canvas.scale(-1, 1); // mirror X
		}

		Ladder.draw(canvas);

		drawSteps(canvas);

		return bitmap;
	}


	// Private Methods
	private void drawSteps(Canvas canvas) {
		for (int i=0; i<steps.size(); i++) {
			Step step = steps.get(i);
			step.draw(canvas, i);
		}
	}

}
