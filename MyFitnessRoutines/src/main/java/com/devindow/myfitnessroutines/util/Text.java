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

	// Static Methods
	public static void draw(Canvas canvas, String text, Point point) {
		canvas.save();

		canvas.scale(1, -1); // Write text right-side-up.

		TextPaint textPaint = new TextPaint();
		textPaint.setTextSize(textHeight);
		textPaint.setColor(Color.WHITE);
		textPaint.setTextAlign(Paint.Align.CENTER);

		canvas.drawText(text, point.x, -point.y + textHeight/2, textPaint);

		canvas.restore();
	}
}
