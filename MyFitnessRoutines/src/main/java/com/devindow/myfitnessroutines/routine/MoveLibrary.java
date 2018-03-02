package com.devindow.myfitnessroutines.routine;

import com.devindow.myfitnessroutines.ladder.*;
import com.devindow.myfitnessroutines.pose.*;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Devin on 1/29/2018.
 */

public class MoveLibrary {

	// Constants
	// Standing Frontal Poses
	public static final String MOUNTAIN_POSE = "Mountain Pose";
	public static final String DONE = "Done!";
	public static final String REACH_BACK = "Reach Back";
	public static final String JUMPING_JACKS = "Jumping Jacks";
	public static final String STANDING_SIDE_BEND = "Standing Side Bend";
	public static final String JOG_LATERALLY = "Jog Laterally";
	public static final String SKIP = "Skip";
	public static final String LEG_SWINGS = "Leg Swings";
	public static final String WARRIOR_2 = "Warrior 2";
	public static final String ROMAN_LUNGES = "Roman Lunges";
	// Standing Profile Poses
	public static final String SAFETY_JACKS = "Safety Jacks";
	public static final String BEHIND_THE_BACK_GRAB = "Behind the Back Grab";
	public static final String FAST_FEET = "Fast Feet";
	public static final String HIGH_KNEES = "High Knees";
	public static final String STANDING_HURDLES_W_BAND = "Standing Hurdles w/ Band";
	public static final String LATERAL_WALK_W_BAND = "Lateral Walk w/ Band";
	public static final String TWIST_PIVOT = "Twist & Pivot";
	public static final String WARRIOR_3 = "Warrior 3";
	// Squatting Poses
	public static final String WALL_SIT = "Wall Sit";
	public static final String SQUATS = "Squats";
	public static final String SQUATS_W_BAND = "Squats w/ Band";
	public static final String CHAIR_DIPS = "Chair Dips";
	public static final String LUNGES = "Lunges";
	public static final String WALKING_BACKWARD_LUNGES = "Walking Backward Lunges";
	public static final String HIP_STRETCH = "Hip Stretch";
	public static final String HAMSTRING_STRETCH = "Hamstring Stretch";
	public static final String HIP_HAMSTRING = "Hip/Hamstring Stretch";
	public static final String STEP_UPS = "Step-Ups";
	public static final String JUMPS_180 = "180° Jumps";
	public static final String JUMPS_90_TO_1_FOOT_LANDING = "90° Jumps to 1 Foot Landing";
	// Back-Lying Poses
	public static final String KNEE_UP_CRUNCHES = "Knee-Up Crunches";
	public static final String LEG_UP_CRUNCHES = "Leg-Up Crunches";
	public static final String KNEE_BENT_CRUNCHES = "Knee-Bent Crunches";
	public static final String FROG_LEG_CRUNCHES = "Frog-Leg Crunches";
	public static final String HORSE_RIDING_CRUNCHES = "Horse-Riding Crunches";
	public static final String REVERSE_CRUNCHES = "Reverse Crunches";
	public static final String HIP_RAISES = "Hip Raises";
	public static final String CROSSOVER_CRUNCHES = "Cross-Over Crunches";
	public static final String CATCH_CRUNCHES = "Catch Crunches";
	public static final String SIDE_CRUNCHES = "Side Crunches";
	public static final String HEAD_TO_KNEES = "Head to Knees";
	public static final String RECLINED_HAMSTRING_W_STRAP = "Reclined Hamstring w/ Strap";
	public static final String BOAT_POSE = "Boat Pose";
	public static final String BRIDGE_POSE = "Bridge Pose";
	public static final String SINGLE_LEG_BRIDGES = "Single-Leg Bridges";
	public static final String SHOULDER_PRESS = "Shoulder Press";
	// Back-Lying Top View Poses
	public static final String CORPSE_POSE = "Corpse Pose";
	public static final String HEAD_TO_KNEES_TOPVIEW = "Head to Knees";
	public static final String THORACIC_ROLL_OUTS = "Thoracic Roll-outs";
	public static final String RECLINED_TWIST = "Reclined Twist";
	public static final String KNEE_CROSS_OVER = "Knee Cross-Over";
	public static final String HIP_OPEN = "Hip Open";
	public static final String RECLINED_COBBLER_POSE = "Reclined Cobbler Pose";
	// Bending Poses
	public static final String TOUCH_TOES = "Touch Toes";
	public static final String DOWN_DOG = "Down Dog";
	public static final String DOWN_DOG_ALTERNATING_CALVES = "Down Dog Alternating Calves";
	public static final String INCH_WORMS = "Inch Worms";
	public static final String WIDE_LEG_BEND = "Wide Leg Bend";
	// Prone Poses
	public static final String ROTATE_ON_ALL_FOURS = "Rotate on all fours";
	public static final String CAT_POSE = "Cat Pose";
	public static final String CHILD_POSE = "Child Pose";
	public static final String PUSH_UPS = "Push-Ups";
	public static final String PLANK = "Plank";
	public static final String PUSH_UP_ROTATE = "Push-Up & Rotate";
	public static final String SIDE_PLANK = "Side Plank";
	public static final String FOAM_ROLLER = "Foam Roller";
	public static final String SIDE_LYING_ABDUCTION_W_BAND = "Side-Lying Abduction w/ Band";
	public static final String LOCUST_POSE = "Locust Pose";
	// Sitting Poses
	public static final String LOTUS = "Lotus";
	public static final String REST = "Rest";
	public static final String COBBLER_POSE = "Cobbler Pose";
	public static final String SAGE_POSE = "Sage Pose";
	public static final String TWISTED_SAGE_POSE = "Twisted Sage Pose";

	// Ladder Moves
	public static final String LADDER_GRAPEVINE = "Grapevine";
	public static final String LADDER_SHUFFLE = "Shuffle";


	// Public Static Fields
	public static Dictionary<String, Move> moves = new Hashtable<>();


	// Public Static Methods
	public static void generateMoves() {
		generateStandingFrontalMoves();
		generateStandingProfileMoves();
		generateSquattingMoves();
		generateBackLyingMoves();
		generateBackLyingTopViewMoves();
		generateForwardBendingMoves();
		generateProneMoves();
		generateSittingMoves();

		generateLadderMoves();
	}

	private static void generateStandingFrontalMoves() {
		// Mountain Pose
		{
			MoveWithPose move = new MoveWithPose(MOUNTAIN_POSE, "Stand tall", Category.NONE);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(3);
			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2);

			move.pose.rArm = new Arm(Angle.S.add(-2));
			move.pose.lArm = new Arm(Angle.S.add(2));

			moves.put(move.name, move);
		}

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

		// Reach Back
		{
			MoveWithPose move = new MoveWithPose(REACH_BACK, Category.STRETCH, true);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(3);
			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2);

			Angle armProximalAngle = Angle.W.add(-30);
			Angle armDistalAngle = Angle.N.add(10);
			move.pose.rArm = new Arm(armProximalAngle, armDistalAngle);
			move.pose.lArm = new Arm(Angle.S.add(45), Angle.S.add(-45));

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

		// Standing Side Bend
		{
			MoveWithPose move = new MoveWithPose(STANDING_SIDE_BEND, Category.STRETCH, true);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(6);
			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			int torsoAngle = 15;
			move.pose.torso = new Torso(Angle.N.add(torsoAngle));

			move.pose.lArm = new Arm(Angle.N.add(torsoAngle-5), Angle.N.add(torsoAngle+25));
			move.pose.rArm = new Arm(Angle.S.add(torsoAngle-45), Angle.S.add(torsoAngle+45));

			moves.put(move.name, move);
		}

		// Jog Laterally
		{
			MoveWithPose move = new MoveWithPose(JOG_LATERALLY, "Jog while moving laterally", Category.CARDIO);
			move.pose = new Pose();

			move.pose.lLeg = new Leg();

			move.pose.torso = new Torso();

			move.pose.rLeg = new Leg(Angle.S.add(-45), 0.4f, Angle.S.add(0));

			move.pose.rArm = new Arm(Angle.S.add(-10), Angle.W.add(-10), 0.5f);

			move.pose.lArm = new Arm(Angle.S.add(30), Angle.W.add(30), 0.5f);

			moves.put(move.name, move);
		}

		// Skip
		{
			MoveWithPose move = new MoveWithPose(SKIP, Category.CARDIO);
			move.pose = new Pose();

			move.pose.lLeg = new Leg();

			move.pose.torso = new Torso();

			move.pose.rLeg = new Leg(Angle.S.add(-45), 0.4f, Angle.S.add(0));

			move.pose.rArm = new Arm(Angle.S.add(-10), Angle.W.add(-10), 0.5f);

			move.pose.lArm = new Arm(Angle.S.add(30), Angle.W.add(30), 0.5f);

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

		// Warrior 2
		{
			MoveWithPose move = new MoveWithPose(WARRIOR_2, Category.YOGA, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.W.add(15), Angle.S.add(5));
			move.pose.lLeg = new Leg(Angle.S.add(45), Angle.S.add(55));
			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2);

			move.pose.lArm = new Arm(Angle.E);
			move.pose.rArm = new Arm(Angle.W);

			moves.put(move.name, move);
		}
	}

	private static void generateStandingProfileMoves() {
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

		// Fast Feet
		{
			MoveWithPose move = new MoveWithPose(FAST_FEET, "Simulate full speed sprinting", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(10), Angle.S.add(-10));

			move.pose.rLeg = new Leg(Angle.S.add(35), Angle.S.add(-10));

			move.pose.torso = new Torso(true);

			moves.put(move.name, move);
		}

		// High Knees
		{
			MoveWithPose move = new MoveWithPose(HIGH_KNEES, Category.STRENGTH);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(10), Angle.S.add(-10));

			move.pose.rLeg = new Leg(Angle.E.add(10), Angle.S);

			move.pose.torso = new Torso(true);

			moves.put(move.name, move);
		}

		// Standing Hurdles w/ Band
		{
			MoveWithPose move = new MoveWithPose(STANDING_HURDLES_W_BAND, "Drive knee up with band around feet", Category.WARMUP, true);
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
			MoveWithPose move = new MoveWithPose(LATERAL_WALK_W_BAND, "Walk forwards & backwards in explosive cutting motion", Category.WARMUP, true);
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

		// Warrior 3
		{
			MoveWithPose move = new MoveWithPose(WARRIOR_3, "Leg straight back then knee up, repeat.", Category.YOGA, true);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(-15), Angle.S.add(15));

			move.pose.rLeg = new Leg(Angle.E.add(-5), Angle.E.add(5));

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2, Angle.W, true);

			move.pose.lArm = new Arm(Angle.W.add(20), Angle.W.add(-10));
			move.pose.rArm = new Arm(Angle.E.add(20), Angle.E.add(-10));

			moves.put(move.name, move);
		}
	}

	private static void generateSquattingMoves() {
		// Wall Sit
		{
			MoveWithPose move = new MoveWithPose(WALL_SIT, Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E, Angle.S);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, true);

			move.pose.prop = new Wall(-Torso.thickness / 2);

			moves.put(move.name, move);
		}

		// Squats
		{
			MoveWithPose move = new MoveWithPose(SQUATS, Category.STRENGTH);
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
			MoveWithPose move = new MoveWithPose(CHAIR_DIPS, Category.STRENGTH);
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
			MoveWithPose move = new MoveWithPose(LUNGES, Category.STRENGTH);
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
			MoveWithPose move = new MoveWithPose(STEP_UPS, Category.STRENGTH);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S);

			move.pose.rLeg = new Leg(Angle.E.add(-5), Angle.S);

			move.pose.torso = new Torso(true);

			float stepSize = move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY) - Leg.thickness / 2;
			move.pose.prop = new Ledge(move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) - Leg.thickness / 2, move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX) + stepSize, stepSize);

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

		// 180° Jumps
		{
			MoveWithPose move = new MoveWithPose(JUMPS_180, "Jump & Turn.", Category.CARDIO);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(30), Angle.S.add(-15));

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2, Angle.N.add(-30), true);

			move.pose.lArm = new Arm(Angle.S.add(10), Angle.S.add(25));

			moves.put(move.name, move);
		}

		// 90° Jumps to 1 Foot
		{
			MoveWithPose move = new MoveWithPose(JUMPS_90_TO_1_FOOT_LANDING, "Jump & Turn.", Category.CARDIO, true);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(30), Angle.S.add(-15));
			move.pose.rLeg = new Leg(Angle.S.add(30), Angle.W.add(25));

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2, Angle.N.add(-30), true);

			move.pose.lArm = new Arm(Angle.S.add(10), Angle.S.add(25));

			moves.put(move.name, move);
		}
	}

	private static void generateBackLyingMoves() {
		// Knee-Up Crunches
		{
			MoveWithPose move = new MoveWithPose(KNEE_UP_CRUNCHES, "Crunches with ", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Knee-Up Crunches
		{
			MoveWithPose move = new MoveWithPose(KNEE_UP_CRUNCHES, "Crunches with Knees up", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Leg-Up Crunches
		{
			MoveWithPose move = new MoveWithPose(LEG_UP_CRUNCHES, "Crunches with Legs up", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Knee-Bent Crunches
		{
			MoveWithPose move = new MoveWithPose(KNEE_BENT_CRUNCHES, "Crunches with Knees bent", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(-45), Angle.S.add(35));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Frog-Leg Crunches
		{
			MoveWithPose move = new MoveWithPose(FROG_LEG_CRUNCHES, "Crunches with Legs like a frog", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.E.add(25), Angle.E.add(-25));
			move.pose.rLeg = new Leg(Angle.E.add(-10), 0.9f, Angle.E.add(5), 0.9f);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Horse-Riding Crunches
		{
			MoveWithPose move = new MoveWithPose(HORSE_RIDING_CRUNCHES, "Crunches with Legs apart", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.E.add(20), Angle.E.add(-5));
			move.pose.rLeg = new Leg(Angle.E.add(-20), Angle.E.add(5));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Reverse Crunches
		{
			MoveWithPose move = new MoveWithPose(REVERSE_CRUNCHES, "Curl Hips towards Ribs", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(15), Angle.E.add(15));

			move.pose.torso = new Torso(Torso.thickness/2 + 3, Angle.W.add(5), true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Hip Raises
		{
			MoveWithPose move = new MoveWithPose(HIP_RAISES, "Lift Hips & Feet towards ceiling", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N);

			move.pose.torso = new Torso(Torso.thickness/2 + 3, Angle.W.add(5), true);

			move.pose.rArm = new Arm(Angle.E.add(-20), Angle.E);

			moves.put(move.name, move);
		}

		// Cross-Over Crunches
		{
			MoveWithPose move = new MoveWithPose(CROSSOVER_CRUNCHES, "Shoulder towards opposite Knee", Category.STRENGTH, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(-45), Angle.S.add(45));
			move.pose.lLeg = new Leg(Angle.N, .7f, Angle.E, 0.5f);

			int torsoAngle = 10;
			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W.add(-7));

			move.pose.lArm = new Arm(Angle.N.add(30-torsoAngle), Angle.S.add(-30-torsoAngle));
			move.pose.rArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}

		// Catch Crunches
		{
			MoveWithPose move = new MoveWithPose(CATCH_CRUNCHES, "Reach both Hands outside a Knee", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(-45), Angle.S.add(45));
			move.pose.lLeg = new Leg(Angle.N.add(-45), Angle.S.add(45));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W.add(-7));

			move.pose.lArm = new Arm(Angle.E.add(10), 0.9f);
			move.pose.rArm = new Arm(Angle.E.add(35));

			moves.put(move.name, move);
		}

		// Side Crunches
		{
			MoveWithPose move = new MoveWithPose(SIDE_CRUNCHES, "Lie on side, Ribs towards Hip", Category.STRENGTH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(-75), 0.7f, Angle.S.add(75), 0.7f);
			move.pose.lLeg = new Leg(Angle.N.add(-75), 0.7f, Angle.S.add(75), 0.7f);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W.add(-15));

			move.pose.lArm = new Arm(Angle.E.add(20), 0.5f, Angle.W.add(0));
			move.pose.rArm = new Arm(Angle.E.add(0), 0.5f, Angle.W.add(-10));

			moves.put(move.name, move);
		}

		// Head to Knees
		{
			MoveWithPose move = new MoveWithPose(HEAD_TO_KNEES, Category.YOGA);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(50), Angle.E);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);
			move.pose.torso.headX += 3;
			move.pose.torso.headY += 7;

			move.pose.rArm = new Arm(Angle.N.add(-30), .6f);

			moves.put(move.name, move);
		}

		// Reclined Hamstring w/ Strap
		{
			MoveWithPose move = new MoveWithPose(RECLINED_HAMSTRING_W_STRAP, "Bend knee then straighten", Category.STRETCH, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(10));
			move.pose.lLeg = new Leg(Angle.E.add(-3));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.E.add(30), Angle.N.add(-10));

			move.pose.prop = new Band(
					move.pose.rLeg.getDistalPointX(move.pose.torso.rHipX),
					move.pose.rLeg.getDistalPointY(move.pose.torso.rHipY) + Leg.thickness / 2,
					move.pose.rArm.getDistalPointX(move.pose.torso.rShoulderX),
					move.pose.rArm.getDistalPointY(move.pose.torso.rShoulderY));

			moves.put(move.name, move);
		}

		// Boat Pose
		{
			MoveWithPose move = new MoveWithPose(BOAT_POSE, "Body & legs in a V", Category.YOGA);
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.E.add(25));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W.add(-35), true);
			move.pose.torso.headX += 6;
			move.pose.torso.headY += 4;

			move.pose.rArm = new Arm(Angle.E.add(5));

			moves.put(move.name, move);
		}

		// Bridge Pose
		{
			MoveWithPose move = new MoveWithPose(BRIDGE_POSE, Category.YOGA);
			move.pose = new Pose();

			Angle angle = Angle.E.add(-24);

			move.pose.lLeg = new Leg(angle.opposite(), Angle.S);

			move.pose.torso = new Torso(
					move.pose.lLeg.getHeight() + Leg.thickness / 2,
					angle,
					true);
			move.pose.torso.headX += 1;
			move.pose.torso.headY += 4;

			move.pose.rArm = new Arm(Angle.W.add(5));

			moves.put(move.name, move);
		}

		// Single-Leg Bridges
		{
			MoveWithPose move = new MoveWithPose(SINGLE_LEG_BRIDGES, "Drive leg up, hold, repeat.", Category.WARMUP, true);
			move.pose = new Pose();

			Angle angle = Angle.E.add(-24);

			move.pose.lLeg = new Leg(angle.opposite(), Angle.S);
			move.pose.rLeg = new Leg(angle.add(90), angle.opposite());

			move.pose.torso = new Torso(
					move.pose.lLeg.getHeight() + Leg.thickness / 2,
					angle,
					true);
			move.pose.torso.headX += 1;
			move.pose.torso.headY += 4;

			move.pose.rArm = new Arm(Angle.W.add(5));

			moves.put(move.name, move);
		}

		// Shoulder Press
		{
			MoveWithPose move = new MoveWithPose(SHOULDER_PRESS, Category.YOGA);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N);

			move.pose.torso = new Torso(Torso.length + Torso.thickness/2 + 2, Angle.S.add(-5),true);
			move.pose.torso.headX -= Torso.thickness/2 + Torso.headSize/2 - 2;
			move.pose.torso.headY += Torso.headSize - 2;

			move.pose.rArm = new Arm(Angle.E.add(-25), Angle.N.add(25));

			moves.put(move.name, move);
		}
	}

	private static void generateBackLyingTopViewMoves() {
		final float waistY = 46;

		// Corpse Pose
		{
			MoveWithPose move = new MoveWithPose(CORPSE_POSE, "Lie on your back. Relax. Breathe.", Category.YOGA);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			Angle legAngle = Angle.S.add(6);

			move.pose.lLeg = new Leg(legAngle);
			move.pose.rLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			Angle armProximalAngle = Angle.S.add(-10);
			move.pose.rArm = new Arm(armProximalAngle, Angle.S);
			move.pose.lArm = new Arm(armProximalAngle.mirror(), Angle.S);

			moves.put(move.name, move);
		}

		// Head to Knees Top View
		{
			MoveWithPose move = new MoveWithPose(HEAD_TO_KNEES_TOPVIEW, Category.YOGA);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			Angle legProximalAngle = Angle.N.add(20);
			float legProximalRatio = .8f;
			Angle legDistalAngle = Angle.S.add(10);
			move.pose.rLeg = new Leg(legProximalAngle, legProximalRatio, legDistalAngle);
			move.pose.lLeg = new Leg(legProximalAngle.mirror(), legProximalRatio, legDistalAngle.mirror());

			move.pose.torso = new Torso(waistY);
			move.pose.torso.headY -= 3;
			move.pose.torso.mat = true;

			Angle armProximalAngle = Angle.S.add(-20);
			float armProximalRatio = .5f;
			move.pose.rArm = new Arm(armProximalAngle, armProximalRatio);
			move.pose.lArm = new Arm(armProximalAngle.mirror(), armProximalRatio);

			moves.put(move.name, move);
		}

		// Thoracic Roll-outs
		{
			MoveWithPose move = new MoveWithPose(THORACIC_ROLL_OUTS, "Lie on side, roll arms out then back", Category.YOGA, true);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			move.pose.lLeg = new Leg(Angle.W.add(-10), Angle.S.add(10));
			//move.pose.rLeg = new Leg(Angle.W.add(15), Angle.S);

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			move.pose.rArm = new Arm(Angle.W);
			move.pose.lArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}

		// Reclined Twist
		{
			MoveWithPose move = new MoveWithPose(RECLINED_TWIST, "Knees across body a few inches off the ground", Category.YOGA, true);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			move.pose.lLeg = new Leg(Angle.W.add(-10), Angle.S.add(10));
			//move.pose.rLeg = new Leg(Angle.W.add(15), Angle.S);

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			move.pose.rArm = new Arm(Angle.W);
			move.pose.lArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}

		// Knee Cross-Over
		{
			MoveWithPose move = new MoveWithPose(KNEE_CROSS_OVER, "Knee across body", Category.YOGA, true);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			move.pose.rLeg = new Leg(Angle.S);
			move.pose.lLeg = new Leg(Angle.W.add(-10), Angle.S.add(10));

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			move.pose.rArm = new Arm(Angle.W.add(55));
			move.pose.lArm = new Arm(Angle.E);

			moves.put(move.name, move);
		}

		// Hip Open
		{
			MoveWithPose move = new MoveWithPose(HIP_OPEN, "Hip opened up", Category.YOGA, true);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			move.pose.rLeg = new Leg(Angle.S);
			move.pose.lLeg = new Leg(Angle.E.add(10), Angle.S.add(0));

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			move.pose.rArm = new Arm(Angle.W);
			move.pose.lArm = new Arm(Angle.E.add(-40));

			moves.put(move.name, move);
		}

		// Reclined Cobbler Pose
		{
			MoveWithPose move = new MoveWithPose(RECLINED_COBBLER_POSE, "Legs open, feet together. Press legs to extend spine.", Category.YOGA);
			move.pose = new Pose();
			move.pose.centerExtents = false;

			move.pose.rLeg = new Leg(Angle.S.add(-40), Angle.S.add((40)));
			move.pose.lLeg = new Leg(Angle.S.add(40), Angle.S.add(-40));

			move.pose.torso = new Torso(waistY);
			move.pose.torso.mat = true;

			move.pose.rArm = new Arm(Angle.S.add(-4));
			move.pose.lArm = new Arm(Angle.S.add(4));

			moves.put(move.name, move);
		}
	}

	private static void generateForwardBendingMoves() {
		// Touch Toes
		{
			MoveWithPose move = new MoveWithPose(TOUCH_TOES, Category.STRETCH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S);

			Angle torsoAngle = Angle.S.add(45);
			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness/2,
					torsoAngle,
					true);
			move.pose.torso.headX -= 6;
			move.pose.torso.headY -= 3;

			move.pose.rArm = new Arm(Angle.S.add(-20), .92f);

			moves.put(move.name, move);
		}

		// Down Dog
		{
			MoveWithPose move = new MoveWithPose(DOWN_DOG, Category.YOGA);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S.add(-35));

			move.pose.rArm = new Arm(Angle.S.add(52));

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness / 2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					true);

			moves.put(move.name, move);
		}

		// Down Dog Alternating Calves
		{
			MoveWithPose move = new MoveWithPose(DOWN_DOG_ALTERNATING_CALVES, Category.YOGA);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S.add(-35));
			move.pose.lLeg = new Leg(Angle.S.add(5), Angle.S.add(-60));

			move.pose.rArm = new Arm(Angle.S.add(52));

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness / 2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					true);

			moves.put(move.name, move);
		}

		// Inch Worms
		{
			MoveWithPose move = new MoveWithPose(INCH_WORMS, "Walk hands to push-up, then walk feet to hands", Category.YOGA);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S.add(-35));

			move.pose.lArm = new Arm(Angle.S.add(-10));
			move.pose.rArm = new Arm(Angle.S.add(30));

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness / 2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.lArm.getHeight() + Arm.thickness/2, Torso.length),
					true);

			moves.put(move.name, move);
		}

		// Wide Leg Bend
		{
			MoveWithPose move = new MoveWithPose(WIDE_LEG_BEND, Category.STRETCH);
			move.pose = new Pose();

			Angle legAngle = Angle.S.add(20);
			move.pose.rLeg = new Leg(legAngle);
			move.pose.lLeg = new Leg(legAngle.mirror());

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness/2, 0.5f, Angle.S);

			move.pose.lArm = new Arm(Angle.S.add(-5));
			move.pose.rArm = new Arm(Angle.S.add(5));

			moves.put(move.name, move);
		}
	}

	private static void generateProneMoves() {
		// Rotate on all fours
		{
			MoveWithPose move = new MoveWithPose(ROTATE_ON_ALL_FOURS, Category.STRETCH, true);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S, Angle.W);

			move.pose.rArm = new Arm(Angle.S.add(8), .9f);

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness/2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					true);

			moves.put(move.name, move);
		}

		// Cat Pose
		{
			MoveWithPose move = new MoveWithPose(CAT_POSE, Category.STRETCH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.S, Angle.W);

			move.pose.rArm = new Arm(Angle.S.add(8), .9f);

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness/2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					true);

			moves.put(move.name, move);
		}

		// Child Pose
		{
			MoveWithPose move = new MoveWithPose(CHILD_POSE, Category.STRETCH);
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.E.add(-30), Angle.W);

			move.pose.rArm = new Arm(Angle.E.add(-15), Angle.E);

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness/2,
					new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					true);
			//move.pose.torso.headX += 1;
			move.pose.torso.headY += 4;


			moves.put(move.name, move);
		}

		// Push-ups
		{
			MoveWithPose move = new MoveWithPose(PUSH_UPS, Category.STRENGTH);
			move.pose = new Pose();

			Angle angle = new Angle(25);

			move.pose.rLeg = new Leg(angle.opposite());

			move.pose.rArm = new Arm(Angle.S.add(15));

			move.pose.torso = new Torso(
					move.pose.rLeg.getHeight() + Leg.thickness / 2,
					//new Angle(move.pose.rLeg.getHeight() + Leg.thickness/2, move.pose.rArm.getHeight() + Arm.thickness/2, Torso.length),
					angle,
					true);

			moves.put(move.name, move);
		}

		// Plank
		{
			MoveWithPose move = new MoveWithPose(PLANK, Category.STRENGTH);
			move.pose = new Pose();

			Angle angle = new Angle(12);

			move.pose.rLeg = new Leg(angle.opposite());

			move.pose.rArm = new Arm(Angle.S.add(15), Angle.E);

			move.pose.torso = new Torso(move.pose.rLeg.getHeight() + Leg.thickness / 2, angle, true);

			moves.put(move.name, move);
		}

		// Push-Up & Rotate
		{
			MoveWithPose move = new MoveWithPose(PUSH_UP_ROTATE, Category.STRENGTH);
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
			MoveWithPose move = new MoveWithPose(SIDE_PLANK, Category.STRENGTH, true);
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
			MoveWithPose move = new MoveWithPose(FOAM_ROLLER, "Iron out the tightness.", Category.WARMUP, true);
			move.pose = new Pose();

			Angle angle = new Angle(17);

			move.pose.lLeg = new Leg(angle.opposite());
			move.pose.rLeg = new Leg(Angle.W.add(-10), Angle.S.add(-10));

			move.pose.torso = new Torso(Leg.thickness / 2 + move.pose.lLeg.getHeight() + Torso.getHipHeight(angle), angle);

			move.pose.lArm = new Arm(Angle.S.add(15), Angle.W, .3f);

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

		// Locust Pose
		{
			MoveWithPose move = new MoveWithPose(LOCUST_POSE,"On Belly. Lift legs & chest.", Category.YOGA);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.E.add(8), true);
			move.pose.torso.headX -= 2;
			move.pose.torso.headY += 4;

			move.pose.rLeg = new Leg(Angle.W.add(-10), Angle.W.add(-20));

			move.pose.rArm = new Arm(Angle.W.add(-15), Angle.W.add(-5));

			moves.put(move.name, move);
		}
	}

	private static void generateSittingMoves() {
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

		// Cobbler Pose
		{
			MoveWithPose move = new MoveWithPose(COBBLER_POSE, "Sit. Butterfly.", Category.YOGA);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2);

			move.pose.rLeg = new Leg(Angle.W.add(-10), .8f, Angle.E.add(-20), .8f);
			move.pose.lLeg = new Leg(Angle.E.add(10), .8f, Angle.W.add(20), .8f);

			move.pose.rArm = new Arm(Angle.S.add(5));
			move.pose.lArm = new Arm(Angle.S.add(-5));

			moves.put(move.name, move);
		}

		// Sage Pose
		{
			MoveWithPose move = new MoveWithPose(SAGE_POSE, "Sit Tall. Legs together.", Category.YOGA);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2 - 2, true);

			move.pose.lLeg = new Leg(Angle.E);

			moves.put(move.name, move);
		}

		// Twisted Sage Pose
		{
			MoveWithPose move = new MoveWithPose(TWISTED_SAGE_POSE, "Sit Tall. Pretzel.", Category.YOGA, true);
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2 - 2);

			move.pose.lLeg = new Leg(Angle.E);
			move.pose.rLeg = new Leg(Angle.N.add(-40), Angle.S.add(10));

			move.pose.rArm = new Arm(Angle.S.add(-25));
			move.pose.lArm = new Arm(Angle.S.add(20), Angle.N.add(-10));

			moves.put(move.name, move);
		}
	}


	private static void generateLadderMoves() {
		// Grapevine
		{
			LadderMove move = new LadderMove(LADDER_GRAPEVINE, Category.AGILITY);

			move.steps.add(new Step(Ladder.getLocation(0, false, true), 1, 1));

			move.steps.add(new Step(Feet.RIGHT, Ladder.getLocation(1, true)));
			move.steps.add(new Step(Feet.LEFT, Ladder.getLocation(1, false, false), -1, -1));
			move.steps.add(new Step(Feet.RIGHT, Ladder.getLocation(1, false, false), 1, 1));

			move.steps.add(new Step(Feet.LEFT, Ladder.getLocation(2, true)));
			move.steps.add(new Step(Feet.RIGHT, Ladder.getLocation(2, false, true), 1, -1));
			move.steps.add(new Step(Feet.RIGHT, Ladder.getLocation(2, false, true), -1, 1));

			moves.put(move.name, move);
		}

		// Shuffle
		{
			LadderMove move = new LadderMove(LADDER_SHUFFLE, Category.AGILITY);

			moves.put(move.name, move);
		}
	}

}
