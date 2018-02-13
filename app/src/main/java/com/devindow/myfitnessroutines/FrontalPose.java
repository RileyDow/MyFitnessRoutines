package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;

/**
 * Created by Devin on 1/27/2018.
 */

public class FrontalPose extends Pose {

    // Public Fields
    public int rShoulderX;
    public int rShoulderY;
    public int lShoulderX;
    public int lShoulderY;

    public int rHipX;
    public int rHipY;
    public int lHipX;
    public int lHipY;


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
        canvas.drawLine(neckX, neckY, waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        // Right Arm
        if (rElbowX != null && rElbowY != null) {
            canvas.drawLine(rShoulderX, neckY, rElbowX, rElbowY, p);
            canvas.drawLine(rElbowX, rElbowY, rHandX, rHandY, p);
        }
        else {
            canvas.drawLine(rShoulderX, neckY, rHandX, rHandY, p);
        }
        // Left Arm
        if (lElbowX != null && lElbowY != null) {
            canvas.drawLine(lShoulderX, neckY, lElbowX, lElbowY, p);
            canvas.drawLine(lElbowX, lElbowY, lHandX, lHandY, p);
        }
        else {
            canvas.drawLine(lShoulderX, neckY, lHandX, lHandY, p);
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

        rShoulderX = neckX + torsoThickness/2;
        lShoulderX = neckX - torsoThickness/2;
        rHipX = legThickness/2 + 1;
        lHipX = -legThickness/2 - 1;

        /*protected int getShoulderX() { return waistX + (int)Math.round(torsoLength * Math.cos(getBodyAngle())); }
        protected int getShoulderY() { return waistY + (int)Math.round(torsoLength * Math.sin(getBodyAngle())); }*/
    }


    @Override
    public String toString() {
        return this.name;
    }
}
