package com.devindow.myfitnessroutines;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Devin on 1/29/2018.
 */

public class PoseLibrary {


	// Constants
	public static final String DONE = "Done!";
	public static final String REST = "Rest";
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
	public static Dictionary<String, Pose> poses = new Hashtable<String, Pose>();


	// Public Static Methods
	public static void generatePoses() {
		Pose pose;

		pose = new FrontalPose(DONE, Category.NONE);
		pose.headX = 0; pose.headY = 66;
		pose.waistX = 0; pose.waistY = 34;
		pose.rHandX = 19; pose.lHandX = -19; pose.rHandY = pose.lHandY = 73;
		pose.rElbowX = 17; pose.lElbowX = -17; pose.rElbowY = pose.lElbowY = 59;
		pose.rFootX = 4; pose.lFootX = -4; pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);

		pose = new FrontalPose(REST, Category.NONE);
		pose.headX = 0; pose.headY = 33;
		pose.waistX = 0; pose.waistY = 3;
		pose.rHandX = 15; pose.lHandX = -15; pose.rHandY = pose.lHandY = 7;
		pose.rElbowX = 9; pose.lElbowX = -9; pose.rElbowY = pose.lElbowY = 10;
		pose.rFootX = 5; pose.lFootX = -5; pose.rFootY = pose.lFootY = 2;
		pose.rKneeX = 15; pose.lKneeX = -15; pose.rKneeY = pose.lKneeY = 5;
		poses.put(pose.name, pose);

		pose = new ProfilePose(PUSHUPS, Category.LIFTING);
		pose.headX = 30; pose.headY = 23;
		pose.waistX = 1; pose.waistY = 14;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = pose.armThickness/2;
		pose.rFootX = pose.lFootX = -33; pose.rFootY = pose.lFootY = pose.legThickness/2;
		poses.put(pose.name, pose);

		pose = new FrontalPose(JUMPING_JACKS, Category.CARDIO);
		pose.rHandX = 25; pose.lHandX = -25; pose.rHandY = pose.lHandY = 70;
		pose.rFootX = 15; pose.lFootX = -15;
		poses.put(pose.name, pose);

		pose = new ProfilePose(WALL_SIT, Category.LIFTING);
		pose.headX = pose.waistX = pose.lHandX = pose.rHandX = -pose.legSegmentLength/2;
		pose.waistY = pose.lKneeY = pose.rKneeY = pose.lHandY = pose.rHandY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.headSize/2 + pose.torsoThickness/2;
		pose.lFootX = pose.rFootX = pose.lKneeX = pose.rKneeX = -pose.waistX;
		pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);

		pose = new ProfilePose(CRUNCHES, Category.LIFTING);
		pose.headY = pose.waistY = pose.torsoThickness/2;
		pose.headX = -20;
		pose.waistX = pose.rKneeX = pose.lKneeX = pose.headX + pose.headSize/2 + pose.torsoThickness/2 + pose.torsoLength;
		pose.rFootX = pose.lFootX = pose.waistX + pose.legSegmentLength;
		pose.rKneeY = pose.lKneeY = pose.rFootY = pose.lFootY = pose.legSegmentLength;
		pose.rHandX = pose.lHandX = pose.getNeckX() + 10;
		pose.rHandY = pose.lHandY = pose.armSegmentLength * 2;
		poses.put(pose.name, pose);

		pose = new ProfilePose(STEP_UPS, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(SQUATS, Category.LIFTING);
		pose.headX = pose.waistX = -pose.legSegmentLength/2;
		pose.waistY = pose.lKneeY = pose.rKneeY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.headSize/2 + pose.torsoThickness/2;
		pose.lHandX = pose.rHandX = pose.headX + pose.armSegmentLength * 2;
		pose.lHandY = pose.rHandY = pose.getNeckY();
		pose.lFootX = pose.rFootX = pose.lKneeX = pose.rKneeX = -pose.waistX;
		pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);

		pose = new ProfilePose(CHAIR_DIPS, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(PLANK, Category.LIFTING);
		pose.headX = 30; pose.headY = 16;
		pose.waistX = 1; pose.waistY = 10;
		pose.rHandY = pose.lHandY = pose.rElbowY = pose.lElbowY = pose.armThickness/2;
		pose.rElbowX = pose.lElbowX = pose.getNeckX();
		pose.rHandX = pose.lHandX = pose.rElbowX + pose.armSegmentLength;
		pose.rFootX = pose.lFootX = -30; pose.rFootY = pose.lFootY = pose.legThickness/2;
		poses.put(pose.name, pose);

		pose = new ProfilePose(HIGH_KNEES, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(LUNGES, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(PUSHUP_ROLL, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(SIDE_PLANK, Category.LIFTING);
		poses.put(pose.name, pose);

		pose = new ProfilePose(DOWNDOG, Category.YOGA);
		pose.headX = 30; pose.headY = 13;
		pose.waistX = 0; pose.waistY = 35;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -24; pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);

		pose = new FrontalPose(LOTUS, Category.YOGA);
		pose.headX = 0; pose.headY = 33;
		pose.waistX = 0; pose.waistY = 3;
		pose.rHandX = 15; pose.lHandX = -15; pose.rHandY = pose.lHandY = 7;
		pose.rElbowX = 9; pose.lElbowX = -9; pose.rElbowY = pose.lElbowY = 10;
		pose.rFootX = 5; pose.lFootX = -5; pose.rFootY = pose.lFootY = 2;
		pose.rKneeX = 15; pose.lKneeX = -15; pose.rKneeY = pose.lKneeY = 5;
		poses.put(pose.name, pose);

	}

}
