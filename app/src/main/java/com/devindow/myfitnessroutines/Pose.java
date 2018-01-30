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

public class Pose implements Serializable {

    // Public Fields
    public String Name;
    public Category Category;
    public boolean TwoSides;

    public boolean IsProfile = false;


    // Private Fields
    private int headX = 0;
    private int headY = 60;

    private int waistX = 0;
    private int waistY = 34;

    private int rHandX = 25;
    private int rHandY = 60;
    private int lHandX = -25;
    private int lHandY = 60;

    private int rFootX = 4;
    private int rFootY = 0;
    private int lFootX = -4;
    private int lFootY = 0;


    // Public Properties
    public void setHeadX(int headX) { this.headX = headX; }
    public void setHeadY(int headY) { this.headY = headY; }


    // Private Properties
    private int getNeckX() { return headX; } // TODO
    private int getNeckY() { return headY-8; } // TODO


    // Private Constants
    private static final int headSize = 10;
    private static final int torsoWidth = 16;
    private static final int torsoThickness = 10;
    private static final int armThickness = 4;
    private static final int legThickness = 6;


    // Public Properties
    public Bitmap getBitmap(int w, int h) {
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.translate(w/2, h-1); // Origin a floor center
        canvas.scale(10, -10); // up is positive Y, 10x scale

        Paint p = new Paint();
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setColor(Color.BLACK);

        // Draw Floor
        p.setStrokeWidth(1);
        canvas.drawLine(-w/2, 0,w/2,0, p);

        // Draw Head
        p.setStrokeWidth(headSize);
        canvas.drawPoint(headX, headY, p);

        // Draw Torso
        if (IsProfile)
            p.setStrokeWidth(torsoWidth);
        else
            p.setStrokeWidth(torsoThickness);
        canvas.drawLine(getNeckX(), getNeckY(), waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        if (IsProfile) {

        }
        else {
            int rShoulderX = getNeckX() + torsoThickness/2;
            canvas.drawLine(rShoulderX, getNeckY(), rHandX, rHandY, p);
            int lShoulderX = getNeckX() - torsoThickness/2;
            canvas.drawLine(lShoulderX, getNeckY(), lHandX, lHandY, p);
        }

        // Draw Legs
        p.setStrokeWidth(legThickness);
        if (IsProfile) {

        }
        else {
            canvas.drawLine(waistX + legThickness/2, waistY, rFootX, rFootY, p);
            canvas.drawLine(waistX - legThickness/2, waistY, lFootX, lFootY, p);
        }

        return bitmap;
    }


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


    // Overrides
    @Override
    public String toString() {
        return this.Name;
    }
}
