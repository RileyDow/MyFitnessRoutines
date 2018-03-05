package com.devindow.myfitnessroutines.pose;

import com.devindow.myfitnessroutines.util.Angle;

import java.io.Serializable;

/**
 * Created by Devin on 2/16/2018.
 */

public class Arm extends Appendage implements Serializable {

	// Constants
	public static final float thickness = 4;
	public static final float segmentLength = 12;


	// Public Properties
	public float getThickness() {
		return thickness;
	}
	public float getSegmentLength() {
		return segmentLength;
	}


	// Constructors
	public Arm() {
		super();
	}

	public Arm(Angle angle) {
		super(angle);
	}

	public Arm(Angle angle, float lengthRatio) {
		super(angle, lengthRatio);
	}

	public Arm(Angle proximalAngle, Angle distalAngle) {
		super(proximalAngle, distalAngle);
	}

	public Arm(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle) {
		super(proximalAngle, proximalLengthRatio, distalAngle);
	}

	public Arm(Angle proximalAngle, Angle distalAngle, float distalLengthRatio) {
		super(proximalAngle, distalAngle, distalLengthRatio);
	}

	public Arm(Angle proximalAngle, float proximalLengthRatio, Angle distalAngle, float distalLengthRatio) {
		super(proximalAngle, proximalLengthRatio, distalAngle, distalLengthRatio);
	}

}
