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
    public int headY = 66;

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


    // Protected Fields
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected Paint p;



    // Private Properties
    protected int getNeckX() { return waistX + (int)Math.round(0.7*(headX-waistX)); } // TODO
    protected int getNeckY() { return waistY + (int)Math.round(0.7*(headY-waistY)); } // TODO


    // Constants
    protected static final int bitmapSize = 900;
    public static final int headSize = 10;
    public static final int torsoThickness = 10;
    public static final int armThickness = 4;
    public static final int legThickness = 6;


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
        return this.Name;
    }
}
