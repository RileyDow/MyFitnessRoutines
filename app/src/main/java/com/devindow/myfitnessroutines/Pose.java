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

    public double bodyAngle;
    public float collarX;
    public float collarY;

    public float rShoulderX;
    public float rShoulderY;
    public float lShoulderX;
    public float lShoulderY;

    public float rHipX;
    public float rHipY;
    public float lHipX;
    public float lHipY;

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
        generateCoords();

        prepCanvas();

        // Draw Head
        p.setStrokeWidth(headSize);
        canvas.drawPoint(headX, headY, p);

        // Draw Torso
        if (Debug.colors) { p.setColor(Color.MAGENTA); }
        p.setStrokeWidth(torsoThickness);
        canvas.drawLine(collarX, collarY, waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        // Right Arm
        if (Debug.colors) { p.setColor(Color.RED); }
        if (rElbowX != null && rElbowY != null) {
            canvas.drawLine(rShoulderX, rShoulderY, rElbowX, rElbowY, p);
            canvas.drawLine(rElbowX, rElbowY, rHandX, rHandY, p);
        }
        else {
            canvas.drawLine(rShoulderX, rShoulderY, rHandX, rHandY, p);
        }
        // Left Arm
        if (Debug.colors) { p.setColor(Color.YELLOW); }
        if (lElbowX != null && lElbowY != null) {
            canvas.drawLine(lShoulderX, lShoulderY, lElbowX, lElbowY, p);
            canvas.drawLine(lElbowX, lElbowY, lHandX, lHandY, p);
        }
        else {
            canvas.drawLine(lShoulderX, lShoulderY, lHandX, lHandY, p);
        }

        // Draw Legs
        p.setStrokeWidth(legThickness);
        // Right Leg
        if (Debug.colors) { p.setColor(Color.BLUE); }
        if (rKneeX != null && rKneeY != null) {
            canvas.drawLine(rHipX, rHipY, rKneeX, rKneeY, p);
            canvas.drawLine(rKneeX, rKneeY, rFootX, rFootY, p);
        }
        else {
            canvas.drawLine(rHipX, rHipY, rFootX, rFootY, p);
        }
        // Left Leg
        if (Debug.colors) { p.setColor(Color.CYAN); }
        if (lKneeX != null && lKneeY != null) {
            canvas.drawLine(lHipX, lHipY, lKneeX, lKneeY, p);
            canvas.drawLine(lKneeX, lKneeY, lFootX, lFootY, p);
        }
        else {
            canvas.drawLine(lHipX, lHipY, lFootX, lFootY, p);
        }

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

        p = new Paint();
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setColor(Color.BLACK);
    }

    protected void generateCoords() {
        bodyAngle = getBodyAngle();
        collarX = waistX + (int)Math.round(torsoLength * Math.cos(bodyAngle));
        collarY = waistY + (int)Math.round(torsoLength * Math.sin(bodyAngle));

        generateShoulderAndHipCoords();
    }

    protected abstract void generateShoulderAndHipCoords();


    // Overrides
    @Override
    public String toString() {
        return this.name;
    }
}
