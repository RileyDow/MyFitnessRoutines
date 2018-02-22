package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;

import java.io.Serializable;

/**
 * Created by Devin on 2/22/2018.
 */

public abstract class Appendage implements Serializable {

	// Public Fields
	public Angle proximalAngle;
	public Float proximalLength;

	public Angle distalAngle;
	public Float distalLength;


	// Public Properties
	public abstract float getThickness();
	public abstract float getSegmentLength();

	public float getProximalLength() {
		if (proximalLength != null) {
			return proximalLength;
		}
		return getSegmentLength();
	}

	public float getDistalLength() {
		if (distalLength != null) {
			return distalLength;
		}
		return getSegmentLength();
	}

	public float getHeight() {
		return  Math.abs(getProximalLength() * proximalAngle.getSin() + getDistalLength() * distalAngle.getSin());
	}

	public float getWidth() {
		return  Math.abs(getProximalLength() * proximalAngle.getCos() + getDistalLength() * distalAngle.getCos());
	}

	public float getProximalPointX(float attachmentX) {
		return attachmentX + Math.round(getProximalLength() * proximalAngle.getCos());
	}

	public float getProximalPointY(float attachmentY) {
		return attachmentY + Math.round(getProximalLength() * proximalAngle.getSin());
	}

	public float getDistalPointX(float attachmentX) {
		return getProximalPointX(attachmentX) + Math.round(getDistalLength() * distalAngle.getCos());
	}

	public float getDistalPointY(float attachmentY) {
		return getProximalPointY(attachmentY) + Math.round(getDistalLength() * distalAngle.getSin());
	}


	// Constructors
	public Appendage(Angle angle) {
		this(angle, null, angle, null);
	}

	public Appendage(Angle angle, Float length) {
		this(angle, length/2, angle, length/2);
	}

	public Appendage(Angle proximalAngle, Angle distalAngle) {
		this(proximalAngle, null, distalAngle, null);
	}

	public Appendage(Angle proximalAngle, Float proximalLength, Angle distalAngle) {
		this(proximalAngle, proximalLength, distalAngle, null);
	}

	public Appendage(Angle proximalAngle, Angle distalAngle, Float distalLength) {
		this(proximalAngle, null, distalAngle, distalLength);
	}

	public Appendage(Angle proximalAngle, Float proximalLength, Angle distalAngle, Float distalLength) {
		this.proximalAngle = proximalAngle;
		this.proximalLength = proximalLength;

		this.distalAngle = distalAngle;
		this.distalLength = distalLength;
	}


	// Public Methods
	public void draw(Canvas canvas, float attachmentPointX, float attachmentPointY) {
		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeWidth(getThickness());
		Debug.setPenColor(paint);

		float proximalPointX = getProximalPointX(attachmentPointX);
		float proximalPointY = getProximalPointY(attachmentPointY);
		canvas.drawLine(attachmentPointX, attachmentPointY, proximalPointX, proximalPointY, paint);

		float distalPointX = getDistalPointX(attachmentPointX);
		float distalPointY = getDistalPointY(attachmentPointY);
		canvas.drawLine(proximalPointX, proximalPointY, distalPointX, distalPointY, paint);
	}

}
