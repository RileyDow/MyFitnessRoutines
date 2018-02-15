package com.devindow.myfitnessroutines;

/**
 * Created by Devin on 1/27/2018.
 */

public class FrontalPose extends Pose {

    // Constructors
    public FrontalPose(String name, Category category) { super(name, category); }
    public FrontalPose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    protected void generateShoulderAndHipCoords() {
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
}
