package com.devindow.myfitnessroutines;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Devin on 1/29/2018.
 */

public class PoseLibrary {


	// Constants
	public static final String PUSHUPS = "Push-Ups";
	public static final String DOWNDOG = "Down Dog";


	// Public Static Fields
	public static Dictionary<String, Pose> Poses = new Hashtable<String, Pose>();


	// Public Static Methods
	public static void GeneratePoses() {
		Pose pose = new ProfilePose(PUSHUPS, Category.LIFTING);
		pose.headX = 30;
		pose.headY = 24;
		pose.waistX = 0;
		pose.waistY = 12;
		pose.rHandX = pose.lHandX = 25;
		pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -30;
		pose.rFootY = pose.lFootY = 0;
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(DOWNDOG, Category.YOGA);
		pose.headX = 30;
		pose.headY = 24;
		pose.waistX = 0;
		pose.waistY = 40;
		pose.rHandX = pose.lHandX = 25;
		pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -30;
		pose.rFootY = pose.lFootY = 0;
		Poses.put(pose.Name, pose);

	}

}
