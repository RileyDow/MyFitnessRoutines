package com.devindow.myfitnessroutines.ladder;

/**
 * Created by Devin on 3/2/2018.
 */

public enum Feet {
	NONE(0),
	LEFT(1<<0),
	RIGHT(1<<1),
	BOTH(LEFT.flag | RIGHT.flag);


	// Private Fields
	private final int flag;


	// Constructor
	Feet(int flag) {
		this.flag = flag;
	}


	// Public Properties
	public boolean hasLeft() {
		return (flag & LEFT.flag) != 0;
	}

	public boolean hasRight() {
		return (flag & RIGHT.flag) != 0;
	}

	public boolean hasBoth() {
		return hasLeft() && hasRight();
	}
}
