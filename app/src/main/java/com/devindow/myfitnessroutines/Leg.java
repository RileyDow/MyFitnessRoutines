package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Leg implements Serializable {

	// Constants
	public static final float thickness = 6;
	public static final float segmentLength = 17;


	// Public Fields
	public float footX;
	public float footY;

	public Float kneeX;
	public Float kneeY;


	// Constructors
	public Leg(float hipX, float hipY) {
		this(hipX, hipY, Angle.S);
	}

	public Leg(float hipX, float hipY, Angle angle) {
		this(hipX, hipY, angle, segmentLength*2);
	}

	public Leg(float hipX, float hipY, Angle angle, float length) {
		footX = hipX + Math.round(length * angle.getCos());
		footY = hipY + Math.round(length * angle.getSin());
	}

	public Leg(float hipX, float hipY, Angle proximalAngle, Angle distalAngle) { this(hipX, hipY, proximalAngle, segmentLength, distalAngle, segmentLength); }

	public Leg(float hipX, float hipY, Angle proximalAngle, float proximalLength, Angle distalAngle) { this(hipX, hipY, proximalAngle, proximalLength, distalAngle, segmentLength); }

	public Leg(float hipX, float hipY, Angle proximalAngle, Angle distalAngle, float distalLength) { this(hipX, hipY, proximalAngle, segmentLength, distalAngle, distalLength); }

	public Leg(float hipX, float hipY, Angle proximalAngle, float proximalLength, Angle distalAngle, float distalLength) {
		kneeX = hipX + Math.round(proximalLength * proximalAngle.getCos());
		kneeY = hipY + Math.round(proximalLength * proximalAngle.getSin());

		footX = kneeX + Math.round(distalLength * distalAngle.getCos());
		footY = kneeY + Math.round(distalLength * distalAngle.getSin());
	}


	// Public Methods
	public void draw(Canvas canvas, float hipX, float hipY) {
		Paint p = new Paint();
		p.setStrokeCap(Paint.Cap.ROUND);
		p.setStrokeJoin(Paint.Join.ROUND);
		p.setStrokeWidth(thickness);
		Debug.setPenColor(p);

		if (kneeX != null && kneeY != null) {
			canvas.drawLine(hipX, hipY, kneeX, kneeY, p);
			canvas.drawLine(kneeX, kneeY, footX, footY, p);
		}
		else {
			canvas.drawLine(hipX, hipY, footX, footY, p);
		}
	}


	// Public Static Methods
	public static float getHeight() { return getHeight(Angle.S); }

	public static float getHeight(Angle legAngle) {
		return getHeight(legAngle, legAngle);
	}

	public static float getHeight(Angle proximalAngle, Angle distalAngle) {
		return  Math.abs(segmentLength * proximalAngle.getSin() + segmentLength * distalAngle.getSin());
	}

	public static float getWidth(Angle legAngle) {
		return getWidth(legAngle, legAngle);
	}

	public static float getWidth(Angle proximalAngle, Angle distalAngle) {
		return  Math.abs(segmentLength * proximalAngle.getCos() + segmentLength * distalAngle.getCos());
	}

}
