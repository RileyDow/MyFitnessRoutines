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

public class ProfilePose extends Pose {

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
        p.setStrokeWidth(torsoThickness);
        canvas.drawLine(getNeckX(), getNeckY(), waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        canvas.drawLine(getNeckX(), getNeckY(), rHandX, rHandY, p);
        canvas.drawLine(getNeckX(), getNeckY(), lHandX, lHandY, p);

        // Draw Legs
        p.setStrokeWidth(legThickness);
        canvas.drawLine(waistX + legThickness/2, waistY, rFootX, rFootY, p);
        canvas.drawLine(waistX - legThickness/2, waistY, lFootX, lFootY, p);

        return bitmap;
    }


    // Constructors
    public ProfilePose(String name, Category category) { super(name, category); }
    public ProfilePose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    public String toString() {
        return this.Name;
    }
}
