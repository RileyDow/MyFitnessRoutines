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
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}


	// Overrides
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
