package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.devindow.myfitnessroutines.Debug;

import java.io.Serializable;

/**
 * Created by Devin on 2/22/2018.
 */

public abstract class Appendage implements Serializable {

	// Public Fields
	public Angle proximalAngle;
	public float proximalLengthRatio = 1f;

	public Angle distalAngle;
	public float distalLengthRatio = 1f;


	// Public Properties
	public abstract float getThickness();
	public abstract float getSegmentLength();

	// Public Properties
	public Extents getExtents(float attachmentPointX, float attachmentPointY) {
		float proximalPointX = getProximalPointX(attachmentPointX);
		float proximalPointY = getProximalPointY(attachmentPointY);

		float distalPointX = getDistalPointX(attachmentPointX);
		float distalPointY = getDistalPointY(attachmentPointY);

		float radius = getThickness()/2;

		return new Extents(
				Math.min(attachmentPointX, Math.min(proximalPointX, distalPointX )) - radius,
				Math.max(attachmentPointY, Math.max(proximalPointY, distalPointY)) + radius,
				Math.max(attachmentPointX, Math.max(proximalPointX, distalPointX )) + radius,
				Math.min(attachmentPointY, Math.min(proximalPointY, distalPointY)) - radius);
	}


	public float getHeight() {
		return  Math.abs(proximalLengthRatio * getSegmentLength() * proximalAngle.getSin() + distalLengthRatio * getSegmentLength() * distalAngle.getSin());
	}

	public float getWidth() {
		return  Math.abs(proximalLengthRatio * getSegmentLength() * proximalAngle.getCos() + distalLengthRatio * getSegmentLength() * distalAngle.getCos());
	}

	public float getProximalPointX(float attachmentX) {
		return attachmentX + Math.round(proximalLengthRatio * getSegmentLength() * proximalAngle.getCos());
	}

	public float getProximalPointY(float attachmentY) {
		return attachmentY + Math.round(proximalLengthRatio * getSegmentLength() * proximalAngle.getSin());
	}

	public float getDistalPointX(float attachmentX) {
		return getProximalPointX(attachmentX) + Math.round(distalLengthRatio * getSegmentLength() * distalAngle.getCos());
	}

	public float getDistalPointY(float attachmentY) {
		return getProximalPointY(attachmentY) + Math.round(distalLengthRatio * getSegmentLength() * distalAngle.getSin());
	}


	// Constructors
	public Appendage() {
		this(Angle.S);
	}

	public Appendage(Angle angle) {
		this(angle, 1f, angle, 1f);
	}

	public Appendage(Angle angle, float lengthRatio) {
		this(angle, lengthRatio, angle, lengthRatio);
	}

	public Appendage(Angle proximalAngle, Angle distalAngle) {
		this(proximalAngle, 1f, distalAngle, 1f);
	}

	public Appendage(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle) {
		this(proximalAngle, proximalLengthRatio, distalAngle, 1f);
	}

	public Appendage(Angle proximalAngle, Angle distalAngle, float distalLengthRatio) {
		this(proximalAngle, 1f, distalAngle, distalLengthRatio);
	}

	public Appendage(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle, float distalLengthRatio) {
		this.proximalAngle = proximalAngle;
		this.proximalLengthRatio = proximalLengthRatio;

		this.distalAngle = distalAngle;
		this.distalLengthRatio = distalLengthRatio;
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

		Debug.setPenColor(paint);
		float distalPointX = getDistalPointX(attachmentPointX);
		float distalPointY = getDistalPointY(attachmentPointY);
		canvas.drawLine(proximalPointX, proximalPointY, distalPointX, distalPointY, paint);
	}

}
