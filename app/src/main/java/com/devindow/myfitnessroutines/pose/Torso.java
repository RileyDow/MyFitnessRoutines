package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;

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

	public float waistY;

	public float rHipX;
	public float rHipY;
	public float lHipX;
	public float lHipY;


	// Public Properties
	public Extents getExtents() {
		return new Extents(
				Math.min(0 - thickness/2, headX - headSize/2),
				Math.max(waistY + thickness/2, headY + headSize/2),
				Math.max(0 + thickness/2, headX + headSize/2),
				Math.min(waistY - thickness/2, headY - headSize/2));
	}


	// Constructors
	public Torso() {
		this(false);
	}

	public Torso(Angle angle) {
		this(angle,false);
	}

	public Torso(float waistY) {
		this(waistY,false);
	}

	public Torso(float waistY, Angle angle) {
		this(waistY, angle, false);
	}

	public Torso(boolean isProfile) { this(Angle.N, isProfile); }

	public Torso(Angle angle, boolean isProfile) { this(Leg.segmentLength*2 + Leg.thickness/2, angle, isProfile); }

	public Torso(float waistY, boolean isProfile) { this(waistY, Angle.N, isProfile); }

	public Torso(float waistY, Angle angle, boolean isProfile) {

		// Waist
		this.waistY = waistY;

		// Collar
		collarX = Math.round(length * angle.getCos());
		collarY = waistY + Math.round(length * angle.getSin());

		// Head
		float waistToHead = length + thickness/2 + headSize/2;
		headX = Math.round(waistToHead * angle.getCos());
		headY = waistY + Math.round(waistToHead * angle.getSin());

		// Shoulders & Hips
		if (isProfile) {
			rShoulderX = lShoulderX = collarX;
			rShoulderY = lShoulderY = collarY;

			rHipX = lHipX = 0;
			rHipY = lHipY = waistY;
		} else {
			rShoulderX = collarX - distanceNeckToShoulder * angle.getSin();
			rShoulderY = collarY + distanceNeckToShoulder * angle.getCos();
			lShoulderX = collarX + distanceNeckToShoulder * angle.getSin();
			lShoulderY = collarY - distanceNeckToShoulder * angle.getCos();

			rHipX = -distanceWaistToHip * angle.getSin();
			rHipY = waistY + distanceWaistToHip * angle.getCos();
			lHipX = distanceWaistToHip * angle.getSin();
			lHipY = waistY - distanceWaistToHip * angle.getCos();
		}
	}


	// Public Methods
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		Debug.setPenColor(paint);

		// Draw Head
		paint.setStrokeWidth(headSize);
		canvas.drawPoint(headX, headY, paint);

		// Draw Torso
		Debug.setPenColor(paint);
		paint.setStrokeWidth(thickness);
		canvas.drawLine(collarX, collarY, 0, waistY, paint);
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
