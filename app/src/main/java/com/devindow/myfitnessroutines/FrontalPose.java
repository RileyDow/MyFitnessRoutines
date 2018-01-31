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

public class FrontalPose extends Pose {

    // Public Properties
    public Bitmap getBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.translate(bitmapSize/2, bitmapSize-1); // Origin a floor center
        canvas.scale(10, -10); // up is positive Y, 10x scale

        Paint p = new Paint();
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setColor(Color.BLACK);

        // Draw Floor
        p.setStrokeWidth(1);
        canvas.drawLine(-bitmapSize/2, 0,bitmapSize/2,0, p);

        // Draw Head
        p.setStrokeWidth(headSize);
        canvas.drawPoint(headX, headY, p);

        // Draw Torso
        p.setStrokeWidth(torsoThickness);
        canvas.drawLine(getNeckX(), getNeckY(), waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        // Right Arm
        int rShoulderX = getNeckX() + torsoThickness/2;
        if (rElbowX != null && rElbowY != null) {
            canvas.drawLine(rShoulderX, getNeckY(), rElbowX, rElbowY, p);
            canvas.drawLine(rElbowX, rElbowY, rHandX, rHandY, p);
        }
        else {
            canvas.drawLine(rShoulderX, getNeckY(), rHandX, rHandY, p);
        }
        // Left Arm
        int lShoulderX = getNeckX() - torsoThickness/2;
        if (lElbowX != null && lElbowY != null) {
            canvas.drawLine(lShoulderX, getNeckY(), lElbowX, lElbowY, p);
            canvas.drawLine(lElbowX, lElbowY, lHandX, lHandY, p);
        }
        else {
            canvas.drawLine(lShoulderX, getNeckY(), lHandX, lHandY, p);
        }

        // Draw Legs
        p.setStrokeWidth(legThickness);
        // Right Leg
        int rHipX = waistX + legThickness / 3;
        if (rKneeX != null && rKneeY != null) {
            canvas.drawLine(rHipX, waistY, rKneeX, rKneeY, p);
            canvas.drawLine(rKneeX, rKneeY, rFootX, rFootY, p);
        }
        else {
            canvas.drawLine(rHipX, waistY, rFootX, rFootY, p);
        }
        // Left Leg
        int lHipX = waistX - legThickness / 3;
        if (lKneeX != null && lKneeY != null) {
            canvas.drawLine(lHipX, waistY, lKneeX, lKneeY, p);
            canvas.drawLine(lKneeX, lKneeY, lFootX, lFootY, p);
        }
        else {
            canvas.drawLine(lHipX, waistY, lFootX, lFootY, p);
        }

        return bitmap;
    }


    // Constructors
    public FrontalPose(String name, Category category) { super(name, category); }
    public FrontalPose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    public String toString() {
        return this.Name;
    }
}
