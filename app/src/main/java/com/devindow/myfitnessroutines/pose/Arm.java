package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Arm implements Serializable {

	// Constants
	public static final float thickness = 4;
	public static final float segmentLength = 12;


	// Public Fields
	public Angle proximalAngle;
	public float proximalLength;

	public Angle distalAngle;
	public float distalLength;


	// Public Properties
	public float getElbowX(float shoulderX) {
		return shoulderX + Math.round(proximalLength * proximalAngle.getCos());
	}

	public float getElbowY(float shoulderY) {
		return shoulderY + Math.round(proximalLength * proximalAngle.getSin());
	}

	public float getHandX(float shoulderX) {
		return getElbowX(shoulderX) + Math.round(distalLength * distalAngle.getCos());
	}

	public float getHandY(float shoulderY) {
		return getElbowY(shoulderY) + Math.round(distalLength * distalAngle.getSin());
	}


	// Constructors
	public Arm(Angle angle) {
		this(angle, segmentLength, angle, segmentLength);
	}

	public Arm(Angle angle, float length) {
		this(angle, length/2, angle, length/2);
	}

	public Arm(Angle proximalAngle, Angle distalAngle) {
		this(proximalAngle, segmentLength, distalAngle, segmentLength);
	}

	public Arm(Angle proximalAngle, float proximalLength, Angle distalAngle) {
		this(proximalAngle, proximalLength, distalAngle, segmentLength);
	}

	public Arm(Angle proximalAngle, Angle distalAngle, float distalLength) {
		this(proximalAngle, segmentLength, distalAngle, distalLength);
	}

	public Arm(Angle proximalAngle, float proximalLength, Angle distalAngle, float distalLength) {
		this.proximalAngle = proximalAngle;
		this.proximalLength = proximalLength;

		this.distalAngle = distalAngle;
		this.distalLength = distalLength;
	}


	// Public Methods
	public void draw(Canvas canvas, float shoulderX, float shoulderY) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeWidth(thickness);
		Debug.setPenColor(paint);

		float elbowX = getElbowX(shoulderX);
		float elbowY = getElbowY(shoulderY);
		canvas.drawLine(shoulderX, shoulderY, elbowX, elbowY, paint);

		float handX = getHandX(shoulderX);
		float handY = getHandY(shoulderY);
		canvas.drawLine(elbowX, elbowY, handX, handY, paint);
	}


	// Public Static Methods
	public static float getHeight() { return getHeight(Angle.S); }

	public static float getHeight(Angle armAngle) {
		return getHeight(armAngle, armAngle);
	}

	public static float getHeight(Angle proximalAngle, Angle distalAngle) {
		return  Math.abs(segmentLength * proximalAngle.getSin() + segmentLength * distalAngle.getSin());
	}

	public static float getWidth(Angle armAngle) {
		return getWidth(armAngle, armAngle);
	}

	public static float getWidth(Angle proximalAngle, Angle distalAngle) {
		return  Math.abs(segmentLength * proximalAngle.getCos() + segmentLength * distalAngle.getCos());
	}

}
