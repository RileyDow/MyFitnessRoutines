package com.devindow.myfitnessroutines;

import android.media.Image;

/**
 * Created by Devin on 1/27/2018.
 */

public class Pose {

    public String Name;
    public Category Category;
    public boolean TwoSides;
    public Image Image;


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
