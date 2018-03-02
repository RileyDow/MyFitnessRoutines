package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import java.io.Serializable;

/**
 * Created by Devin on 3/2/2018.
 */

public class Step implements Serializable {

	// Public Fields
	public PointF point;
	public boolean leftFoot;
	public boolean rightFoot;


	// Constructors
	public Step(PointF point, boolean leftFoot, boolean rightFoot) {
		this.point = point;
		this.leftFoot = leftFoot;
		this.rightFoot = rightFoot;
	}

	// Public Methods
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);


	}

}
