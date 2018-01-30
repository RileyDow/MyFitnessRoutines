package com.devindow.myfitnessroutines;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Devin on 1/29/2018.
 */

public class PoseLibrary {

	// Public Static Fields
	public static Dictionary<String, Pose> Poses = new Hashtable<String, Pose>();


	// Public Static Methods
	public static void GeneratePoses() {
		Pose pushup = new ProfilePose("Push-Ups", Category.LIFTING);
		pushup.headX = 30;
		pushup.headY = 24;
		pushup.waistX = 0;
		pushup.waistY = 12;
		pushup.rHandX = pushup.lHandX = 25;
		pushup.rHandY = pushup.lHandY = 0;
		pushup.rFootX = pushup.lFootX = -30;
		pushup.rFootY = pushup.lFootY = 0;
		Poses.put(pushup.Name, pushup);

	}

}
