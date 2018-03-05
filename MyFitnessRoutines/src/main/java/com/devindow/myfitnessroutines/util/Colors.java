package com.devindow.myfitnessroutines.util;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Devin on 3/2/2018.
 */

public class Colors {

	// Constants
	public static final boolean random = false; // Set to true to help debug Pose bitmap issues using unique colors for body parts.

	public static final int bodyOpaque = Colors.generate(0,0, 0);
	public static final int bodyTrans = Colors.generate(.8f, 0,0, 0);

	public static final int leftOpaque = Colors.generate(0,1, 0);
	public static final int leftTrans = Colors.generate(.5f, 0,1, 0);

	public static final int rightOpaque = Colors.generate(1,0, 0);
	public static final int rightTrans = Colors.generate(.5f, 1,0, 0);


	// Static Methods
	public static void setBodyColor(Paint paint) {
		setBodyColor(paint, false);
	}

	public static void setBodyColor(Paint paint, boolean translucent) {
		if (random) {
			paint.setColor(Colors.random());
		} else if (translucent) {
			paint.setColor(Colors.bodyTrans);
		} else {
			paint.setColor(Colors.bodyOpaque);
		}
	}


	public static void setFootColor(Paint paint, Feet feet) {
		setFootColor(paint, feet, false);
	}

	public static void setFootColor(Paint paint, Feet feet, boolean translucent) {
		setFootColor(paint, feet, translucent, false);
	}

	public static void setFootColor(Paint paint, Feet feet, boolean translucent, boolean mirror) {
		if (feet.hasBoth()) { 						// Body color
			if (translucent) {
				paint.setColor(bodyTrans);
			} else {
				paint.setColor(bodyOpaque);
			}
		} else if (feet.hasLeft() ^ mirror) {		// Left color
			if (translucent) {
				paint.setColor(leftTrans);
			} else {
				paint.setColor(leftOpaque);
			}
		} else {									// Right color
			if (translucent) {
				paint.setColor(rightTrans);
			} else {
				paint.setColor(rightOpaque);
			}
		}
	}


	public static int generate(int r, int g, int b) {
		if (r <= 1 && g <=1 && b <=1) { // if all params are 1 or 0 then use the float version.
			return generate(1f, 1f*r, 1f*g, 1f*b);
		}

		return generate(0xff, r, g, b);
	}

	public static int generate(float r, float g, float b) {
		return generate(1f, r, g, b);
	}

	public static int generate(float a, float r, float g, float b) {
		return generate(Math.round(a*0xff), Math.round(r*0xff), Math.round(g*0xff), Math.round(b*0xff));
	}

	public static int generate(int a, int r, int g, int b) {
		if (a <=1 && r <= 1 && g <=1 && b <=1) { // if all params are 1 or 0 then use the float version.
			return generate(1f*a, 1f*r, 1f*g, 1f*b);
		}

		return (a & 0xff) << 24 | (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff);
	}


	public static int random() {
		Random random = new Random();
		final float hue = random.nextInt(360); // 0..360
		final float saturation = 1.0f; // 1.0 for brilliant, 0.0 for dull
		final float luminance = 1.0f; // 1.0 for brighter, 0.0 for black
		return Color.HSVToColor(new float[]{hue, saturation, luminance});
	}

}
