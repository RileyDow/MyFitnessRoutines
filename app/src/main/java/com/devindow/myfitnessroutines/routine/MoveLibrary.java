package com.devindow.myfitnessroutines.routine;

import com.devindow.myfitnessroutines.pose.*;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Devin on 1/29/2018.
 */

public class MoveLibrary {


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
	public static final String ROTATE_ON_ALL_FOURS = "Rotate on all fours";
	public static final String TWIST_PIVOT = "Twist & Pivot";
	public static final String SAFETY_JACKS = "Safety Jacks";
	public static final String ROMAN_LUNGES = "Roman Lunges";
	public static final String HIP_STRETCH = "Hip Stretch";
	public static final String HAMSTRING_STRETCH = "Hamstring Stretch";
	public static final String HIP_HAMSTRING = "Hip/Hamstring Stretch";
	public static final String LEG_SWINGS = "Leg Swings";
	public static final String WALKING_BACKWARD_LUNGES = "Walking Backward Lunges";
	public static final String FOAM_ROLLER = "Foam Roller";
	public static final String THORACIC_ROLL_OUTS = "Thoracic Roll-outs";
	public static final String INCH_WORMS = "Inch Worms";
	public static final String SINGLE_LEG_BRIDGE = "Single-Leg Bridge";
	public static final String SIDE_LYING_ABDUCTION_W_BAND = "Side-Lying Abduction w/ Band";
	public static final String SQUATS_W_BAND = "Squats w/ Band";
	public static final String LATERAL_WALK_W_BAND = "Lateral Walk w/ Band";
	public static final String STANDING_HURDLES_W_BAND = "Standing Hurdles w/ Band";
	public static final String JUMPS_180 = "180° Jumps";
	public static final String JUMPS_90_TO_1_FOOT_LANDING = "90° Jumps to 1 Foot Landing";


	// Public Static Fields
	public static Dictionary<String, Move> moves = new Hashtable<>();


	// Public Static Methods
	public static void generateMoves() {

		// Done
		{
			Move move = new Move(DONE, Category.NONE);
			Pose pose = move.pose1 = new Pose();

			Angle legAngle = Angle.S.add(6);

			pose.torso = new Torso(0, Leg.getHeight(legAngle) + Leg.thickness/2);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, legAngle);
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle.mirror());

			Angle armProximalAngle = new Angle(30);
			Angle armDistalAngle = new Angle(80);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, armProximalAngle, armDistalAngle);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armProximalAngle.mirror(), armDistalAngle.mirror());

			moves.put(move.name, move);
		}

		// Jumping Jacks
		{
			Move move = new Move(JUMPING_JACKS, Category.CARDIO);
			Pose pose = move.pose1 = new Pose();

			Angle legAngle = new Angle(-70);

			pose.torso = new Torso(0, Leg.getHeight(legAngle) + Leg.thickness/2);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, legAngle);
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle.mirror());

			Angle armProximalAngle = new Angle(30);
			Angle armDistalAngle = new Angle(60);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, armProximalAngle, armDistalAngle);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armProximalAngle.mirror(), armDistalAngle.mirror());

			moves.put(move.name, move);
		}


		// Behind the Back Grab
		{
			Move move = new Move(BEHIND_THE_BACK_GRAB, Category.YOGA);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.S);

			int proximalAngle = 34;
			int distalAngle = 14;
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(proximalAngle), Angle.S.add(-distalAngle));
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(-proximalAngle), Angle.N.add(distalAngle));

			moves.put(move.name, move);
		}

		// Touch Toes
		{
			Move move = new Move(TOUCH_TOES, Category.YOGA);
			Pose pose = move.pose1 = new Pose();

			Angle torsoAngle = Angle.S.add(45);
			pose.torso = new Torso(-Torso.getWidth(torsoAngle)/2, torsoAngle,true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S);

			moves.put(move.name, move);
		}

		// Down Dog
		{
			Move move = new Move(DOWN_DOG, Category.YOGA);
			Pose pose = move.pose1 = new Pose();

			Angle legAngle = Angle.S.add(-35);
			Angle torsoAngle = Angle.S.add(45);
			Angle armAngle = Angle.S.add(52);
			pose.torso = new Torso(-(Torso.getWidth(torsoAngle) + Arm.getWidth(armAngle) - Leg.getWidth(legAngle))/2, Leg.getHeight(legAngle) + Leg.thickness/2, torsoAngle,true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, legAngle);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, armAngle);

			moves.put(move.name, move);
		}


		// Wall Sit
		{
			Move move = new Move(WALL_SIT, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.prop = new Wall(pose.torso.waistX - Torso.thickness/2);

			moves.put(move.name, move);
		}

		// Squats
		{
			Move move = new Move(SQUATS, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.E);

			moves.put(move.name, move);
		}

		// Chair Dips
		{
			Move move = new Move(CHAIR_DIPS, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, new Angle(-140), Angle.S);

			final float chairX = pose.torso.waistX - Torso.thickness/2 - 2;
			final float chairSize = pose.rArm.handY - Arm.thickness/2;
			pose.prop = new Ledge(chairX, chairX - chairSize, chairSize);

			moves.put(move.name, move);
		}

		// Lunges
		{
			Move move = new Move(LUNGES, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(0, Leg.getHeight(Angle.E, Angle.S) + Leg.thickness/2, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E, Angle.S.add(-5));

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, Angle.S.add(-10), Angle.W);

			moves.put(move.name, move);
		}

		// Step-Ups
		{
			Move move = new Move(STEP_UPS, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(-Leg.getWidth(Angle.E, Angle.S)/2, Leg.getHeight() + Leg.thickness/2, true);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, Angle.S);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.E.add(-5), Angle.S);

			float stepSize = pose.rLeg.footY - Leg.thickness/2;
			pose.prop = new Ledge(pose.rLeg.footX - Leg.thickness/2, pose.rLeg.footX + stepSize, stepSize);

			moves.put(move.name, move);
		}

		// High Knees
		{
			Move move = new Move(HIGH_KNEES, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			Angle lLegProximalAngle = Angle.S.add(+10);
			Angle lLegDistalAngle = Angle.S.add(-10);
			Angle rLegAngle = Angle.E.add(10);

			pose.torso = new Torso(-Leg.getWidth(rLegAngle, Angle.S)/2, Leg.getHeight(lLegProximalAngle, lLegDistalAngle) + Leg.thickness/2, true);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, lLegProximalAngle, lLegDistalAngle);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, rLegAngle, Angle.S);

			moves.put(move.name, move);
		}


		// Push-ups
		{
			Move move = new Move(PUSH_UPS, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			Angle angle = new Angle(25);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.getHeight(angle) + Leg.thickness/2,
					angle,
					true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite());

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(15));

			moves.put(move.name, move);
		}

		// Plank
		{
			Move move = new Move(PLANK, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			Angle angle = new Angle(12);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.getHeight(angle) + Leg.thickness/2,
					angle,
					true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite());

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(15), Angle.E);

			moves.put(move.name, move);
		}

		// Push-Up & Rotate
		{
			Move move = new Move(PUSH_UP_ROTATE, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			Angle angle = new Angle(25);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.thickness/2 + Leg.getHeight(angle) + Torso.getHipHeight(angle),
					angle);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, angle.opposite());
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite().add(5));

			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(15));
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(15));

			moves.put(move.name, move);
		}

		// Side Plank
		{
			Move move = new Move(SIDE_PLANK, Category.LIFTING, true);
			Pose pose = move.pose1 = new Pose();

			Angle angle = new Angle(15);

			pose.torso = new Torso((Leg.getWidth(angle.opposite()) - Torso.getWidth(angle) - Torso.headSize)/2,
					Leg.thickness/2 + Leg.getHeight(angle) + Torso.getHipHeight(angle),
					angle);

			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY, angle.opposite());
			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, angle.opposite().add(5));

			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(15), Angle.W,Arm.segmentLength/3);
			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, angle.opposite().add(-1));

			moves.put(move.name, move);
		}


		// Crunches
		{
			Move move = new Move(CRUNCHES, Category.LIFTING);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso((Torso.getWidth(Angle.W) - Leg.getWidth(Angle.N, Angle.E))/2, Torso.thickness/2, Angle.W, true);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY, Angle.N, Angle.E);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.N.add(-30));

			moves.put(move.name, move);
		}

		// Lotus
		{
			Move move = new Move(LOTUS, Category.YOGA);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(0, Torso.thickness / 2);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY - Torso.thickness / 2, Angle.W.add(-20), Angle.E);
			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY - Torso.thickness / 2, Angle.E.add(20), Angle.W);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(-5), Angle.W.add(15), Arm.segmentLength * .9f);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(5), Angle.E.add(-15), Arm.segmentLength * .9f);

			moves.put(move.name, move);
		}

		// Rest
		{
			Move move = new Move(REST, Category.NONE);
			Pose pose = move.pose1 = new Pose();

			pose.torso = new Torso(0, Torso.thickness/2);

			pose.rLeg = new Leg(pose.torso.rHipX, pose.torso.rHipY - Torso.thickness/2, Angle.W.add(-20), Angle.E);
			pose.lLeg = new Leg(pose.torso.lHipX, pose.torso.lHipY - Torso.thickness/2, Angle.E.add(20), Angle.W);

			pose.rArm = new Arm(pose.torso.rShoulderX, pose.torso.rShoulderY, Angle.S.add(-5), Angle.W.add(15), Arm.segmentLength*.9f);
			pose.lArm = new Arm(pose.torso.lShoulderX, pose.torso.lShoulderY, Angle.S.add(5), Angle.E.add(-15), Arm.segmentLength*.9f);

			moves.put(move.name, move);
		}

		moves.put(ROTATE_ON_ALL_FOURS, new Move(ROTATE_ON_ALL_FOURS, Category.STRETCH, true));
		moves.put(TWIST_PIVOT, new Move(TWIST_PIVOT, Category.STRETCH));
		moves.put(SAFETY_JACKS, new Move(SAFETY_JACKS, "Jumping Jacks with cross-overs in front", Category.CARDIO));
		moves.put(ROMAN_LUNGES, new Move(ROMAN_LUNGES, Category.CARDIO));
		moves.put(HIP_STRETCH, new Move(HIP_STRETCH, Category.STRETCH, true));
		moves.put(HAMSTRING_STRETCH, new Move(HAMSTRING_STRETCH, Category.STRETCH, true));
		moves.put(HIP_HAMSTRING, new Move(HIP_HAMSTRING, Category.STRETCH, true));
		moves.put(LEG_SWINGS, new Move(LEG_SWINGS, Category.STRETCH, true));

		moves.put(WALKING_BACKWARD_LUNGES, new Move(WALKING_BACKWARD_LUNGES, Category.CARDIO));
		moves.put(FOAM_ROLLER, new Move(FOAM_ROLLER, Category.STRETCH));
		moves.put(THORACIC_ROLL_OUTS, new Move(THORACIC_ROLL_OUTS, Category.STRETCH, true));
		moves.put(INCH_WORMS, new Move(INCH_WORMS, Category.CARDIO));
		moves.put(SINGLE_LEG_BRIDGE, new Move(SINGLE_LEG_BRIDGE, Category.CARDIO));
		moves.put(SIDE_LYING_ABDUCTION_W_BAND, new Move(SIDE_LYING_ABDUCTION_W_BAND, Category.STRETCH, true));
		moves.put(SQUATS_W_BAND, new Move(SQUATS_W_BAND, Category.STRETCH));
		moves.put(LATERAL_WALK_W_BAND, new Move(LATERAL_WALK_W_BAND, Category.STRETCH));
		moves.put(STANDING_HURDLES_W_BAND, new Move(STANDING_HURDLES_W_BAND, Category.STRETCH));
		moves.put(JUMPS_180, new Move(JUMPS_180, Category.STRETCH));
		moves.put(JUMPS_90_TO_1_FOOT_LANDING, new Move(JUMPS_90_TO_1_FOOT_LANDING, Category.STRETCH));

	}

}
