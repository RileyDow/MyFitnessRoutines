package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Devin on 2/16/2018.
 */

public class Leg {

	// Constants
	public static final float thickness = 6;
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
		/*this.footX = footX;
		this.footY = footY;*/
	}

	public Leg(float footX, float footY, float kneeX, float kneeY) {
		this.footX = footX;
		this.footY = footY;

		this.kneeX = kneeX;
		this.kneeY = kneeY;
	}

	public Leg(float hipX, float hipY, Angle upperAngle, float upperLength, Angle lowerAngle, float lowerLength) {
		/*this.footX = footX;
		this.footY = footY;

		this.kneeX = kneeX;
		this.kneeY = kneeY;*/
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
