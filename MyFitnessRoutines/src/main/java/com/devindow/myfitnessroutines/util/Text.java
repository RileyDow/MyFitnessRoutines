package com.devindow.myfitnessroutines.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;

/**
 * Created by Devin on 3/2/2018.
 */

public class Text {

	// Constants
	public static final float textHeight = 3;
	public static final float textHalfHeight = .4f*textHeight;


	// Static Methods
	public static void draw(Canvas canvas, String text, Point point, boolean mirrored) {
		canvas.save();

		canvas.translate(point.x, point.y); // Move to location.

		if (mirrored) { // Write text forward if we are mirrored.
			canvas.scale(-1, 1);
		}

		canvas.scale(1, -1); // Write text right-side-up.

		TextPaint textPaint = new TextPaint();
		textPaint.setTextSize(textHeight);
		textPaint.setColor(Color.BLACK);
		textPaint.setTextAlign(Paint.Align.CENTER);

		canvas.drawText(text, 0, textHalfHeight, textPaint);

		canvas.restore();
	}

}
