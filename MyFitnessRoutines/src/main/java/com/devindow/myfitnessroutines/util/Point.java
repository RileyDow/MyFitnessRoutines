package com.devindow.myfitnessroutines.util;

import java.io.Serializable;

/**
 * Created by Devin on 2/22/2018.
 */

public class Point implements Serializable {

	// Public Fields
	public float x;
	public float y;


	// Constructor
	public Point() {}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
	}


	// Public Methods
	public void shift(float dx, float dy) {
		x += dx;
		y += dy;
	}

	public Point clone() {
		return new Point(x, y);
	}

	public Point offset(float x, float y) {
		return new Point(this.x + x, this.y + y);
	}

	public Point offset(float distance, Point towards) { // Offsets by a distance towards another Point
		Angle angle = new Angle(this, towards);
		return new Point(x - distance * (float)angle.cos(), y - distance * (float)angle.sin());
	}

	public Point mirror() {
		return new Point(-this.x, this.y);
	}


	// Overrides
	@Override
	public String toString() {
		return "( " + x + " , " + y + " )";
	}


	// Static Methods
	public static Point getMiddle(Point p1, Point p2) {
		return new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
	}

	public static float getDistance(Point p1, Point p2) {
		return (float)Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)); // A^2 + B^2 = C^2
	}

	public static float getAngle(Point p1, Point p2) {
		return (float)Math.atan2(p2.y - p1.y, p2.x - p1.x);
	}

}
