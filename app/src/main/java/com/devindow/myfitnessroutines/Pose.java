package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Devin on 1/27/2018.
 */

public abstract class Pose implements Serializable {

    // Constants
    protected final int bitmapSize = 900;
    public final int headSize = 10;
    public final int torsoThickness = 10;
    public final int torsoLength = 20;
    public final int armThickness = 4;
    public final int armSegmentLength = 12;
    public final int legThickness = 6;
    public final int legSegmentLength = 17;


    // Public Fields
    public String name;
    public Category category;
    public boolean twoSides;

    public int headX = 0;
    public int headY = 66;

    public int waistX = 0;
    public int waistY = headY - headSize/2 - torsoThickness/2 - torsoLength; // head center - head radius - torso radius - torso length

    public int rHandX = 25;
    public int rHandY = 60;
    public int lHandX = -25;
    public int lHandY = 60;

    public int rFootX = 4;
    public int rFootY = legThickness/2;
    public int lFootX = -4;
    public int lFootY = legThickness/2;

    public Integer rKneeX, rKneeY, lKneeX, lKneeY;
    public Integer rElbowX, rElbowY, lElbowX, lElbowY;


    // Protected Fields
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected Paint p;



    // Protected Properties
    protected double getBodyAngle() { return Math.atan2(headY - waistY, headX - waistX); }
    protected int getNeckX() { return waistX + (int)Math.round(torsoLength * Math.cos(getBodyAngle())); }
    protected int getNeckY() { return waistY + (int)Math.round(torsoLength * Math.sin(getBodyAngle())); }


    // Constructors
    public Pose(String name, Category category) {
        this.name = name;
        this.category = category;
        this.twoSides = false;
    }

    public Pose(String name, Category category, boolean twoSides) {
        this.name = name;
        this.category = category;
        this.twoSides = twoSides;
    }


    // Public Abstract Methods
    public abstract Bitmap getBitmap();


    // Protected Methods
    protected void prepCanvas() {
        bitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.translate(bitmapSize/2, bitmapSize-1); // Origin a floor center
        canvas.scale(10, -10); // up is positive Y, 10x scale

        p = new Paint();
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setColor(Color.BLACK);
    }


    // Overrides
    @Override
    public String toString() {
        return this.name;
    }
}
