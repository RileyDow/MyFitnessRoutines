package com.devindow.myfitnessroutines;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Devin on 3/17/2018.
 */

public class Preferences {

	// Public Methods
	public static boolean getSpeakMoveNames(Context context) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		return prefs.getBoolean("speak_move_names", true);
	}

	public static void setSpeakMoveNames(Context context, boolean value) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("speak_move_names", value);
		editor.commit();
	}


	public static boolean getSpeakMoveInstructions(Context context) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		return prefs.getBoolean("speak_move_instructions", true);
	}

	public static void setSpeakMoveInstructions(Context context, boolean value) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("speak_move_instructions", value);
		editor.commit();
	}

}
