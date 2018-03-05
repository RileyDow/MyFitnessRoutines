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
	public Point offset(float x, float y) {
		return new Point(this.x + x, this.y + y);
	}

	public Point offset(float distance, Point towards) { // Offsets by a distance towards another Point
		return null;
	}

	public Point mirror() {
		return new Point(-this.x, this.y);
	}


	// Overrides
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
