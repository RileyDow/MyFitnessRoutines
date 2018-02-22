package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;

import java.io.Serializable;

/**
 * Created by Devin on 1/27/2018.
 */

public class Pose implements Serializable {

	// Public Fields
	public Torso torso;
	public Arm rArm;
	public Arm lArm;
	public Leg rLeg;
	public Leg lLeg;
	public Prop prop;


	// Public Methods
	public void draw(Canvas canvas) {
		if (torso != null) {
			torso.draw(canvas);
		}

		if (lArm != null) {
			lArm.draw(canvas, torso.lShoulderX, torso.lShoulderY);
		}
		if (rArm != null) {
			rArm.draw(canvas, torso.rShoulderX, torso.rShoulderY);
		}

		if (lLeg != null) {
			lLeg.draw(canvas, torso.lHipX, torso.lHipY);
		}
		if (rLeg != null) {
			rLeg.draw(canvas, torso.rHipX, torso.rHipY);
		}

		if (prop != null) {
			prop.draw(canvas);
		}
	}

}
