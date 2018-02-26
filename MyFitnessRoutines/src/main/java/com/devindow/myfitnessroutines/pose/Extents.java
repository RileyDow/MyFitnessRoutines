package com.devindow.myfitnessroutines.pose;

/**
 * Created by Devin on 2/22/2018.
 */

public class Extents {

	// Public Fields
	float left;
	float top;
	float right;
	float bottom;


	// Public Properties
	public float getWidth() {
		return right - left;
	}

	public float getHeight() {
		return top - bottom;
	}

	public float getCenterX() {
		return (right + left) / 2;
	}

	public float getCenterY() {
		return (top + bottom) / 2;
	}


	// Constructor
	public Extents(float left, float top, float right, float bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}


	// Methods
	public void union(Extents extents) {
		left = Math.min(left, extents.left);
		top = Math.max(top, extents.top);
		right = Math.max(right, extents.right);
		bottom = Math.min(bottom, extents.bottom);
	}


	// Overrides
	@Override
	public String toString() {
		return "L=" + left + " T=" + top + " R=" + right + " B=" + bottom;
	}
}
