package com.devindow.myfitnessroutines;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Devin on 1/29/2018.
 */

public class PoseLibrary {


	// Constants
    public static final String BEHIND_THE_BACK_GRAB = "Behind the Back Grab";
    public static final String DONE = "Done!";
	public static final String REST = "Rest";
	public static final String PUSH_UPS = "Push-Ups";
	public static final String JUMPING_JACKS = "Jumping Jacks";
	public static final String WALL_SIT = "Wall Sit";
	public static final String CRUNCHES = "Crunches";
	public static final String STEP_UPS = "Step-Ups";
	public static final String SQUATS = "Squats";
	public static final String CHAIR_DIPS = "Chair Dips";
	public static final String PLANK = "Plank";
	public static final String HIGH_KNEES = "High Knees";
	public static final String LUNGES = "Lunges";
	public static final String PUSH_UP_ROTATE = "Push-Up & Rotate";
	public static final String SIDE_PLANK = "Side Plank";
	public static final String DOWN_DOG = "Down Dog";
	public static final String LOTUS = "Lotus";


	// Public Static Fields
	public static Dictionary<String, Pose> poses = new Hashtable<String, Pose>();


	// Public Static Methods
	public static void generatePoses() {
		Pose pose;


		// Behind the Back Grab
        pose = new ProfilePose(BEHIND_THE_BACK_GRAB, Category.YOGA);
        pose.generateCoords();
        pose.rElbowY = pose.collarY + pose.armSegmentLength;
        pose.rHandY = pose.lHandY = pose.collarY;
        pose.lElbowY = pose.collarY - pose.armSegmentLength;
        pose.rElbowX = pose.lElbowX = pose.waistX - pose.torsoThickness/2 - pose.armThickness/2;
        pose.rHandX = pose.lHandX = pose.lElbowX - 1;
        pose.rFootX = pose.lFootX = 0;
        poses.put(pose.name, pose);



		// Done
		pose = new FrontalPose(DONE, Category.NONE);
		pose.rHandX = -19; pose.lHandX = 19; pose.rHandY = pose.lHandY = 73;
		pose.rElbowX = -17f; pose.lElbowX = 17f; pose.rElbowY = pose.lElbowY = 59f;
		pose.rFootX = -4; pose.lFootX = 4;
		poses.put(pose.name, pose);

		// Jumping Jacks
		pose = new FrontalPose(JUMPING_JACKS, Category.CARDIO);
		pose.rElbowX = -17f; pose.lElbowX = 17f;
		float distanceHandOutsideOfElbow = 4;
		pose.rHandX = pose.rElbowX - distanceHandOutsideOfElbow; pose.lHandX = pose.lElbowX + distanceHandOutsideOfElbow;
		float elbowHeight = pose.headY;
		pose.rElbowY = pose.lElbowY = elbowHeight;
		pose.rHandY = pose.lHandY = elbowHeight + pose.armSegmentLength;
		pose.rFootX = -11; pose.lFootX = 11;
		poses.put(pose.name, pose);


		// Wall Sit
		pose = new ProfilePose(WALL_SIT, Category.LIFTING);
		pose.headX = pose.waistX = pose.lHandX = pose.rHandX = -pose.legSegmentLength/2;
		pose.waistY = pose.rKneeY = pose.lKneeY = pose.rHandY = pose.lHandY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2;
		pose.rFootX = pose.lFootX = pose.rKneeX = pose.lKneeX = -pose.waistX;
		pose.rFootY = pose.lFootY = 0;
		pose.prop = new Wall(pose.waistX - pose.torsoThickness/2);
		poses.put(pose.name, pose);

		// Squats
		pose = new ProfilePose(SQUATS, Category.LIFTING);
		pose.headX = pose.waistX = -pose.legSegmentLength/2;
		pose.waistY = pose.rKneeY = pose.lKneeY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2;
		pose.rHandX = pose.lHandX = pose.headX + pose.armSegmentLength * 2;
		pose.generateCoords();
		pose.rHandY = pose.lHandY = pose.collarY;
		pose.rFootX = pose.lFootX = pose.rKneeX = pose.lKneeX = -pose.waistX;
		pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);

		// Chair Dips
		pose = new ProfilePose(CHAIR_DIPS, Category.LIFTING);
		pose.headX = pose.waistX = -pose.legSegmentLength/2;
		pose.waistY = pose.rKneeY = pose.lKneeY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2;
		pose.rFootX = pose.lFootX = pose.rKneeX = pose.lKneeX = -pose.waistX;
		pose.rFootY = pose.lFootY = 0;
		final float chairX = pose.waistX - pose.torsoThickness/2 - 2;
		final float chairSize = pose.legSegmentLength;
		pose.prop = new Ledge(chairX, chairX - chairSize, chairSize);
		pose.rHandX = pose.lHandX = pose.rElbowX = pose.lElbowX = chairX - pose.armThickness/2;
		pose.rHandY = pose.lHandY = chairSize + pose.armThickness/2;
		pose.rElbowY = pose.lElbowY = chairSize + pose.armThickness/2 + pose.armSegmentLength;
		poses.put(pose.name, pose);

		// Step-Ups & High Knees
		pose = new ProfilePose(STEP_UPS, Category.LIFTING);
		final float x = -pose.legSegmentLength/2;
		pose.headX = pose.waistX = pose.lFootX = pose.lHandX = pose.rHandX = x;
		pose.rFootX = pose.rKneeX = x + pose.legSegmentLength;
		pose.rFootY = pose.legSegmentLength + pose.legThickness/2;
		pose.rKneeY = pose.legSegmentLength*2;
		final float stepSize = pose.legSegmentLength;
		pose.prop = new Ledge(pose.rFootX - pose.legThickness/2, pose.rFootX + stepSize, stepSize);
		poses.put(pose.name, pose);

		pose = new ProfilePose(HIGH_KNEES, Category.LIFTING);
		pose.headX = pose.waistX = pose.lFootX = pose.lHandX = pose.rHandX = x;
		final float kneeBendDistance = 4;
		pose.lKneeX = pose.lFootX + kneeBendDistance;
		pose.lKneeY = pose.legSegmentLength;
		pose.rFootX = pose.rKneeX = x + pose.legSegmentLength;
		final float distanceAbovePerpendicular = 2;
		pose.rFootY = pose.legSegmentLength + pose.legThickness/2 + distanceAbovePerpendicular;
		pose.rKneeY = pose.waistY + distanceAbovePerpendicular;
		poses.put(pose.name, pose);

		// Lunges
		pose = new ProfilePose(LUNGES, Category.LIFTING);
		pose.waistY = pose.rHandY = pose.lHandY = pose.legSegmentLength;
		pose.headY = pose.waistY + pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2;
		pose.lHandX = pose.rHandX = 0;
		pose.rFootX = pose.rKneeX = pose.legSegmentLength;
		pose.rFootY = pose.lFootY = pose.lKneeY = pose.legThickness/2;
		pose.rKneeY = pose.legSegmentLength;
		final float kneeDistance = 4;
		pose.lKneeX = -kneeDistance;
		pose.lFootX = pose.lKneeX - pose.legSegmentLength;
		poses.put(pose.name, pose);


		// Push-ups
		pose = new ProfilePose(PUSH_UPS, Category.LIFTING);
		pose.headX = 30; pose.headY = 23;
		pose.waistX = 1; pose.waistY = 14;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = pose.armThickness/2;
		pose.rFootX = pose.lFootX = -33; pose.rFootY = pose.lFootY = pose.legThickness/2;
		poses.put(pose.name, pose);

		// Plank
		pose = new ProfilePose(PLANK, Category.LIFTING);
		pose.headX = 30; pose.headY = 16;
		pose.waistX = 1; pose.waistY = 10;
		pose.rHandY = pose.lHandY = pose.rElbowY = pose.lElbowY = pose.armThickness/2;
		pose.generateCoords();
		pose.rElbowX = pose.lElbowX = pose.collarX;
		pose.rHandX = pose.lHandX = pose.rElbowX + pose.armSegmentLength;
		pose.rFootX = pose.lFootX = -30; pose.rFootY = pose.lFootY = pose.legThickness/2;
		poses.put(pose.name, pose);

		// Push-Up & Rotate
		pose = new FrontalPose(PUSH_UP_ROTATE, Category.LIFTING);
		pose.headX = 0.86f * (pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2);
		pose.headY = pose.armSegmentLength*2 + pose.torsoThickness/2 + pose.headSize/2;
		pose.waistX = 0;
		pose.waistY = .62f * pose.headY;
		pose.lFootX = -pose.legSegmentLength*2;
		pose.rFootX = pose.lFootX - 2;
		pose.lFootY = pose.legThickness/2;
		pose.rFootY = pose.lFootY + pose.legThickness - 1;
		pose.lHandX = 25; pose.lHandY = pose.armThickness/2;
		pose.generateCoords();
		pose.rHandX = ((FrontalPose)pose).rShoulderX - pose.armThickness;
		pose.rHandY = ((FrontalPose)pose).rShoulderY + pose.armSegmentLength*2;
		poses.put(pose.name, pose);

		// Side Plank
		pose = new FrontalPose(SIDE_PLANK, Category.LIFTING, true);
		pose.headX = 0.9f * (pose.torsoLength + pose.torsoThickness/2 + pose.headSize/2);
		pose.headY = pose.armSegmentLength + pose.torsoThickness/2 + pose.headSize/2;
		pose.waistX = 0;
		pose.waistY = .65f * pose.headY;
		pose.lFootX = -pose.legSegmentLength*2;
		pose.rFootX = pose.lFootX - 1;
		pose.lFootY = pose.legThickness/2;
		pose.rFootY = pose.lFootY + pose.legThickness - 1;
		pose.generateCoords();
		pose.lElbowX = ((FrontalPose) pose).lShoulderX;
		pose.lHandX = pose.lElbowX - 2;
		pose.lElbowY = pose.lHandY = pose.armThickness/2;
		pose.rHandX = ((FrontalPose)pose).rShoulderX - pose.armSegmentLength*2;
		pose.rHandY = ((FrontalPose)pose).rHipY + pose.armThickness;
		poses.put(pose.name, pose);


		// Crunches
		pose = new ProfilePose(CRUNCHES, Category.LIFTING);
		pose.headY = pose.waistY = pose.torsoThickness/2;
		pose.headX = -20;
		pose.waistX = pose.rKneeX = pose.lKneeX = pose.headX + pose.headSize/2 + pose.torsoThickness/2 + pose.torsoLength;
		pose.rFootX = pose.lFootX = pose.waistX + pose.legSegmentLength;
		pose.rKneeY = pose.lKneeY = pose.rFootY = pose.lFootY = pose.legSegmentLength;
		pose.generateCoords();
		pose.rHandX = pose.lHandX = pose.collarX + 10;
		pose.rHandY = pose.lHandY = pose.armSegmentLength * 2;
		poses.put(pose.name, pose);

		// Down Dog
		pose = new ProfilePose(DOWN_DOG, Category.YOGA);
		pose.headX = 30; pose.headY = 13;
		pose.waistX = 0; pose.waistY = 35;
		pose.rHandX = pose.lHandX = 25; pose.rHandY = pose.lHandY = 0;
		pose.rFootX = pose.lFootX = -24; pose.rFootY = pose.lFootY = 0;
		poses.put(pose.name, pose);


		// Lotus & Rest
		pose = new FrontalPose(LOTUS, Category.YOGA);
		pose.headX = 0; pose.headY = 33;
		pose.waistX = 0; pose.waistY = 3;
		pose.rHandX = -15; pose.lHandX = 15; pose.rHandY = pose.lHandY = 7;
		pose.rElbowX = -9f; pose.lElbowX = 9f; pose.rElbowY = pose.lElbowY = 10f;
		pose.rFootX = -5; pose.lFootX = 5; pose.rFootY = pose.lFootY = 2;
		pose.rKneeX = -15f; pose.lKneeX = 15f; pose.rKneeY = pose.lKneeY = 5f;
		poses.put(pose.name, pose);

		pose = new FrontalPose(REST, Category.NONE);
		pose.headX = 0; pose.headY = 33;
		pose.waistX = 0; pose.waistY = 3;
		pose.rHandX = -15; pose.lHandX = 15; pose.rHandY = pose.lHandY = 7;
		pose.rElbowX = -9f; pose.lElbowX = 9f; pose.rElbowY = pose.lElbowY = 10f;
		pose.rFootX = -5; pose.lFootX = 5; pose.rFootY = pose.lFootY = 2;
		pose.rKneeX = -15f; pose.lKneeX = 15f; pose.rKneeY = pose.lKneeY = 5f;
		poses.put(pose.name, pose);

	}

}
