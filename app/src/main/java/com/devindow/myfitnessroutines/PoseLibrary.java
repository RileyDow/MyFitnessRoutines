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
	public static final String JUMPING_JACKS = "Jumping Jacks";
	public static final String WALL_SIT = "Wall Sit";
	public static final String CRUNCHES = "Crunches";
	public static final String STEP_UPS = "Step-Ups";
	public static final String SQUATS = "Squats";
	public static final String CHAIR_DIPS = "Chair Dips";
	public static final String PLANK = "Plank";
	public static final String HIGH_KNEES = "High Knees";
	public static final String LUNGES = "Lunges";
	public static final String PUSHUP_ROLL = "Push-Up & Roll";
	public static final String SIDE_PLANK = "Side Plank";
	public static final String DOWNDOG = "Down Dog";
	public static final String LOTUS = "Lotus";


	// Public Static Fields
	public static Dictionary<String, Pose> Poses = new Hashtable<String, Pose>();


	// Public Static Methods
	public static void GeneratePoses() {
		Pose pose;

		pose = new ProfilePose(PUSHUPS, Category.LIFTING);
		pose.headX = 30; pose.headY = 24;
		pose.waistX = 0; pose.waistY = 12;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -30; pose.rFootY = pose.lFootY = 0;
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(JUMPING_JACKS, Category.CARDIO);
		pose.headX = 0; pose.headY = 66;
		pose.waistX = 0; pose.waistY = 34;
		pose.rHandX = 25; pose.lHandX = -25; pose.rHandY = pose.lHandY = 70;
		pose.rFootX = 15; pose.lFootX = -15; pose.rFootY = pose.lFootY = 0;
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(WALL_SIT, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(CRUNCHES, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(STEP_UPS, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(SQUATS, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(CHAIR_DIPS, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(PLANK, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(HIGH_KNEES, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(LUNGES, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(PUSHUP_ROLL, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(SIDE_PLANK, Category.LIFTING);
		Poses.put(pose.Name, pose);

		pose = new ProfilePose(DOWNDOG, Category.YOGA);
		pose.headX = 30; pose.headY = 13;
		pose.waistX = 0; pose.waistY = 35;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -24; pose.rFootY = pose.lFootY = 0;
		Poses.put(pose.Name, pose);

		pose = new FrontalPose(LOTUS, Category.YOGA);
		pose.headX = 0; pose.headY = 33;
		pose.waistX = 0; pose.waistY = 3;
		pose.rHandX = 15; pose.lHandX = -15; pose.rHandY = pose.lHandY = 7;
		pose.rElbowX = 9; pose.lElbowX = -9; pose.rElbowY = pose.lElbowY = 10;
		pose.rFootX = 5; pose.lFootX = -5; pose.rFootY = pose.lFootY = 2;
		pose.rKneeX = 15; pose.lKneeX = -15; pose.rKneeY = pose.lKneeY = 5;
		Poses.put(pose.Name, pose);

	}

}
