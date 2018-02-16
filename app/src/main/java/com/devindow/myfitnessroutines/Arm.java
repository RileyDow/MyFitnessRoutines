package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Devin on 2/16/2018.
 */

public class Arm {

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
		/*this.handX = handX;
		this.handY = handY;*/
	}

	public Arm(float handX, float handY, float elbowX, float elbowY) {
		this.handX = handX;
		this.handY = handY;

		this.elbowX = elbowX;
		this.elbowY = elbowY;
	}

	public Arm(float shoulderX, float shoulderY, Angle upperAngle, float upperLength, Angle lowerAngle, float lowerLength) {
		/*this.handX = handX;
		this.handY = handY;

		this.elbowX = elbowX;
		this.elbowY = elbowY;*/
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
