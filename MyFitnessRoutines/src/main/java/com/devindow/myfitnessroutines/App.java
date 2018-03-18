package com.devindow.myfitnessroutines;

import android.app.Application;
import android.content.Context;

import com.devindow.myfitnessroutines.db.Database;

/**
 * Created by Devin on 3/17/2018.
 */

public class App extends Application {

	// Static Fields
	private static Application instance;


	// Public Properties
	public static Application getApplication() {
		return instance;
	}

	public static Context getContext() {
		return getApplication().getApplicationContext();
	}


	// Overrides
	@Override
	public void onCreate() {
		super.onCreate();

		instance = this;

		Database.init();
	}

}
