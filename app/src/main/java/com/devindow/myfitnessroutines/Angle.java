package com.devindow.myfitnessroutines;

/**
 * Created by Devin on 2/16/2018.
 */

public class Angle {

	// Public Fields
	public double radians;


	// Public Properties
	public int getDegrees() { return (int)Math.round(Math.toDegrees(radians)); }
	public float getSin() { return (float)Math.sin(radians); }
	public float getCos() { return (float)Math.cos(radians); }


	// Constructors
	public Angle(double radians) {
		this.radians = radians;
	}

	public Angle(int degrees) {
		radians = Math.toRadians(degrees);
	}

	public Angle(float dy, float dx) {
		if (dy == 0 && dx == 0) {
			throw new IllegalArgumentException("Angle cannot be determined from (0,0).");
		}

		radians = Math.atan2(dy, dx);
	}


	// Public Methods
	public Angle mirror() {
		return new Angle(Math.PI - radians);
	}

	public Angle opposite() {
		return new Angle(radians + Math.PI);
	}


	// Overrides


	@Override
	public String toString() {
		return getDegrees() + "º";
	}
}
