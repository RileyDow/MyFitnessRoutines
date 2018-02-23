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
	public static final String CORPSE_POSE = "Corpse Pose";


	// Public Static Fields
	public static Dictionary<String, Move> moves = new Hashtable<>();


	// Public Static Methods
	public static void generateMoves() {
		getStandingPoses();
		getBackLyingPoses();
		getBendingPoses();
		getSquattingPoses();
		getPronePoses();
		getSittingPoses();

		moves.put(JUMPS_180, new MoveWithPose(JUMPS_180, Category.STRETCH));
		moves.put(JUMPS_90_TO_1_FOOT_LANDING, new MoveWithPose(JUMPS_90_TO_1_FOOT_LANDING, Category.STRETCH));
	}

	private static void getStandingPoses() {
		// Done
		{
			MoveWithPose move = new MoveWithPose(DONE, Category.NONE);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(6);

			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2);

			Angle armProximalAngle = Angle.W.add(-30);
			Angle armDistalAngle = Angle.N.add(10);
			move.pose.rArm = new Arm(armProximalAngle, armDistalAngle);
			move.pose.lArm = new Arm(armProximalAngle.mirror(), armDistalAngle.mirror());

			moves.put(move.name, move);
		}

		// Jumping Jacks
		{
			MoveWithPose move = new MoveWithPose(JUMPING_JACKS, Category.CARDIO);
			move.pose = new Pose();

			Angle legAngle = new Angle(-70);

			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2);

			Angle armProximalAngle = new Angle(30);
			Angle armDistalAngle = new Angle(60);
			move.pose.lArm = new Arm(armProximalAngle, armDistalAngle);
			move.pose.rArm = new Arm(armProximalAngle.mirror(), armDistalAngle.mirror());

			moves.put(move.name, move);
		}

		// Safety Jacks
		{
			MoveWithPose move = new MoveWithPose(SAFETY_JACKS, "Jumping Jacks with cross-overs in front", Category.CARDIO);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S, .97f);
			move.pose.lLeg = new Leg(Angle.S.add(23), Angle.S);

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.lArm = new Arm(Angle.E.add(7));
			move.pose.rArm = new Arm(Angle.E.add(-8));

			moves.put(move.name, move);
		}

		// Behind the Back Grab
		{
			MoveWithPose move = new MoveWithPose(BEHIND_THE_BACK_GRAB, Category.YOGA);
			move.pose = new Pose();

			move.pose.torso = new Torso(true);

			move.pose.rLeg = new Leg(Angle.S);

			int proximalAngle = 34;
			int distalAngle = 14;
			move.pose.rArm = new Arm(Angle.N.add(proximalAngle), Angle.S.add(-distalAngle));
			move.pose.lArm = new Arm(Angle.S.add(-proximalAngle), Angle.N.add(distalAngle));

			moves.put(move.name, move);
		}

		// High Knees
		{
			MoveWithPose move = new MoveWithPose(HIGH_KNEES, Category.LIFTING);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(+10), Angle.S.add(-10));

			move.pose.rLeg = new Leg(Angle.E.add(10), Angle.S);

			move.pose.torso = new Torso(true);

			moves.put(move.name, move);
		}

		// Standing Hurdles w/ Band
		{
			MoveWithPose move = new MoveWithPose(STANDING_HURDLES_W_BAND, "Drive knee up with band around feet", Category.WARMUP);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(+10), Angle.S.add(-10));
			move.pose.rLeg = new Leg(Angle.E.add(10), Angle.S);

			move.pose.torso = new Torso(true);

			move.pose.prop = new Band(
					move.pose.lLeg.getDistalPointX(move.pose.torso.lHipX) - Band.thickness/2,
					move.pose.lLeg.getDistalPointY(move.pose.torso.lHipY),
					move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) + Band.thickness/2,
					move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY));

			moves.put(move.name, move);
		}

		// Lateral Walk w/ Band
		{
			MoveWithPose move = new MoveWithPose(LATERAL_WALK_W_BAND, "Walk forwards & backwards in explosive cutting motion", Category.WARMUP);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S.add(-10), Angle.S.add(-20));
			move.pose.lLeg = new Leg(Angle.S.add(30));

			move.pose.torso = new Torso(Angle.N.add(-10), true);

			move.pose.prop = new Band(
					move.pose.lLeg.getDistalPointX(move.pose.torso.lHipX) + Band.thickness/2,
					move.pose.lLeg.getDistalPointY(move.pose.torso.lHipY),
					move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) - Band.thickness/2,
					move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY));

			moves.put(move.name, move);
		}

		// Leg Swings
		{
			MoveWithPose move = new MoveWithPose(LEG_SWINGS, Category.CARDIO, true);
			move.pose = new Pose();

			move.pose.lLeg = new Leg();

			move.pose.torso = new Torso();

			move.pose.rLeg = new Leg(Angle.E.add(-10), Angle.E.add(-20));

			move.pose.rArm = new Arm(Angle.W.add(5));

			move.pose.lArm = new Arm(Angle.E.add(-15), Angle.E.add(-35));

			moves.put(move.name, move);
		}
	}

	private static void getBackLyingPoses() {
		// Crunches
		{
			MoveWithPose move = new MoveWithPose(CRUNCHES, Category.LIFTING);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness/2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(-30));

			moves.put(move.name, move);
		}

		// Single-Leg Bridges
		{
			MoveWithPose move = new MoveWithPose(SINGLE_LEG_BRIDGE, Category.WARMUP);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness/2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(-30));

			moves.put(move.name, move);
		}

		// Corpse Pose
		{
			MoveWithPose move = new MoveWithPose(CORPSE_POSE, "Lie on your back. Relax. Breathe.", Category.YOGA);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(6);

			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + 12);

			Angle armProximalAngle = Angle.S.add(-10);
			move.pose.rArm = new Arm(armProximalAngle, Angle.S);
			move.pose.lArm = new Arm(armProximalAngle.mirror(), Angle.S);

			moves.put(move.name, move);
		}

		// Thoracic Roll-outs
		{
			MoveWithPose move = new MoveWithPose(THORACIC_ROLL_OUTS, "Lie on side, roll arms out then back", Category.YOGA, true);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.W.add(-10), Angle.S.add(10));
			move.pose.rLeg = new Leg(Angle.W.add(15), Angle.S);

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + 20);

			move.pose.rArm = new Arm(Angle.W);
			move.pose.lArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}
	}

	private static void getBendingPoses() {
		// Touch Toes
		{
			MoveWithPose move = new MoveWithPose(TOUCH_TOES, Category.STRETCH);
			move.pose = new Pose();

			Angle torsoAngle = Angle.S.add(45);
			move.pose.torso = new Torso(-Torso.getWidth(torsoAngle) / 2, torsoAngle, true);

			move.pose.rLeg = new Leg(Angle.S);

			move.pose.rArm = new Arm(Angle.S);

			moves.put(move.name, move);
		}

		// Down Dog
		{
			MoveWithPose move = new MoveWithPose(DOWN_DOG, Category.YOGA);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(-35);
			Angle torsoAngle = Angle.S.add(45);
			Angle armAngle = Angle.S.add(52);

			move.pose.rLeg = new Leg(legAngle);

			move.pose.rArm = new Arm(armAngle);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, torsoAngle, true);

			moves.put(move.name, move);
		}

		// Inch Worms
		{
			MoveWithPose move = new MoveWithPose(INCH_WORMS, Category.YOGA);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(-35);
			Angle torsoAngle = Angle.S.add(45);
			Angle armAngle = Angle.S.add(52);

			move.pose.rLeg = new Leg(legAngle);

			move.pose.rArm = new Arm(armAngle);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, torsoAngle, true);

			moves.put(move.name, move);
		}
	}

	private static void getSquattingPoses() {
		// Wall Sit
		{
			MoveWithPose move = new MoveWithPose(WALL_SIT, Category.LIFTING);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.prop = new Wall(-Torso.thickness / 2);

			moves.put(move.name, move);
		}

		// Squats
		{
			MoveWithPose move = new MoveWithPose(SQUATS, Category.LIFTING);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.rArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}

		// Squats w/ Band
		{
			MoveWithPose move = new MoveWithPose(SQUATS_W_BAND, Category.WARMUP);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.rArm = new Arm(Angle.E);

			move.pose.prop = new Band(
					move.pose.rLeg.getProximalPointX(move.pose.torso.rHipX) - Leg.thickness / 2,
					move.pose.rLeg.getProximalPointY(move.pose.torso.rHipY) - Leg.thickness,
					move.pose.rLeg.getProximalPointX(move.pose.torso.rHipX) + Leg.thickness / 2,
					move.pose.rLeg.getProximalPointY(move.pose.torso.rHipY) - Leg.thickness);

			moves.put(move.name, move);
		}

		// Chair Dips
		{
			MoveWithPose move = new MoveWithPose(CHAIR_DIPS, Category.LIFTING);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.rArm = new Arm(new Angle(-140), Angle.S);

			final float chairX = -Torso.thickness / 2 - 2;
			final float chairSize = move.pose.rArm.getDistalPointY(move.pose.torso.rShoulderY) - Arm.thickness / 2;
			move.pose.prop = new Ledge(chairX, chairX - chairSize, chairSize);

			moves.put(move.name, move);
		}

		// Lunges
		{
			MoveWithPose move = new MoveWithPose(LUNGES, Category.LIFTING);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S.add(-5));
			move.pose.lLeg = new Leg(Angle.S.add(-10), Angle.W);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			moves.put(move.name, move);
		}

		// Walking Backward Lunges
		{
			MoveWithPose move = new MoveWithPose(WALKING_BACKWARD_LUNGES, "Step back, reach back with opposite arm", Category.WARMUP);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.W, Angle.S);
			move.pose.lLeg = new Leg(Angle.S.add(10), Angle.E);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, Angle.N.add(-10), true);

			move.pose.lArm = new Arm(Angle.S.add(30), 1.2f);
			move.pose.rArm = new Arm(Angle.N.add(10));

			moves.put(move.name, move);
		}

		// Hip Stretch
		{
			MoveWithPose move = new MoveWithPose(HIP_STRETCH, Category.STRETCH, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S.add(-25), .9f);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.lLeg = new Leg(Angle.S.add(-45), 1.1f, Angle.W);

			moves.put(move.name, move);
		}

		// Hip/Hamstring Stretch
		{
			MoveWithPose move = new MoveWithPose(HIP_HAMSTRING, "Stretch Hip then straighten for Hamstring", Category.STRETCH, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S.add(-25), .9f);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.lLeg = new Leg(Angle.S.add(-45), 1.1f, Angle.W);

			moves.put(move.name, move);
		}

		moves.put(HAMSTRING_STRETCH, new MoveWithPose(HAMSTRING_STRETCH, Category.STRETCH, true));

		// Step-Ups
		{
			MoveWithPose move = new MoveWithPose(STEP_UPS, Category.LIFTING);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S);

			move.pose.rLeg = new Leg(Angle.E.add(-5), Angle.S);

			move.pose.torso = new Torso(true);

			float stepSize = move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY) - Leg.thickness / 2;
			move.pose.prop = new Ledge(move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) - Leg.thickness / 2, move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) + stepSize, stepSize);

			moves.put(move.name, move);
		}


		// Twist & Pivot
		{
			MoveWithPose move = new MoveWithPose(TWIST_PIVOT, "Twist while stepping out", Category.CARDIO);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S.add(-15), Angle.S.add(15));

			move.pose.lLeg = new Leg(Angle.S.add(25), Angle.S.add(35), 1.2f);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.lArm = new Arm(Angle.W.add(20), .9f, Angle.W.add(-10), .9f);
			move.pose.rArm = new Arm(Angle.W.add(-20), .9f, Angle.W.add(10), .9f);

			moves.put(move.name, move);
		}

		// Roman Lunges
		{
			MoveWithPose move = new MoveWithPose(ROMAN_LUNGES, "Opposite Arm & Leg go back", Category.CARDIO);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(-50), Angle.S.add(10));

			move.pose.rLeg = new Leg(Angle.S.add(36), Angle.S.add(50), 1.2f);

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2);

			move.pose.lArm = new Arm(Angle.E);
			move.pose.rArm = new Arm(Angle.W);

			moves.put(move.name, move);
		}
	}

	private static void getPronePoses() {
		// Rotate on all fours
		{
			MoveWithPose move = new MoveWithPose(ROTATE_ON_ALL_FOURS, Category.STRETCH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S, Angle.W);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness/2, Angle.E.add(8), true);

			move.pose.rArm = new Arm(Angle.S.add(8), .9f);

			moves.put(move.name, move);
		}

		// Push-ups
		{
			MoveWithPose move = new MoveWithPose(PUSH_UPS, Category.LIFTING);
			move.pose = new Pose();

			Angle angle = new Angle(25);

			move.pose.rLeg = new Leg(angle.opposite());

			move.pose.rArm = new Arm(Angle.S.add(15));

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, angle, true);

			moves.put(move.name, move);
		}

		// Plank
		{
			MoveWithPose move = new MoveWithPose(PLANK, Category.LIFTING);
			move.pose = new Pose();

			Angle angle = new Angle(12);

			move.pose.rLeg = new Leg(angle.opposite());

			move.pose.rArm = new Arm(Angle.S.add(15), Angle.E);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, angle, true);

			moves.put(move.name, move);
		}

		// Push-Up & Rotate
		{
			MoveWithPose move = new MoveWithPose(PUSH_UP_ROTATE, Category.LIFTING);
			move.pose = new Pose();

			Angle angle = new Angle(31);

			move.pose.lLeg = new Leg(angle.opposite());
			move.pose.rLeg = new Leg(angle.opposite().add(6));

			move.pose.torso = new Torso(Leg.thickness / 2 + move.pose.lLeg.getHeight() + Torso.getHipHeight(angle), angle);

			move.pose.lArm = new Arm(Angle.S.add(15));
			move.pose.rArm = new Arm(Angle.N.add(15));

			moves.put(move.name, move);
		}

		// Side Plank
		{
			MoveWithPose move = new MoveWithPose(SIDE_PLANK, Category.LIFTING, true);
			move.pose = new Pose();

			Angle angle = new Angle(17);

			move.pose.lLeg = new Leg(angle.opposite());
			move.pose.rLeg = new Leg(angle.opposite().add(6));

			move.pose.torso = new Torso(Leg.thickness / 2 + move.pose.lLeg.getHeight() + Torso.getHipHeight(angle), angle);

			move.pose.lArm = new Arm(Angle.S.add(15), Angle.W, .3f);
			move.pose.rArm = new Arm(angle.opposite().add(-1));

			moves.put(move.name, move);
		}

		// Foam Roller
		{
			MoveWithPose move = new MoveWithPose(FOAM_ROLLER, Category.WARMUP, true);
			move.pose = new Pose();

			Angle angle = new Angle(17);

			move.pose.lLeg = new Leg(angle.opposite());
			move.pose.rLeg = new Leg(Angle.W.add(-10), Angle.S.add(-10));

			move.pose.torso = new Torso(Leg.thickness / 2 + move.pose.lLeg.getHeight() + Torso.getHipHeight(angle), angle);

			move.pose.lArm = new Arm(Angle.S.add(15), Angle.W, .3f);
			move.pose.rArm = new Arm(Angle.S.add(-5), 1.1f);

			move.pose.prop = new Roller(-6, Roller.diameter / 2);

			moves.put(move.name, move);
		}

		// Side-lying Abduction w/ Band
		{
			MoveWithPose move = new MoveWithPose(SIDE_LYING_ABDUCTION_W_BAND, Category.WARMUP, true);
			move.pose = new Pose();

			Angle angle = new Angle(17);

			move.pose.lLeg = new Leg(Angle.W);
			move.pose.rLeg = new Leg(Angle.W.add(-20));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.E);

			move.pose.prop = new Band(
					move.pose.lLeg.getDistalPointX(move.pose.torso.lHipX),
					move.pose.lLeg.getDistalPointY(move.pose.torso.lHipY - Band.thickness / 2),
					move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX),
					move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY + Band.thickness / 2));

			moves.put(move.name, move);
		}
	}

	private static void getSittingPoses() {
		// Lotus
		{
			MoveWithPose move = new MoveWithPose(LOTUS, "Breathe.", Category.YOGA);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2);

			move.pose.rLeg = new Leg(Angle.W.add(-10), .8f, Angle.E.add(-20), .8f);
			move.pose.lLeg = new Leg(Angle.E.add(10), .8f, Angle.W.add(20), .8f);

			move.pose.rArm = new Arm(Angle.S.add(-5), Angle.W.add(15), .8f);
			move.pose.lArm = new Arm(Angle.S.add(5), Angle.E.add(-15), .8f);

			moves.put(move.name, move);
		}

		// Rest
		{
			MoveWithPose move = new MoveWithPose(REST, "Breathe.", Category.NONE);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2);

			move.pose.rLeg = new Leg(Angle.W.add(-10), .8f, Angle.E.add(-20), .8f);
			move.pose.lLeg = new Leg(Angle.E.add(10), .8f, Angle.W.add(20), .8f);

			move.pose.rArm = new Arm(Angle.S.add(-5), Angle.W.add(15), .8f);
			move.pose.lArm = new Arm(Angle.S.add(5), Angle.E.add(-15), .8f);

			moves.put(move.name, move);
		}
	}

}
