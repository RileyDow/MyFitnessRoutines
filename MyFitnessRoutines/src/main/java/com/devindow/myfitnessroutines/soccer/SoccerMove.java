package com.devindow.myfitnessroutines.soccer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.routine.*;
import com.devindow.myfitnessroutines.util.*;

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
	public static final float footGap = 22;
	public static final float ballSize = 8.65f;


	// Public Fields
	public Point ball;
	public ArrayList<SoccerMotion> motions = new ArrayList<>();


	// Public Properties
	public Point getToe() {
		return new Point(footGap/2+footTurnOut, footLength);
	}


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
	public Bitmap getBitmap(boolean mirrored) {
		Bitmap bitmap = Bitmap.createBitmap(BITMAP_PIXELS, BITMAP_PIXELS, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		drawFrame(canvas, BITMAP_PIXELS);
		canvas.translate(BITMAP_PIXELS/2, BITMAP_PIXELS/3*2); // Origin to lower center
		canvas.scale(PIXELS_PER_INCH, PIXELS_PER_INCH); // Scale to Inches
		canvas.scale(1, -1); // up is positive Y
		if (mirrored) {
			canvas.scale(-1, 1); // mirror X
		}

		drawBall(canvas);

		drawBody(canvas, mirrored);

		drawMotions(canvas, mirrored);

		return bitmap;
	}


	// Private Methods
	private void drawBall(Canvas canvas) {
		if (ball == null) {
			return;
		}

		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setColor(Color.GRAY);

		paint.setStrokeWidth(ballSize);
		canvas.drawPoint(ball.x, ball.y, paint);
	}

	private void drawBody(Canvas canvas, boolean mirrored) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);

		// Draw Feet
		Point toe = getToe();
		paint.setStrokeWidth(footWidth);
		Colors.setFootColor(paint, Side.LEFT, false, mirrored);
		canvas.drawLine(-footGap/2, 0, -toe.x, toe.y, paint);
		Colors.setFootColor(paint, Side.RIGHT, false, mirrored);
		canvas.drawLine(footGap/2, 0, toe.x, toe.y, paint);

		// Draw Torso
		Colors.setBodyColor(paint, true);
		paint.setStrokeWidth(torsoThickness);
		canvas.drawLine(-shoulderWidth/2, 0, shoulderWidth/2, 0, paint);

		// Draw Head
		paint.setStrokeWidth(headSize);
		canvas.drawPoint(0, 0, paint);
	}

	private void drawMotions(Canvas canvas, boolean mirror) {
		for (int i=0; i<motions.size(); i++) {
			SoccerMotion motion = motions.get(i);
			motion.draw(canvas, i+1, mirror);
		}
	}

}
