package com.devindow.myfitnessroutines.routine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.devindow.myfitnessroutines.pose.Pose;

import java.io.Serializable;

/**
 * Created by Devin on 2/17/2018.
 */

public abstract class Move implements Serializable {

	// Public Fields
	public String name;
	public String description;
	public Category category;
	public boolean twoSides;


	// Protected Fields
	protected Bitmap bitmap;


	// Constructors
	public Move(String name) {
		this(name, false);
	}

	public Move(String name, boolean twoSides) {
		this(name, Category.NONE, twoSides);
	}

	public Move(String name, Category category) {
		this(name, category, false);
	}

	public Move(String name, String description) {
		this(name, description, false);
	}

	public Move(String name, String description, Category category) {
		this(name, description, category, false);
	}

	public Move(String name, Category category, boolean twoSides) {
		this(name, "", category, twoSides);
	}

	public Move(String name, String description, boolean twoSides) {
		this(name, description, Category.NONE, twoSides);
	}

	public Move(String name, String description, Category category, boolean twoSides) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.twoSides = twoSides;
	}


	// Public Methods
	public abstract Bitmap getBitmap(boolean secondSide);


	// Protected Methods
	protected void drawFrame(Canvas canvas, int size) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(20);
		canvas.drawRect(0, 0, size, size, paint);
	}


	// Overrides
	@Override
	public String toString() {
		return this.name;
	}
}
