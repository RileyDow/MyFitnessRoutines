package com.devindow.myfitnessroutines.routine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Devin on 2/22/2018.
 */

public class SoccerMove extends Move {

	// Constants
	public static final int BITMAP_INCHES = 60;
	public static final int PIXELS_PER_INCH = 10;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * PIXELS_PER_INCH;

	public static final float headSize = 10;
	public static final float torsoThickness = 8;
	public static final float shoulderWidth = 22;
	public static final float footWidth = 6;
	public static final float footLength = 7;
	public static final float footTurnOut = 1;
	public static final float footGap = 15;
	public static final float ballSize = 8.65f;


	// Public Fields
	public float ballX;
	public float ballY;
	public ArrayList<Arrow> arrows = new ArrayList<>();


	// Constructors
	public SoccerMove(String name) {
		super(name);
	}

	public SoccerMove(String name, boolean twoSides) {
		super(name, twoSides);
	}

	public SoccerMove(String name, Category category) {
		super(name, category);
	}

	public SoccerMove(String name, String description) {
		super(name, description);
	}

	public SoccerMove(String name, Category category, String description) {
		super(name, description, category);
	}

	public SoccerMove(String name, Category category, boolean twoSides) {
		super(name, category, twoSides);
	}

	public SoccerMove(String name, boolean twoSides, String description) {
		super(name, description, twoSides);
	}

	public SoccerMove(String name, Category category, boolean twoSides, String description) {
		super(name, description, category, twoSides);
	}


	// Overrides
	@Override
	public Bitmap getBitmap(boolean secondSide) {
		Bitmap bitmap = Bitmap.createBitmap(BITMAP_PIXELS, BITMAP_PIXELS, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		drawFrame(canvas, BITMAP_PIXELS);
		canvas.translate(BITMAP_PIXELS/2, BITMAP_PIXELS/3*2); // Origin to lower center
		canvas.scale(PIXELS_PER_INCH, PIXELS_PER_INCH); // Scale to Inches
		canvas.scale(1, -1); // up is positive Y
		if (secondSide) {
			canvas.scale(-1, 1); // mirror X
		}

		drawBall(canvas);

		drawBody(canvas);

		drawArrows(canvas);

		return bitmap;
	}

	private void drawBall(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setColor(Color.GRAY);

		paint.setStrokeWidth(ballSize);
		canvas.drawPoint(ballX, ballY, paint);
	}

	private void drawBody(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);

		// Draw Feet
		paint.setStrokeWidth(footWidth);
		paint.setColor(Color.GREEN);
		canvas.drawLine(-footGap/2, 0, -footGap/2-footTurnOut, footLength, paint);
		paint.setColor(Color.RED);
		canvas.drawLine(footGap/2, 0, footGap/2+footTurnOut, footLength, paint);

		// Draw Torso
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(torsoThickness);
		canvas.drawLine(-shoulderWidth/2, 0, shoulderWidth/2, 0, paint);

		// Draw Head
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(headSize);
		canvas.drawPoint(0, 0, paint);
	}

	private void drawArrows(Canvas canvas) {
		for (Arrow arrow : arrows) {
			arrow.draw(canvas);
		}
	}

}
