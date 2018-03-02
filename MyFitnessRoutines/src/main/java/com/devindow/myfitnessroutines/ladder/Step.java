package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.util.Point;
import com.devindow.myfitnessroutines.util.Text;

import java.io.Serializable;

/**
 * Created by Devin on 3/2/2018.
 */

public class Step implements Serializable {

	// Constants
	public static final float radius = 3;


	// Public Fields
	public Point point;
	public boolean leftFoot;
	public boolean rightFoot;


	// Constructors
	public Step(Point point, boolean leftFoot, boolean rightFoot) {
		this.point = point;
		this.leftFoot = leftFoot;
		this.rightFoot = rightFoot;
	}


	// Public Methods
	public void draw(Canvas canvas, int stepNum) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		canvas.drawCircle(point.x, point.y, radius, paint);

		Text.draw(canvas, Integer.toString(stepNum), point);
	}

}
