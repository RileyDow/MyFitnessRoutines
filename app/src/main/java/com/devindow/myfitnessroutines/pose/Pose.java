package com.devindow.myfitnessroutines.pose;

import android.graphics.Canvas;

import junit.framework.Assert;

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

	public boolean centerExtents = true;


	// Public Properties
	public Extents getExtents() {
		Assert.assertNotNull(torso);

		Extents extents = torso.getExtents();

		if (lArm != null) {
			extents.union(lArm.getExtents(torso.lShoulderX, torso.lShoulderY));
		}

		if (rArm != null) {
			extents.union(rArm.getExtents(torso.rShoulderX, torso.rShoulderY));
		}

		if (lLeg != null) {
			extents.union(lLeg.getExtents(torso.lHipX, torso.lHipY));
		}

		if (rLeg != null) {
			extents.union(rLeg.getExtents(torso.rHipX, torso.rHipY));
		}

		return extents;
	}


	// Public Methods
	public void draw(Canvas canvas) {
		canvas.save();
		if (centerExtents) {
			Extents extents = getExtents();
			canvas.translate(-extents.getCenterX(), 0);
		}

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

		canvas.restore();
	}

}
