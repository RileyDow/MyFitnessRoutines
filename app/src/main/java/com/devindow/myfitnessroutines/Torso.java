package com.devindow.myfitnessroutines;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Devin on 2/16/2018.
 */

public class Torso {

	// Constants
	public static final float headSize = 10;
	public static final float thickness = 10;
	public static final float length = 20;


	// Public Fields
	public int degrees;

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


	// Public Properties
	public double getRadians() { return Math.toRadians(degrees); }


	// Constructors
	public Torso(float waistX, float waistY, int degrees, boolean isProfile) {
		this.waistY = waistX;
		this.waistY = waistY;
		this.degrees = degrees;

		double radians = getRadians();

		collarX = waistX + (int)Math.round(length * Math.cos(radians));
		collarY = waistY + (int)Math.round(length * Math.sin(radians));

		float waistToHead = length + thickness/2 + headSize/2;
		headX = waistX + (int)Math.round(waistToHead * Math.cos(radians));
		headY = waistY + (int)Math.round(waistToHead * Math.sin(radians));

		generateShoulderAndHipCoords(isProfile);
	}


	// Public Methods
	public void draw(Canvas canvas) {
		Paint p = new Paint();
		p.setStrokeCap(Paint.Cap.ROUND);
		p.setStrokeJoin(Paint.Join.ROUND);
		p.setColor(Color.BLACK);

		// Draw Head
		p.setStrokeWidth(headSize);
		canvas.drawPoint(headX, headY, p);

		// Draw Torso
		if (Debug.colors) { p.setColor(Color.MAGENTA); }
		p.setStrokeWidth(thickness);
		canvas.drawLine(collarX, collarY, waistX, waistY, p);
	}


	// Protected Methods
	protected void generateShoulderAndHipCoords(boolean isProfile) {
		if (isProfile) {
			rShoulderX = lShoulderX = collarX;
			rShoulderY = lShoulderY = collarY;

			rHipX = lHipX = waistX;
			rHipY = lHipY = waistY;
		} else {
			double radians = getRadians();

			float distanceNeckToShoulder = 0.5f * thickness + 0.5f * Arm.thickness;
			rShoulderX = collarX - distanceNeckToShoulder * (float) Math.sin(radians);
			rShoulderY = collarY + distanceNeckToShoulder * (float) Math.cos(radians);
			lShoulderX = collarX + distanceNeckToShoulder * (float) Math.sin(radians);
			lShoulderY = collarY - distanceNeckToShoulder * (float) Math.cos(radians);

			float distanceWaistToHip = 0.5f * Leg.thickness + 1;
			rHipX = waistX - distanceWaistToHip * (float) Math.sin(radians);
			rHipY = waistY + distanceWaistToHip * (float) Math.cos(radians);
			lHipX = waistX + distanceWaistToHip * (float) Math.sin(radians);
			lHipY = waistY - distanceWaistToHip * (float) Math.cos(radians);
		}
	}

}
