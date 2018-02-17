package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Torso implements Serializable {

	// Constants
	public static final float headSize = 10;
	public static final float thickness = 10;
	public static final float length = 20;
	public static final float lengthWithHead = length + headSize;
	private static final float distanceNeckToShoulder = thickness/2 + Arm.thickness/2;
	private static final float distanceWaistToHip = Leg.thickness/2 - 1;


	// Public Fields
	public float headX;
	public float headY;

	public float collarX;
	public float collarY;

	public float rShoulderX;
	public float rShoulderY;
	public float lShoulderX;
	public float lShoulderY;

	public float waistX;
	public float waistY;

	public float rHipX;
	public float rHipY;
	public float lHipX;
	public float lHipY;


	// Constructors
	public Torso() {
		this(false);
	}

	public Torso(float waistX) {
		this(waistX,false);
	}

	public Torso(Angle angle) {
		this(angle,false);
	}

	public Torso(float waistX, Angle angle) {
		this(waistX, angle, false);
	}

	public Torso(float waistX, float waistY) {
		this(waistX, waistY,false);
	}

	public Torso(float waistX, float waistY, Angle angle) {
		this(waistX, waistY, angle, false);
	}

	public Torso(boolean isProfile) { this(0, isProfile); }

	public Torso(float waistX, boolean isProfile) { this(waistX, Angle.N, isProfile); }

	public Torso(Angle angle, boolean isProfile) { this(0, angle, isProfile); }

	public Torso(float waistX, Angle angle, boolean isProfile) { this(waistX, Leg.segmentLength*2 + Leg.thickness/2, angle, isProfile); }

	public Torso(float waistX, float waistY, boolean isProfile) { this(waistX, waistY, Angle.N, isProfile); }

	public Torso(float waistX, float waistY, Angle angle, boolean isProfile) {

		// Waist
		this.waistX = waistX;
		this.waistY = waistY;

		// Collar
		collarX = waistX + Math.round(length * angle.getCos());
		collarY = waistY + Math.round(length * angle.getSin());

		// Head
		float waistToHead = length + thickness/2 + headSize/2;
		headX = waistX + Math.round(waistToHead * angle.getCos());
		headY = waistY + Math.round(waistToHead * angle.getSin());

		// Shoulders & Hips
		if (isProfile) {
			rShoulderX = lShoulderX = collarX;
			rShoulderY = lShoulderY = collarY;

			rHipX = lHipX = waistX;
			rHipY = lHipY = waistY;
		} else {
			rShoulderX = collarX - distanceNeckToShoulder * angle.getSin();
			rShoulderY = collarY + distanceNeckToShoulder * angle.getCos();
			lShoulderX = collarX + distanceNeckToShoulder * angle.getSin();
			lShoulderY = collarY - distanceNeckToShoulder * angle.getCos();

			rHipX = waistX - distanceWaistToHip * angle.getSin();
			rHipY = waistY + distanceWaistToHip * angle.getCos();
			lHipX = waistX + distanceWaistToHip * angle.getSin();
			lHipY = waistY - distanceWaistToHip * angle.getCos();
		}
	}


	// Public Methods
	public void draw(Canvas canvas) {
		Paint p = new Paint();
		p.setStrokeCap(Paint.Cap.ROUND);
		p.setStrokeJoin(Paint.Join.ROUND);
		Debug.setPenColor(p);

		// Draw Head
		p.setStrokeWidth(headSize);
		canvas.drawPoint(headX, headY, p);

		// Draw Torso
		Debug.setPenColor(p);
		p.setStrokeWidth(thickness);
		canvas.drawLine(collarX, collarY, waistX, waistY, p);
	}


	// Public Static Methods
	public static float getHeight() { return getHeight(Angle.N); }

	public static float getHeight(Angle bodyAngle) {
		return  Math.abs(lengthWithHead * bodyAngle.getSin());
	}

	public static float getWidth() {
		return getWidth(Angle.N);
	}

	public static float getWidth(Angle bodyAngle) {
		return  Math.abs(lengthWithHead * bodyAngle.getCos());
	}


	public static float getHipHeight() {
		return getHipHeight(Angle.N);
	}

	public static float getHipHeight(Angle bodyAngle) {
		return  Math.abs(distanceWaistToHip * bodyAngle.add(90).getSin());
	}

	public static float getHipWidth() {
		return getHipWidth(Angle.N);
	}

	public static float getHipWidth(Angle bodyAngle) {
		return  Math.abs(distanceWaistToHip * bodyAngle.add(90).getCos());
	}

}
