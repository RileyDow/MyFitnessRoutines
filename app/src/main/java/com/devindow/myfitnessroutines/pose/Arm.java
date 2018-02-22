package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;

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
	public Arm(Angle angle) {
		super(angle);
	}

	public Arm(Angle angle, Float length) {
		super(angle, length);
	}

	public Arm(Angle proximalAngle, Angle distalAngle) {
		super(proximalAngle, distalAngle);
	}

	public Arm(Angle proximalAngle, Float proximalLength, Angle distalAngle) {
		super(proximalAngle, proximalLength, distalAngle);
	}

	public Arm(Angle proximalAngle, Angle distalAngle, Float distalLength) {
		super(proximalAngle, distalAngle, distalLength);
	}

	public Arm(Angle proximalAngle, Float proximalLength, Angle distalAngle, Float distalLength) {
		super(proximalAngle, proximalLength, distalAngle, distalLength);
	}

}
