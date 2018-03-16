package com.devindow.myfitnessroutines.pose;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.devindow.myfitnessroutines.routine.Move;
import com.devindow.myfitnessroutines.routine.Category;

/**
 * Created by Devin on 2/22/2018.
 */

public class MoveWithPose extends Move {

	// Constants
	public static final int BITMAP_INCHES = 90;
	public static final int PIXELS_PER_INCH = 10;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * PIXELS_PER_INCH;


	// Public Fields
	public Pose pose;


	// Constructors
	public MoveWithPose(String name) {
		super(name);
	}

	public MoveWithPose(String name, boolean twoSides) {
		super(name, twoSides);
	}

	public MoveWithPose(String name, Category category) {
		super(name, category);
	}

	public MoveWithPose(String name, String description) {
		super(name, description);
	}

	public MoveWithPose(String name, Category category, String description) {
		super(name, description, category);
	}

	public MoveWithPose(String name, Category category, boolean twoSides) {
		super(name, category, twoSides);
	}

	public MoveWithPose(String name, boolean twoSides, String description) {
		super(name, description, twoSides);
	}

	public MoveWithPose(String name, Category category, boolean twoSides, String description) {
		super(name, description, category, twoSides);
	}


	// Overrides
	@Override
	public Bitmap getBitmap(boolean mirrored) {
		Bitmap bitmap = Bitmap.createBitmap(BITMAP_PIXELS, BITMAP_PIXELS, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		drawFrame(canvas, BITMAP_PIXELS);
		canvas.translate(BITMAP_PIXELS /2, BITMAP_PIXELS -1); // Origin at floor center
		canvas.scale(PIXELS_PER_INCH, PIXELS_PER_INCH); // Scale to Inches
		canvas.scale(1, -1); // up is positive Y
		if (mirrored) {
			canvas.scale(-1, 1); // mirror X
		}

		if (pose != null) {
			pose.draw(canvas);
		}

		return bitmap;
	}
}
