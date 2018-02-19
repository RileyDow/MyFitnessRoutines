package com.devindow.myfitnessroutines;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Devin on 2/12/2018.
 */

public final class Debug {

	// Public Static Constants
	public static final boolean on = true; // Set to false to allow compiler to identify and eliminate unreachable code.

	public static final boolean colors = false; // Set to true to help debug Pose bitmap issues using unique colors for body parts.

	public static final String TAG_ENTER = " ** ENTER ** ";
	public static final String TAG_EXIT = " -- EXIT  -- ";
	public static final String TAG_TIME = " ## TIME ## ";


	// Public Static Methods
	public static void setPenColor(Paint p) {
		if (colors) {
			Random random = new Random();
			final float hue = random.nextInt(360); // 0..360
			final float saturation = 1.0f; // 1.0 for brilliant, 0.0 for dull
			final float luminance = 1.0f; // 1.0 for brighter, 0.0 for black
			p.setColor(Color.HSVToColor( new float[]{ hue, saturation, luminance }));
		} else {
			p.setColor(Color.BLACK);
		}
	}

}
