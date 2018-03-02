package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

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
		paint.setColor(Color.GRAY);

		// Draw Rails
		canvas.drawLine(-width/2, rungGap, -width/2, LadderMove.BITMAP_INCHES, paint);
		canvas.drawLine(width/2, rungGap, width/2, LadderMove.BITMAP_INCHES, paint);

		// Draw Rungs
		for (int i=1; ; i++) {
			float y = i*rungGap;
			if (y > LadderMove.BITMAP_INCHES) break;
			canvas.drawLine(-width/2, y, width/2, y, paint);
		}
	}

	public static PointF getLocation(int rungNum, boolean inside, boolean onTheLeft) {
		return new PointF();
	}

}
