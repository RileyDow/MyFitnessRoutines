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


    // Public Fields
    public String name;
    public Category category;
    public boolean twoSides;

    Torso torso;
    Arm rArm;
    Arm lArm;
    Leg rLeg;
    Leg lLeg;
    public Prop prop;


    // Protected Fields
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected Paint p;


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
        prepCanvas();

        torso.draw(canvas);
        lArm.draw(canvas, torso.lShoulderX, torso.lShoulderY);
        rArm.draw(canvas, torso.rShoulderX, torso.rShoulderY);
        lLeg.draw(canvas, torso.lHipX, torso.lHipY);
        rLeg.draw(canvas, torso.rHipX, torso.rHipY);

        if (prop != null) {
            prop.draw(canvas);
        }

        return bitmap;
    }


    // Protected Methods
    protected void prepCanvas() {
        bitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.translate(bitmapSize/2, bitmapSize-1); // Origin a floor center
        canvas.scale(10, -10); // up is positive Y, 10x scale
    }


    // Overrides
    @Override
    public String toString() {
        return this.name;
    }
}
