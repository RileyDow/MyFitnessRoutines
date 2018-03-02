package com.devindow.myfitnessroutines.util;

/**
 * Created by Devin on 3/2/2018.
 */

public class Colors {

	// Static Methods
	public static int generate(int r, int g, int b) {
		return generate(0xff, r, g, b);
	}

	public static int generate(float r, float g, float b) {
		return generate(1f, r, g, b);
	}

	public static int generate(float a, float r, float g, float b) {
		return generate(Math.round(a*0xff), Math.round(r*0xff), Math.round(g*0xff), Math.round(b*0xff));
	}

	public static int generate(int a, int r, int g, int b) {
		return (a & 0xff) << 24 | (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff);
	}

}
