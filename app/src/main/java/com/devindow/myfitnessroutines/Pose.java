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
    public final float headSize = 10;
    public final float torsoThickness = 10;
    public final float torsoLength = 20;
    public final float armThickness = 4;
    public final float armSegmentLength = 12;
    public final float legThickness = 6;
    public final float legSegmentLength = 17;


    // Public Fields
    public String name;
    public Category category;
    public boolean twoSides;

    public float headX = 0;
    public float headY = 66;

    public boolean coordsGenerated = false;
    public double bodyAngle;
    public Float collarX; // Nullable so it will throw if generateCoords() has not been called.
    public Float collarY;

    public float waistX = 0;
    public float waistY = headY - headSize/2 - torsoThickness/2 - torsoLength; // head center - head radius - torso radius - torso length

    public float rHandX = 25;
    public float rHandY = 60;
    public float lHandX = -25;
    public float lHandY = 60;

    public float rFootX = 4;
    public float rFootY = legThickness/2;
    public float lFootX = -4;
    public float lFootY = legThickness/2;

    public Float rKneeX, rKneeY, lKneeX, lKneeY;
    public Float rElbowX, rElbowY, lElbowX, lElbowY;

    public Prop prop;


    // Protected Fields
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected Paint p;



    // Protected Properties
    protected double getBodyAngle() { return Math.atan2(headY - waistY, headX - waistX); }


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


    // Public Methods
    public Bitmap getBitmap() {
        if (!coordsGenerated) {
            generateCoords();
        }

        prepCanvas();

        return bitmap;
    }


    // Protected Methods
    protected void generateCoords() {
        bodyAngle = getBodyAngle();
        collarX = waistX + (int)Math.round(torsoLength * Math.cos(bodyAngle));
        collarY = waistY + (int)Math.round(torsoLength * Math.sin(bodyAngle));

        coordsGenerated = true;
    }

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
