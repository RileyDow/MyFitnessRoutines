package com.devindow.myfitnessroutines;

import android.graphics.Bitmap;

/**
 * Created by Devin on 1/27/2018.
 */

public class ProfilePose extends Pose {

    // Public Properties
    public Bitmap getBitmap() {
        prepCanvas();

        // Draw Head
        p.setStrokeWidth(headSize);
        canvas.drawPoint(headX, headY, p);

        // Draw Torso
        p.setStrokeWidth(torsoThickness);
        canvas.drawLine(getNeckX(), getNeckY(), waistX, waistY, p);

        // Draw Arms
        p.setStrokeWidth(armThickness);
        // Right Arm
        if (rElbowX != null && rElbowY != null) {
            canvas.drawLine(getNeckX(), getNeckY(), rElbowX, rElbowY, p);
            canvas.drawLine(rElbowX, rElbowY, rHandX, rHandY, p);
        }
        else {
            canvas.drawLine(getNeckX(), getNeckY(), rHandX, rHandY, p);
        }
        // Left Arm
        if (lElbowX != null && lElbowY != null) {
            canvas.drawLine(getNeckX(), getNeckY(), lElbowX, lElbowY, p);
            canvas.drawLine(lElbowX, lElbowY, lHandX, lHandY, p);
        }
        else {
            canvas.drawLine(getNeckX(), getNeckY(), lHandX, lHandY, p);
        }

        // Draw Legs
        p.setStrokeWidth(legThickness);
        // Right Leg
        if (rKneeX != null && rKneeY != null) {
            canvas.drawLine(waistX, waistY, rKneeX, rKneeY, p);
            canvas.drawLine(rKneeX, rKneeY, rFootX, rFootY, p);
        }
        else {
            canvas.drawLine(waistX, waistY, rFootX, rFootY, p);
        }
        // Left Leg
        if (lKneeX != null && lKneeY != null) {
            canvas.drawLine(waistX, waistY, lKneeX, lKneeY, p);
            canvas.drawLine(lKneeX, lKneeY, lFootX, lFootY, p);
        }
        else {
            canvas.drawLine(waistX, waistY, lFootX, lFootY, p);
        }

        // Prop
        if (prop != null) {
            prop.draw(canvas);
        }

        return bitmap;
    }


    // Constructors
    public ProfilePose(String name, Category category) { super(name, category); }
    public ProfilePose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    public String toString() {
        return this.name;
    }
}
