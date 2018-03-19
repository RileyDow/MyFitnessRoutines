package com.devindow.myfitnessroutines.soccer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.devindow.myfitnessroutines.util.Arrow;
import com.devindow.myfitnessroutines.util.Colors;
import com.devindow.myfitnessroutines.util.Point;
import com.devindow.myfitnessroutines.util.Step;

/**
 * Created by Devin on 3/6/2018.
 */

public class SoccerStep extends SoccerMotion {

	// Public Fields
	public Step step;
	public Point from;



	// Constructor
	public SoccerStep(Step step) {
		this(step, null);
	}

	public SoccerStep(Step step, Point from) {
		this.step = step;
		this.from = from;
	}


	// SoccerMotion implementation
	public void draw(Canvas canvas, int stepNum, boolean mirror) {
		if (from != null) {
			Paint paint = new Paint();
			Colors.setFootColor(paint, step.side, true, mirror);
			paint.setStrokeWidth(Arrow.width);
			//paint.setStrokeCap(Paint.Cap.ROUND);
			//paint.setStrokeJoin(Paint.Join.ROUND);

			Point center = Point.getMiddle(from, step.point);
			float radius = Point.getDistance(from, step.point) / 2;
			RectF rect = new RectF(center.x - radius, center.y - radius, center.x + radius, center.y + radius);
			float startAngle = (float)Math.toDegrees(Point.getAngle(from, step.point));
			float sweepAngle = from.x < step.point.x ? 180 : -180;
			canvas.drawArc(rect, startAngle, sweepAngle, false, paint);
		}

		step.draw(canvas, stepNum, mirror);
	}

}
