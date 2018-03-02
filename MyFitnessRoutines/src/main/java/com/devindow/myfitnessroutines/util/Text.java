package com.devindow.myfitnessroutines.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Devin on 3/2/2018.
 */

public class Text {

	// Static Methods
	public static void draw(Canvas canvas, String text, Point point) {
		canvas.save();

		canvas.scale(1, -1); // Write text right-side-up.

		Paint paint = new Paint();
		paint.setColor(Color.LTGRAY);
		canvas.drawText(text, point.x, -point.y, paint);

		canvas.restore();
	}
}
