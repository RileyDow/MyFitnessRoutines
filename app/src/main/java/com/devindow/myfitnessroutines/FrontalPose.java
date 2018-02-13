package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;

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

        //p.setColor(Color.BLACK);
        // Draw Head
        p.setStrokeWidth(headSize);
        canvas.drawPoint(headX, headY, p);

        //p.setColor(Color.RED);
        // Draw Torso
        p.setStrokeWidth(torsoThickness);
        canvas.drawLine(collarX, collarY, waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        // Right Arm
        if (rElbowX != null && rElbowY != null) {
            canvas.drawLine(rShoulderX, collarY, rElbowX, rElbowY, p);
            canvas.drawLine(rElbowX, rElbowY, rHandX, rHandY, p);
        }
        else {
            canvas.drawLine(rShoulderX, collarY, rHandX, rHandY, p);
        }
        // Left Arm
        if (lElbowX != null && lElbowY != null) {
            canvas.drawLine(lShoulderX, collarY, lElbowX, lElbowY, p);
            canvas.drawLine(lElbowX, lElbowY, lHandX, lHandY, p);
        }
        else {
            canvas.drawLine(lShoulderX, collarY, lHandX, lHandY, p);
        }

        //p.setColor(Color.BLUE);
        // Draw Legs
        p.setStrokeWidth(legThickness);
        // Right Leg
        if (rKneeX != null && rKneeY != null) {
            canvas.drawLine(rHipX, waistY, rKneeX, rKneeY, p);
            canvas.drawLine(rKneeX, rKneeY, rFootX, rFootY, p);
        }
        else {
            canvas.drawLine(rHipX, waistY, rFootX, rFootY, p);
        }
        // Left Leg
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
    protected void generateCoords() {
        super.generateCoords();

        float distanceNeckToShoulder = 0.5f*torsoThickness + 0.5f*armThickness;
        rShoulderX = collarX - distanceNeckToShoulder * (float)Math.sin(bodyAngle);
        rShoulderY = collarY + distanceNeckToShoulder * (float)Math.sin(bodyAngle);
        lShoulderX = collarX + distanceNeckToShoulder * (float)Math.sin(bodyAngle);
        lShoulderY = collarY - distanceNeckToShoulder * (float)Math.cos(bodyAngle);

        float distanceWaistToHip = 0.5f*legThickness + 1;
        rHipX = waistX - distanceWaistToHip * (float)Math.sin(bodyAngle);
        rHipY = waistY + distanceWaistToHip * (float)Math.sin(bodyAngle);
        lHipX = waistX + distanceWaistToHip * (float)Math.sin(bodyAngle);
        lHipY = waistY - distanceWaistToHip * (float)Math.cos(bodyAngle);
    }


    @Override
    public String toString() {
        return this.name;
    }
}
