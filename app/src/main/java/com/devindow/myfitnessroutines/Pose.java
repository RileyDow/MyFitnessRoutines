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


    // Public Properties
    public Bitmap getBitmap(int w, int h) {
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(8);
        canvas.drawText("Hello", w/2, h/2, p);
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
