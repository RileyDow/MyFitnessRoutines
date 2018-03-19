package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.devindow.myfitnessroutines.util.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Devin on 2/16/2018.
 */

public class Torso implements Serializable {

	// Constants
	public static final float headSize = 10;
	public static final float thickness = 10;
	public static final float length = 20;
	public static final float lengthWithHead = length + headSize;
	public static final float distanceNeckToShoulder = thickness/2 + Arm.thickness/2;
	public static final float distanceWaistToHip = Leg.thickness/2 - 1;


	// Public Fields
	public Point waist;
	public float lengthRatio;
	public ArrayList<Point> points;

	public Point head;

	public Point collar;

	public Point rShoulder;
	public Point lShoulder;

	public Point rHip;
	public Point lHip;

	public boolean mat = false;


	// Public Properties
	public Extents getExtents() {
		return new Extents(
				Math.min(waist.x - thickness/2, head.x - headSize/2),
				Math.max(waist.y + thickness/2, head.y + headSize/2),
				Math.max(waist.x + thickness/2, head.x + headSize/2),
				Math.min(waist.y - thickness/2, head.y - headSize/2));
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

	public Torso(float waistY, float lengthRatio) {
		this(waistY, lengthRatio,false);
	}

	public Torso(float waistY, Angle angle) {
		this(waistY, angle, false);
	}

	public Torso(float waistY, float lengthRatio, Angle angle) {
		this(waistY, lengthRatio, angle, false);
	}

	public Torso(boolean isProfile) {
		this(isProfile, isProfile);
	}

	public Torso(boolean isShoulderProfile, boolean isHipsProfile) {
		this(Angle.N, isShoulderProfile, isHipsProfile);
	}

	public Torso(Angle angle, boolean isProfile) {
		this(angle, isProfile, isProfile);
	}

	public Torso(Angle angle, boolean isShoulderProfile, boolean isHipsProfile) {
		this(Leg.segmentLength*2 + Leg.thickness/2, angle, isShoulderProfile, isHipsProfile);
	}

	public Torso(float waistY, boolean isProfile) {
		this(waistY, isProfile, isProfile);
	}

	public Torso(float waistY, boolean isShoulderProfile, boolean isHipsProfile) {
		this(waistY, Angle.N, isShoulderProfile, isHipsProfile);
	}

	public Torso(float waistY, float lengthRatio, boolean isProfile) {
		this(waistY, lengthRatio, isProfile, isProfile);
	}

	public Torso(float waistY, float lengthRatio, boolean isShoulderProfile, boolean isHipsProfile) {
		this(waistY, lengthRatio, Angle.N, isShoulderProfile, isHipsProfile);
	}

	public Torso(float waistY, Angle angle, boolean isProfile) {
		this(waistY, angle, isProfile, isProfile);
	}

	public Torso(float waistY, Angle angle, boolean isShoulderProfile, boolean isHipsProfile) {
		this(waistY, 1.0f, angle, isShoulderProfile, isHipsProfile);
	}

	public Torso(float waistY, float lengthRatio, Angle angle, boolean isProfile) {
		this(waistY, lengthRatio, angle, isProfile, isProfile);
	}

	public Torso(float waistY, float lengthRatio, Angle angle, boolean isShoulderProfile, boolean isHipsProfile) {

		// Waist
		waist = new Point(0, waistY);
		this.lengthRatio = lengthRatio;

		// Collar
		collar = new Point(Math.round(length * lengthRatio * angle.getCos()), waistY + Math.round(length * lengthRatio * angle.getSin()));

		// Head
		float waistToHead = length * lengthRatio + thickness/2 + headSize/2;
		head = new Point(Math.round(waistToHead * angle.getCos()), waistY + Math.round(waistToHead * angle.getSin()));

		// Shoulders
		if (isShoulderProfile) {
			rShoulder = collar.clone();
			lShoulder = collar.clone();
		} else {
			rShoulder = collar.offset(-distanceNeckToShoulder * angle.getSin(), distanceNeckToShoulder * angle.getCos());
			lShoulder = collar.offset(distanceNeckToShoulder * angle.getSin(), -distanceNeckToShoulder * angle.getCos());
		}

		// Hips
		if (isHipsProfile) {
			rHip = waist.clone();
			lHip = waist.clone();
		} else {
			rHip = waist.offset(-distanceWaistToHip * angle.getSin(), distanceWaistToHip * angle.getCos());
			lHip = waist.offset(distanceWaistToHip * angle.getSin(), -distanceWaistToHip * angle.getCos());
		}
	}


	// Public Methods
	public void draw(Canvas canvas) {
		if (mat) {
			drawMat(canvas);
		}

		Paint paint = new Paint();
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);

		// Draw Head
		Colors.setBodyColor(paint);
		paint.setStrokeWidth(headSize);
		canvas.drawPoint(head.x, head.y, paint);

		// Draw Torso
		Colors.setBodyColor(paint);
		paint.setStrokeWidth(thickness);
		Point prevPoint = waist;
		if (points != null) {
			for (Point point : points) {
				canvas.drawLine(prevPoint.x, prevPoint.y, point.x, point.y, paint);
				prevPoint = point;
				Colors.setBodyColor(paint);
			}
		}
		canvas.drawLine(prevPoint.x, prevPoint.y, collar.x, collar.y, paint);
	}


	// Private Methods
	private void drawMat(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.CYAN);

		float width = 36;
		float height = 80;
		RectF mat = new RectF(waist.x - width/2, waist.y + height/2, waist.x + width/2, waist.y - height/2);
		canvas.drawRect(mat, paint);
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
