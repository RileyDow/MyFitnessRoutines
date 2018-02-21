package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.routine.Move;

/**
 * Created by Devin on 2/13/2018.
 */

public class Floor {

	public static void draw(Canvas canvas) {
		Paint p = new Paint();
		p.setStrokeWidth(1);

		canvas.drawLine(-Move.bitmapInches/2, 0, Move.bitmapInches/2, 0, p);
	}

}
