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

		// Done
		{
			Pose pose = new Pose(DONE, Category.NONE);

			pose.torso = new Torso(0, Leg.segmentLength * 2 + Leg.thickness / 2);

			Angle legAngle = new Angle(-88);
			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, legAngle, Leg.segmentLength*2);
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle.mirror(), Leg.segmentLength*2);

			Angle armProximalAngle = new Angle(30);
			Angle armDistalAngle = new Angle(80);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, armProximalAngle, armDistalAngle);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armProximalAngle.mirror(), armDistalAngle.mirror());

			poses.put(pose.name, pose);
		}

		// Jumping Jacks
		{
			Pose pose = new Pose(JUMPING_JACKS, Category.CARDIO);

			Angle legAngle = new Angle(-70);

			pose.torso = new Torso(0, Leg.getHeight(legAngle) + Leg.thickness/2);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, legAngle);
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle.mirror());

			Angle armProximalAngle = new Angle(30);
			Angle armDistalAngle = new Angle(60);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, armProximalAngle, armDistalAngle);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armProximalAngle.mirror(), armDistalAngle.mirror());

			poses.put(pose.name, pose);
		}


		// Wall Sit
		{
			Pose pose = new Pose(WALL_SIT, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.prop = new Wall(pose.torso.waistX - pose.torso.thickness/2);

			poses.put(pose.name, pose);
		}

		// Squats
		{
			Pose pose = new Pose(SQUATS, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, new Angle(0));

			poses.put(pose.name, pose);
		}

		// Chair Dips
		{
			Pose pose = new Pose(CHAIR_DIPS, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, new Angle(-130), new Angle(-90));

			final float chairX = pose.torso.waistX - pose.torso.thickness/2 - 2;
			final float chairSize = Leg.segmentLength;
			pose.prop = new Ledge(chairX, chairX - chairSize, chairSize);

			poses.put(pose.name, pose);
		}

		// Lunges
		{
			Pose pose = new Pose(LUNGES, Category.LIFTING);

			pose.torso = new Torso(0, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S.add(-5));

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, Angle.S.add(-10), Angle.W);

			poses.put(pose.name, pose);
		}

		// Step-Ups
		{
			Pose pose = new Pose(STEP_UPS, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight() + Leg.thickness/2, true);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, Angle.S);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E.add(-5), Angle.S);

			float stepSize = pose.rLeg.footY - Leg.thickness/2;
			pose.prop = new Ledge(pose.rLeg.footX - Leg.thickness/2, pose.rLeg.footX + stepSize, stepSize);

			poses.put(pose.name, pose);
		}

		// High Knees
		{
			Pose pose = new Pose(HIGH_KNEES, Category.LIFTING);

			Angle lLegProximalAngle = Angle.S.add(+10);
			Angle lLegDistalAngle = Angle.S.add(-10);
			Angle rLegAngle = Angle.E.add(10);

			pose.torso = new Torso(-Leg.getWidth(rLegAngle, Angle.S)/2, Leg.getHeight(lLegProximalAngle, lLegDistalAngle) + Leg.thickness/2, true);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, lLegProximalAngle, lLegDistalAngle);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, rLegAngle, Angle.S);

			poses.put(pose.name, pose);
		}


/*
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
		pose.generateCollar();
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
		pose.generateCollar();
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
		pose.generateCollar();
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
		pose.generateCollar();
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
*/
	}

}
