package com.devindow.myfitnessroutines.pose;

import com.devindow.myfitnessroutines.util.Angle;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Leg extends Appendage implements Serializable {

	// Constants
	public static final float thickness = 6;
	public static final float segmentLength = 17;


	// Public Properties
	public float getThickness() {
		return thickness;
	}
	public float getSegmentLength() {
		return segmentLength;
	}


	// Constructors
	public Leg() {
		super();
	}

	public Leg(Angle angle) {
		super(angle);
	}

	public Leg(Angle angle, Float lengthRatio) {
		super(angle, lengthRatio);
	}

	public Leg(Angle proximalAngle, Angle distalAngle) {
		super(proximalAngle, distalAngle);
	}

	public Leg(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle) {
		super(proximalAngle, proximalLengthRatio, distalAngle);
	}

	public Leg(Angle proximalAngle, Angle distalAngle, float distalLengthRatio) {
		super(proximalAngle, distalAngle, distalLengthRatio);
	}

	public Leg(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle, float distalLengthRatio) {
		super(proximalAngle, proximalLengthRatio, distalAngle, distalLengthRatio);
	}

}
