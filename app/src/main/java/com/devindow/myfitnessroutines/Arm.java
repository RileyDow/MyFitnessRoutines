package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Arm implements Serializable {

	// Constants
	public static final float thickness = 4;
	public static final float segmentLength = 12;


	// Public Fields
	public float handX;
	public float handY;

	public Float elbowX;
	public Float elbowY;


	// Constructors
	public Arm(float shoulderX, float shoulderY) { this(shoulderX, shoulderY, Angle.S); }

	public Arm(float shoulderX, float shoulderY, Angle angle) { this(shoulderX, shoulderY, angle, segmentLength*2); }

	public Arm(float shoulderX, float shoulderY, Angle angle, float length) {
		handX = shoulderX + Math.round(length * angle.getCos());
		handY = shoulderY + Math.round(length * angle.getSin());
	}

	public Arm(float shoulderX, float shoulderY, Angle proximalAngle, Angle distalAngle) { this(shoulderX, shoulderY, proximalAngle, segmentLength, distalAngle, segmentLength); }

	public Arm(float shoulderX, float shoulderY, Angle proximalAngle, float proximalLength, Angle distalAngle) { this(shoulderX, shoulderY, proximalAngle, proximalLength, distalAngle, segmentLength); }

	public Arm(float shoulderX, float shoulderY, Angle proximalAngle, Angle distalAngle, float distalLength) { this(shoulderX, shoulderY, proximalAngle, segmentLength, distalAngle, distalLength); }

	public Arm(float shoulderX, float shoulderY, Angle proximalAngle, float proximalLength, Angle distalAngle, float distalLength) {
		elbowX = shoulderX + Math.round(proximalLength * proximalAngle.getCos());
		elbowY = shoulderY + Math.round(proximalLength * proximalAngle.getSin());

		handX = elbowX + Math.round(distalLength * distalAngle.getCos());
		handY = elbowY + Math.round(distalLength * distalAngle.getSin());
	}


	// Public Methods
	public void draw(Canvas canvas, float shoulderX, float shoulderY) {
		Paint p = new Paint();
		p.setStrokeCap(Paint.Cap.ROUND);
		p.setStrokeJoin(Paint.Join.ROUND);
		p.setStrokeWidth(thickness);
		Debug.setPenColor(p);

		if (elbowX != null && elbowY != null) {
			canvas.drawLine(shoulderX, shoulderY, elbowX, elbowY, p);
			canvas.drawLine(elbowX, elbowY, handX, handY, p);
		}
		else {
			canvas.drawLine(shoulderX, shoulderY, handX, handY, p);
		}
	}
}
