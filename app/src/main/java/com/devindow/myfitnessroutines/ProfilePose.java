package com.devindow.myfitnessroutines;

/**
 * Created by Devin on 1/27/2018.
 */

public class ProfilePose extends Pose {

    // Constructors
    public ProfilePose(String name, Category category) { super(name, category); }
    public ProfilePose(String name, Category category, boolean twoSides) { super(name, category, twoSides); }


    // Overrides
    @Override
    protected void generateShoulderAndHipCoords() {
        rShoulderX = lShoulderX = collarX;
        rShoulderY = lShoulderY = collarY;

        rHipX = lHipX = waistX;
        rHipY = lHipY = waistY;
    }
}
