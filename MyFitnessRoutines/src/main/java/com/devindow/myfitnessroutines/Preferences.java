package com.devindow.myfitnessroutines;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Devin on 3/17/2018.
 */

public class Preferences {

	// Public Methods
	public static boolean getSpeakMoveNames() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.getContext());
		return prefs.getBoolean("speak_move_names", true);
	}

	public static void setSpeakMoveNames(boolean value) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.getContext());
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("speak_move_names", value);
		editor.commit();
	}


	public static boolean getSpeakMoveInstructions() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.getContext());
		return prefs.getBoolean("speak_move_instructions", true);
	}

	public static void setSpeakMoveInstructions(boolean value) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.getContext());
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("speak_move_instructions", value);
		editor.commit();
	}

}
