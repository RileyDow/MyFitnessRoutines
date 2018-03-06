package com.devindow.myfitnessroutines.ladder;

import android.graphics.Canvas;

import com.devindow.myfitnessroutines.util.*;

import java.io.Serializable;

/**
 * Created by Devin on 3/2/2018.
 */

public abstract class LadderStep implements Serializable {

	// Constants
	public static final float radius = 3;


	// Abstract Methods
	public abstract void draw(Canvas canvas, int stepNum);

	public abstract boolean hasLeft();
	public abstract boolean hasRight();
	public abstract boolean hasBoth();

	public abstract Point getLeft();
	public abstract Point getRight();
}
