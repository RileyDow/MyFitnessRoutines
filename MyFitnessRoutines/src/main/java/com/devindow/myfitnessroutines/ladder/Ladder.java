package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Point;

/**
 * Created by Devin on 3/2/2018.
 */

public class Ladder {

	// Constants
	public static final float width = 17;
	public static final float rungGap = 19;


	// Static Methods
	public static void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.SQUARE);
		paint.setStrokeWidth(1);
		paint.setColor(Color.DKGRAY);

		// Draw Rails
		canvas.drawLine(-width/2, 0, -width/2, LadderMove.BITMAP_INCHES, paint);
		canvas.drawLine(width/2, 0, width/2, LadderMove.BITMAP_INCHES, paint);

		// Draw Rungs
		for (int i=0; ; i++) {
			float y = i*rungGap;
			if (y > LadderMove.BITMAP_INCHES) break;
			canvas.drawLine(-width/2, y, width/2, y, paint);
		}
	}

	public static Point getLocation(float squareNum, boolean inside) { return getLocation(squareNum, inside, false); }

	public static Point getLocation(float squareNum, boolean inside, boolean onTheLeft) {
		float x = 0;
		if (!inside) {
			if (onTheLeft) {
				x = -Ladder.width;
			} else {
				x = Ladder.width;
			}
		}

		float y = (squareNum-1)*rungGap + rungGap/2;

		return new Point(x, y);
	}

}
