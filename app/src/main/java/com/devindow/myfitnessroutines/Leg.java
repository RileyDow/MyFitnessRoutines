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
	public static final float thickness = 5;
	public static final float segmentLength = 17;


	// Public Fields
	public float footX;
	public float footY;

	public Float kneeX;
	public Float kneeY;


	// Constructors
	public Leg(float footX, float footY) {
		this.footX = footX;
		this.footY = footY;
	}

	public Leg(float hipX, float hipY, Angle angle, float length) {
		footX = hipX + Math.round(length * angle.getCos());
		footY = hipY + Math.round(length * angle.getSin());
	}

	public Leg(float footX, float footY, float kneeX, float kneeY) {
		this.footX = footX;
		this.footY = footY;

		this.kneeX = kneeX;
		this.kneeY = kneeY;
	}

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
		p.setColor(Color.BLACK);

		if (Debug.colors) { p.setColor(Color.RED); }
		if (kneeX != null && kneeY != null) {
			canvas.drawLine(hipX, hipY, kneeX, kneeY, p);
			canvas.drawLine(kneeX, kneeY, footX, footY, p);
		}
		else {
			canvas.drawLine(hipX, hipY, footX, footY, p);
		}
	}

}
