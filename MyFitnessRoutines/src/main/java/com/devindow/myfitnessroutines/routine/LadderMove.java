package com.devindow.myfitnessroutines.routine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.devindow.myfitnessroutines.Debug;

import java.util.ArrayList;

/**
 * Created by Devin on 2/22/2018.
 */

public class LadderMove extends Move {

	// Constants
	public static final int BITMAP_INCHES = 60;
	public static final int BITMAP_SCALE = 15;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * BITMAP_SCALE;

	public static final float ladderWidth = 17;
	public static final float rungGap = 19;


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

		drawLadder(canvas);

		return bitmap;
	}


	// Private Methods
	private void drawLadder(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.SQUARE);
		paint.setStrokeWidth(1);
		paint.setColor(Color.GRAY);

		// Draw Rails
		canvas.drawLine(-ladderWidth/2, rungGap, -ladderWidth/2, BITMAP_INCHES, paint);
		canvas.drawLine(ladderWidth/2, rungGap, ladderWidth/2, BITMAP_INCHES, paint);

		// Draw Rungs
		for (int i=1; ; i++) {
			float y = i*rungGap;
			if (y > BITMAP_INCHES) break;
			canvas.drawLine(-ladderWidth/2, y, ladderWidth/2, y, paint);
		}
	}

	private void drawSteps(Canvas canvas) {
		for (Step step : steps) {
			step.draw(canvas);
		}
	}


	// Static Methods
	public static PointF getLocation(int rungNum, boolean inside, boolean left) {

	}

}
