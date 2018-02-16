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
	public Arm(float handX, float handY) {
		this.handX = handX;
		this.handY = handY;
	}

	public Arm(float shoulderX, float shoulderY, Angle angle, float length) {
		handX = shoulderX + Math.round(length * angle.getCos());
		handY = shoulderY + Math.round(length * angle.getSin());
	}

	public Arm(float handX, float handY, float elbowX, float elbowY) {
		this.handX = handX;
		this.handY = handY;

		this.elbowX = elbowX;
		this.elbowY = elbowY;
	}

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
		p.setColor(Color.BLACK);

		if (Debug.colors) { p.setColor(Color.RED); }
		if (elbowX != null && elbowY != null) {
			canvas.drawLine(shoulderX, shoulderY, elbowX, elbowY, p);
			canvas.drawLine(elbowX, elbowY, handX, handY, p);
		}
		else {
			canvas.drawLine(shoulderX, shoulderY, handX, handY, p);
		}
	}
}
