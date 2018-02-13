package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by Devin on 1/27/2018.
 */

public class FrontalPose extends Pose {

    // Public Fields
    public float rShoulderX;
    public float rShoulderY;
    public float lShoulderX;
    public float lShoulderY;

    public float rHipX;
    public float rHipY;
    public float lHipX;
    public float lHipY;


    // Public Properties
    public Bitmap getBitmap() {
        super.getBitmap();

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

        return bitmap;
    }


    // Constructors
    public FrontalPose(String name, Category category) { super(name, category); }
    public FrontalPose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    protected void generateCoords() {
        super.generateCoords();

        float distanceNeckToShoulder = 0.5f*torsoThickness + 0.5f*armThickness;
        rShoulderX = collarX - distanceNeckToShoulder * (float)Math.sin(bodyAngle);
        rShoulderY = collarY + distanceNeckToShoulder * (float)Math.cos(bodyAngle);
        lShoulderX = collarX + distanceNeckToShoulder * (float)Math.sin(bodyAngle);
        lShoulderY = collarY - distanceNeckToShoulder * (float)Math.cos(bodyAngle);

        float distanceWaistToHip = 0.5f*legThickness + 1;
        rHipX = waistX - distanceWaistToHip * (float)Math.sin(bodyAngle);
        rHipY = waistY + distanceWaistToHip * (float)Math.cos(bodyAngle);
        lHipX = waistX + distanceWaistToHip * (float)Math.sin(bodyAngle);
        lHipY = waistY - distanceWaistToHip * (float)Math.cos(bodyAngle);
    }


    @Override
    public String toString() {
        return this.name;
    }
}
