package com.devindow.myfitnessroutines.routine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;
import com.devindow.myfitnessroutines.pose.Angle;

/**
 * Created by Devin on 2/22/2018.
 */

public class SoccerMove extends Move {

	// Constants
	public static final int BITMAP_INCHES = 90;
	public static final int PIXELS_PER_INCH = 10;
	public static final int BITMAP_PIXELS = BITMAP_INCHES * PIXELS_PER_INCH;


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
		canvas.translate(BITMAP_PIXELS /2, BITMAP_PIXELS -1); // Origin at floor center
		canvas.scale(PIXELS_PER_INCH, PIXELS_PER_INCH); // Scale to Inches
		canvas.scale(1, -1); // up is positive Y
		if (secondSide) {
			canvas.scale(-1, 1); // mirror X
		}

		/*Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(2);

		for (int i=0; i<=90; i+=1) {
			Angle angle = new Angle(180-i);
			if (i%5 == 0) { paint.setColor(Color.RED); } else { paint.setColor(Color.BLACK);}
			canvas.drawLine(0, 0, (float)Math.cos(angle.radians)*i, (float)Math.sin(angle.radians)*i, paint);
		}

		for (int i=0; i<=100; i+=5) {
			Angle angle = new Angle(0f, i, 100);
			if (i%5 == 0) { paint.setColor(Color.RED); } else { paint.setColor(Color.BLACK);}
			Debug.d("Angle=", angle.toString());
			canvas.drawLine(0, 0, (float)Math.cos(angle.radians)*100, (float)Math.sin(angle.radians)*100, paint);
		}*/

		return bitmap;
	}
}
