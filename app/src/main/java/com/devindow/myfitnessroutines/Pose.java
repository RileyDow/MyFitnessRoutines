package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by Devin on 1/27/2018.
 */

public abstract class Pose implements Serializable {

    // Public Fields
    public String Name;
    public Category Category;
    public boolean TwoSides;

    public int headX = 0;
    public int headY = 60;

    public int waistX = 0;
    public int waistY = 34;

    public int rHandX = 25;
    public int rHandY = 60;
    public int lHandX = -25;
    public int lHandY = 60;

    public int rFootX = 4;
    public int rFootY = 0;
    public int lFootX = -4;
    public int lFootY = 0;

    public Integer rKneeX, rKneeY, lKneeX, lKneeY;
    public Integer rElbowX, rElbowY, lElbowX, lElbowY;


    // Private Properties
    protected int getNeckX() { return waistX + (int)Math.round(0.7*(headX-waistX)); } // TODO
    protected int getNeckY() { return waistY + (int)Math.round(0.7*(headY-waistY)); } // TODO


    // Protected Constants
    protected static final int headSize = 10;
    protected static final int torsoThickness = 10;
    protected static final int armThickness = 4;
    protected static final int legThickness = 6;


    // Constructors
    public Pose(String name, Category category) {
        this.Name = name;
        this.Category = category;
        this.TwoSides = false;
    }

    public Pose(String name, Category category, boolean twoSides) {
        this.Name = name;
        this.Category = category;
        this.TwoSides = twoSides;
    }


    // Public Abstract Methods
    public abstract Bitmap getBitmap(int w, int h);


    // Overrides
    @Override
    public String toString() {
        return this.Name;
    }
}
