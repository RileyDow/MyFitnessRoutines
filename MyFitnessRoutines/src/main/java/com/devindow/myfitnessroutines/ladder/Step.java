package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Devin on 3/2/2018.
 */

public class Step implements Serializable {

	// Public Fields
	public float x;
	public float y;
	public boolean leftFoot;


	// Constructors
	public Step(float x, float y, boolean leftFoot) {
		this.x = x;
		this.y = y;
		this.leftFoot = leftFoot;
	}

	// Public Methods
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);


	}

}
