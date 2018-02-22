package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.Debug;

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
	public Leg(Angle angle) {
		super(angle);
	}

	public Leg(Angle angle, Float length) {
		super(angle, length);
	}

	public Leg(Angle proximalAngle, Angle distalAngle) {
		super(proximalAngle, distalAngle);
	}

	public Leg(Angle proximalAngle, Float proximalLength, Angle distalAngle) {
		super(proximalAngle, proximalLength, distalAngle);
	}

	public Leg(Angle proximalAngle, Angle distalAngle, Float distalLength) {
		super(proximalAngle, distalAngle, distalLength);
	}

	public Leg(Angle proximalAngle, Float proximalLength, Angle distalAngle, Float distalLength) {
		super(proximalAngle, proximalLength, distalAngle, distalLength);
	}

}
