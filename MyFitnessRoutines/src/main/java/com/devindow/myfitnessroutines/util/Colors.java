package com.devindow.myfitnessroutines.util;

/**
 * Created by Devin on 3/2/2018.
 */

public class Colors {

	// Static Methods
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

}
