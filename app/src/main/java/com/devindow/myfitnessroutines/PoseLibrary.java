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
	public static final String BEHIND_THE_BACK_GRAB = "Behind the Back Grab";
	public static final String TOUCH_TOES = "Touch Toes";
	public static final String JUMPING_JACKS = "Jumping Jacks";
	public static final String WALL_SIT = "Wall Sit";
	public static final String CRUNCHES = "Crunches";
	public static final String STEP_UPS = "Step-Ups";
	public static final String SQUATS = "Squats";
	public static final String CHAIR_DIPS = "Chair Dips";
	public static final String PUSH_UPS = "Push-Ups";
	public static final String PLANK = "Plank";
	public static final String HIGH_KNEES = "High Knees";
	public static final String LUNGES = "Lunges";
	public static final String PUSH_UP_ROTATE = "Push-Up & Rotate";
	public static final String SIDE_PLANK = "Side Plank";
	public static final String DOWN_DOG = "Down Dog";
	public static final String LOTUS = "Lotus";


	// Public Static Fields
	public static Dictionary<String, Pose> poses = new Hashtable<>();


	// Public Static Methods
	public static void generatePoses() {

		// Done
		{
			Pose pose = new Pose(DONE, Category.NONE);

			Angle legAngle = Angle.S.add(6);

			pose.torso = new Torso(0, Leg.getHeight(legAngle) + Leg.thickness/2);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, legAngle);
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle.mirror());

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


		// Behind the Back Grab
		{
			Pose pose = new Pose(BEHIND_THE_BACK_GRAB, Category.YOGA);

			pose.torso = new Torso(true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.S);

			int proximalAngle = 34;
			int distalAngle = 14;
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(proximalAngle), Angle.S.add(-distalAngle));
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(-proximalAngle), Angle.N.add(distalAngle));

			poses.put(pose.name, pose);
		}

		// Touch Toes
		{
			Pose pose = new Pose(TOUCH_TOES, Category.YOGA);

			Angle torsoAngle = Angle.S.add(45);
			pose.torso = new Torso(-Torso.getWidth(torsoAngle)/2, torsoAngle,true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S);

			poses.put(pose.name, pose);
		}

		// Down Dog
		{
			Pose pose = new Pose(DOWN_DOG, Category.YOGA);

			Angle legAngle = Angle.S.add(-35);
			Angle torsoAngle = Angle.S.add(45);
			Angle armAngle = Angle.S.add(52);
			pose.torso = new Torso(-(Torso.getWidth(torsoAngle) + Arm.getWidth(armAngle) - Leg.getWidth(legAngle))/2, Leg.getHeight(legAngle) + Leg.thickness/2, torsoAngle,true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armAngle);

			poses.put(pose.name, pose);
		}


		// Wall Sit
		{
			Pose pose = new Pose(WALL_SIT, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.prop = new Wall(pose.torso.waistX - Torso.thickness/2);

			poses.put(pose.name, pose);
		}

		// Squats
		{
			Pose pose = new Pose(SQUATS, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.E);

			poses.put(pose.name, pose);
		}

		// Chair Dips
		{
			Pose pose = new Pose(CHAIR_DIPS, Category.LIFTING);

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, new Angle(-140), Angle.S);

			final float chairX = pose.torso.waistX - Torso.thickness/2 - 2;
			final float chairSize = pose.rArm.handY - Arm.thickness/2;
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


		// Push-ups
		{
			Pose pose = new Pose(PUSH_UPS, Category.LIFTING);

			Angle angle = new Angle(25);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.getHeight(angle) + Leg.thickness/2,
					angle,
					true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite());

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(15));

			poses.put(pose.name, pose);
		}

		// Plank
		{
			Pose pose = new Pose(PLANK, Category.LIFTING);

			Angle angle = new Angle(12);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.getHeight(angle) + Leg.thickness/2,
					angle,
					true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite());

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(15), Angle.E);

			poses.put(pose.name, pose);
		}

		// Push-Up & Rotate
		{
			Pose pose = new Pose(PUSH_UP_ROTATE, Category.LIFTING);

			Angle angle = new Angle(25);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.thickness/2 + Leg.getHeight(angle) + Torso.getHipHeight(angle),
					angle);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, angle.opposite());
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite().add(5));

			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(15));
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(15));

			poses.put(pose.name, pose);
		}

		// Side Plank
		{
			Pose pose = new Pose(SIDE_PLANK, Category.LIFTING);

			Angle angle = new Angle(15);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.thickness/2 + Leg.getHeight(angle) + Torso.getHipHeight(angle),
					angle);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, angle.opposite());
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite().add(5));

			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(15), Angle.W,Arm.segmentLength/3);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, angle.opposite().add(-1));

			poses.put(pose.name, pose);
		}


		// Crunches
		{
			Pose pose = new Pose(CRUNCHES, Category.LIFTING);

			pose.torso = new Torso((Torso.getWidth(Angle.W) - Leg.getWidth(Angle.N, Angle.E))/2, Torso.thickness/2, Angle.W, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.N, Angle.E);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(-30));

			poses.put(pose.name, pose);
		}

/*
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
