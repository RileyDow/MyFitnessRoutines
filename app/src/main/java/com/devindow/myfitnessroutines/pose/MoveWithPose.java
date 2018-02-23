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
	public static final int BITMAP_SCALE = 10;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * BITMAP_SCALE;


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

	public MoveWithPose(String name, String description, Category category) {
		super(name, description, category);
	}

	public MoveWithPose(String name, Category category, boolean twoSides) {
		super(name, category, twoSides);
	}

	public MoveWithPose(String name, String description, boolean twoSides) {
		super(name, description, twoSides);
	}

	public MoveWithPose(String name, String description, Category category, boolean twoSides) {
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

		pose.draw(canvas);

		return bitmap;
	}
}
