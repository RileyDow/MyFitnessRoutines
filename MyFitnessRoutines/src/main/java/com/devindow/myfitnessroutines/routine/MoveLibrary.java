package com.devindow.myfitnessroutines.routine;

import android.graphics.Color;

import com.devindow.myfitnessroutines.ladder.*;
import com.devindow.myfitnessroutines.pose.*;
import com.devindow.myfitnessroutines.util.*;

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
	public static final String LADDER_SPRINT = "Sprint";
	public static final String LADDER_LATERAL = "Lateral";
	public static final String LADDER_LATERAL_IN_OUT = "Lateral In/Out";
	public static final String LADDER_JUMPING_JACK = "Jumping Jack";
	public static final String LADDER_CROSS_BEHIND = "Cross-Behind";
	public static final String LADDER_SHUFFLE = "Shuffle";
	public static final String LADDER_HOPSCOTCH = "Hopscotch";
	public static final String LADDER_SLALOM = "Slalom";

	// Soccer Moves
	public static final String SOCCER_INSIDE_ROLLS = "Inside Rolls";
	public static final String SOCCER_BELLS = "Bells";
	public static final String SOCCER_PULL_OPEN_OUTWARD = "Pull & Open Outward";
	public static final String SOCCER_OUTSIDE_TURN = "Outside Turn";
	public static final String SOCCER_TRIANGLE = "Triangle";
	public static final String SOCCER_ADVANCED_TURN = "Advanced Turn";
	public static final String SOCCER_TRIANGLE_OUTSIDE_ADVANCED = "Triangle, Outside, Advanced";
	public static final String SOCCER_ZIKO_TURN = "Ziko Turn";
	public static final String SOCCER_CRUYFF_TURN = "Cruyff Turn";
	public static final String SOCCER_STEP_OVER_ESCAPE_OUT = "Step-Over, Escape Out";
	public static final String SOCCER_2_STEP_OVERS_ESCAPE_OUT = "2 Step-Overs, Escape Out";
	public static final String SOCCER_HAT_DANCE = "Hat Dance";
	public static final String SOCCER_HAT_DANCE_CIRCLE = "Hat Dance Circle";
	public static final String SOCCER_2_TOUCHES_THEN_ACROSS = "2 touches then across";


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
		generateSoccerMoves();
	}

	private static void generateStandingFrontalMoves() {
		// Mountain Pose
		{
			MoveWithPose move = new MoveWithPose(MOUNTAIN_POSE, Category.NONE, "Stand tall");
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
			MoveWithPose move = new MoveWithPose(JOG_LATERALLY, Category.CARDIO, "Jog while moving laterally");
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
			MoveWithPose move = new MoveWithPose(SAFETY_JACKS, Category.CARDIO, "Jumping Jacks with cross-overs in front");
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
			MoveWithPose move = new MoveWithPose(FAST_FEET, Category.STRENGTH, "Simulate full speed sprinting");
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
			MoveWithPose move = new MoveWithPose(STANDING_HURDLES_W_BAND, Category.WARMUP, true, "Drive knee up with band around feet");
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
			MoveWithPose move = new MoveWithPose(LATERAL_WALK_W_BAND, Category.WARMUP, true, "Walk forwards & backwards in explosive cutting motion");
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
			MoveWithPose move = new MoveWithPose(TWIST_PIVOT, Category.CARDIO, "Twist while stepping out");
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
			MoveWithPose move = new MoveWithPose(WARRIOR_3, Category.YOGA, true, "Leg straight back then knee up, repeat.");
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
			MoveWithPose move = new MoveWithPose(WALKING_BACKWARD_LUNGES, Category.WARMUP, "Step back, reach back with opposite arm");
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
			MoveWithPose move = new MoveWithPose(HIP_HAMSTRING, Category.STRETCH, true, "Stretch Hip then straighten for Hamstring");
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
			MoveWithPose move = new MoveWithPose(ROMAN_LUNGES, Category.CARDIO, "Opposite Arm & Leg go back");
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
			MoveWithPose move = new MoveWithPose(JUMPS_180, Category.CARDIO, "Jump & Turn.");
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.S.add(30), Angle.S.add(-15));

			move.pose.torso = new Torso(move.pose.lLeg.getHeight() + Leg.thickness / 2, Angle.N.add(-30), true);

			move.pose.lArm = new Arm(Angle.S.add(10), Angle.S.add(25));

			moves.put(move.name, move);
		}

		// 90° Jumps to 1 Foot
		{
			MoveWithPose move = new MoveWithPose(JUMPS_90_TO_1_FOOT_LANDING, Category.CARDIO, true, "Jump & Turn.");
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
			MoveWithPose move = new MoveWithPose(KNEE_UP_CRUNCHES, Category.STRENGTH, "Crunches with ");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Knee-Up Crunches
		{
			MoveWithPose move = new MoveWithPose(KNEE_UP_CRUNCHES, Category.STRENGTH, "Crunches with Knees up");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N, Angle.E);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Leg-Up Crunches
		{
			MoveWithPose move = new MoveWithPose(LEG_UP_CRUNCHES, Category.STRENGTH, "Crunches with Legs up");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Knee-Bent Crunches
		{
			MoveWithPose move = new MoveWithPose(KNEE_BENT_CRUNCHES, Category.STRENGTH, "Crunches with Knees bent");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(-45), Angle.S.add(35));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Frog-Leg Crunches
		{
			MoveWithPose move = new MoveWithPose(FROG_LEG_CRUNCHES, Category.STRENGTH, "Crunches with Legs like a frog");
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.E.add(25), Angle.E.add(-25));
			move.pose.rLeg = new Leg(Angle.E.add(-10), 0.9f, Angle.E.add(5), 0.9f);

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Horse-Riding Crunches
		{
			MoveWithPose move = new MoveWithPose(HORSE_RIDING_CRUNCHES, Category.STRENGTH, "Crunches with Legs apart");
			move.pose = new Pose();

			move.pose.lLeg = new Leg(Angle.E.add(20), Angle.E.add(-5));
			move.pose.rLeg = new Leg(Angle.E.add(-20), Angle.E.add(5));

			move.pose.torso = new Torso(Torso.thickness / 2, Angle.W, true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Reverse Crunches
		{
			MoveWithPose move = new MoveWithPose(REVERSE_CRUNCHES, Category.STRENGTH, "Curl Hips towards Ribs");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N.add(15), Angle.E.add(15));

			move.pose.torso = new Torso(Torso.thickness/2 + 3, Angle.W.add(5), true);

			move.pose.rArm = new Arm(Angle.N.add(30), Angle.S.add(-30));

			moves.put(move.name, move);
		}

		// Hip Raises
		{
			MoveWithPose move = new MoveWithPose(HIP_RAISES, Category.STRENGTH, "Lift Hips & Feet towards ceiling");
			move.pose = new Pose();

			move.pose.rLeg = new Leg(Angle.N);

			move.pose.torso = new Torso(Torso.thickness/2 + 3, Angle.W.add(5), true);

			move.pose.rArm = new Arm(Angle.E.add(-20), Angle.E);

			moves.put(move.name, move);
		}

		// Cross-Over Crunches
		{
			MoveWithPose move = new MoveWithPose(CROSSOVER_CRUNCHES, Category.STRENGTH, true, "Shoulder towards opposite Knee");
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
			MoveWithPose move = new MoveWithPose(CATCH_CRUNCHES, Category.STRENGTH, "Reach both Hands outside a Knee");
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
			MoveWithPose move = new MoveWithPose(SIDE_CRUNCHES, Category.STRENGTH, "Lie on side, Ribs towards Hip");
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
			MoveWithPose move = new MoveWithPose(RECLINED_HAMSTRING_W_STRAP, Category.STRETCH, true, "Bend knee then straighten");
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
			MoveWithPose move = new MoveWithPose(BOAT_POSE, Category.YOGA, "Body & legs in a V");
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
			MoveWithPose move = new MoveWithPose(SINGLE_LEG_BRIDGES, Category.WARMUP, true, "Drive leg up, hold, repeat.");
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
			MoveWithPose move = new MoveWithPose(CORPSE_POSE, Category.YOGA, "Lie on your back. Relax. Breathe.");
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
			MoveWithPose move = new MoveWithPose(THORACIC_ROLL_OUTS, Category.YOGA, true, "Lie on side, roll arms out then back");
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
			MoveWithPose move = new MoveWithPose(RECLINED_TWIST, Category.YOGA, true, "Knees across body a few inches off the ground");
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
			MoveWithPose move = new MoveWithPose(KNEE_CROSS_OVER, Category.YOGA, true, "Knee across body");
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
			MoveWithPose move = new MoveWithPose(HIP_OPEN, Category.YOGA, true, "Hip opened up");
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
			MoveWithPose move = new MoveWithPose(RECLINED_COBBLER_POSE, Category.YOGA, "Legs open, feet together. Press legs to extend spine.");
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
			MoveWithPose move = new MoveWithPose(INCH_WORMS, Category.YOGA, "Walk hands to push-up, then walk feet to hands");
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
			MoveWithPose move = new MoveWithPose(FOAM_ROLLER, Category.WARMUP, true, "Iron out the tightness.");
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
			MoveWithPose move = new MoveWithPose(LOCUST_POSE, Category.YOGA, "On Belly. Lift legs & chest.");
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
			MoveWithPose move = new MoveWithPose(LOTUS, Category.YOGA, "Breathe.");
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
			MoveWithPose move = new MoveWithPose(REST, Category.NONE, "Breathe.");
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
			MoveWithPose move = new MoveWithPose(COBBLER_POSE, Category.YOGA, "Sit. Butterfly.");
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
			MoveWithPose move = new MoveWithPose(SAGE_POSE, Category.YOGA, "Sit Tall. Legs together.");
			move.pose = new Pose();

			move.pose.torso = new Torso(Torso.thickness / 2 - 2, true);

			move.pose.lLeg = new Leg(Angle.E);

			moves.put(move.name, move);
		}

		// Twisted Sage Pose
		{
			MoveWithPose move = new MoveWithPose(TWISTED_SAGE_POSE, Category.YOGA, true, "Sit Tall. Pretzel.");
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
		// Sprint
		{
			LadderMove move = new LadderMove(LADDER_SPRINT, Category.AGILITY, "One foot in each square");

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(0, true), -.1f, 0));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true), .1f, 0));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true), -.1f, 0));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true), .1f, 0));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(4, true), -.1f, 0));

			moves.put(move.name, move);
		}

		// Lateral
		{
			LadderMove move = new LadderMove(LADDER_LATERAL, Category.AGILITY, "Sideways, both feet in each square, high knees");

			move.steps.add(new DoubleStep(Ladder.getLocation(0, true), 0, -.5f, Ladder.getLocation(0, true), 0, 1.5f));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true), .1f, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(1, true), -.1f, -1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(2, true), .1f, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true), -.1f, -1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true), .1f, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(3, true), -.1f, -1));

			moves.put(move.name, move);
		}

		// Lateral In/Out
		{
			LadderMove move = new LadderMove(LADDER_LATERAL_IN_OUT, Category.AGILITY, "Sideways, both feet in, both feet out");

			move.steps.add(new DoubleStep(Ladder.getLocation(0.5f, false), 0, -1, Ladder.getLocation(0.5f, false), 0, 1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true), 0, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(1, true), 0, -1));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1.5f, false), 0, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(1.5f, false), 0, -1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(2, true), 0, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true), 0, -1));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(2.5f, false), 0, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2.5f, false), 0, -1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true), 0, 1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(3, true), 0, -1));

			moves.put(move.name, move);
		}

		// Jumping Jack
		{
			LadderMove move = new LadderMove(LADDER_JUMPING_JACK, Category.AGILITY, "Both feet out, both feet in");

			move.steps.add(new OnePointStep(Ladder.getLocation(0, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(0.5f, false, true), Ladder.getLocation(0.5f, false, false)));

			move.steps.add(new OnePointStep(Ladder.getLocation(1, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(1.5f, false, true), Ladder.getLocation(1.5f, false, false)));

			move.steps.add(new OnePointStep(Ladder.getLocation(2, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(2.5f, false, true), Ladder.getLocation(2.5f, false, false)));

			move.steps.add(new OnePointStep(Ladder.getLocation(3, true)));

			moves.put(move.name, move);
		}

		// Hop Scotch
		{
			LadderMove move = new LadderMove(LADDER_HOPSCOTCH, Category.AGILITY, "Both feet out, alternate foot in");

			move.steps.add(new OnePointStep(Ladder.getLocation(0, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(0.5f, false, true), Ladder.getLocation(0.5f, false, false)));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(1.5f, false, true), Ladder.getLocation(1.5f, false, false)));

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true)));
			move.steps.add(new DoubleStep(Ladder.getLocation(2.5f, false, true), Ladder.getLocation(2.5f, false, false)));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true)));

			moves.put(move.name, move);
		}

		// Slalom
		{
			LadderMove move = new LadderMove(LADDER_SLALOM, Category.AGILITY, "Slalom with alternate foot in");

			move.steps.add(new DoubleStep(Ladder.getLocation(0.5f, false, true), Ladder.getLocation(1, true)));

			move.steps.add(new DoubleStep(Ladder.getLocation(2, true), Ladder.getLocation(1.5f, false, false)));

			move.steps.add(new DoubleStep(Ladder.getLocation(2.5f, false, true), Ladder.getLocation(3, true)));

			moves.put(move.name, move);
		}

		// Shuffle
		{
			LadderMove move = new LadderMove(LADDER_SHUFFLE, Category.AGILITY, "Shuffle across");

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(0.5f, false, true), 1, 0));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true), 1, 0));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(1, true), -1, 0));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1.5f, false, false), -1, 0));

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true), -1, 0));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(2, true), 1, 0));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2.5f, false, true), 1, 0));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true), 1, 0));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(3, true), -1, 0));

			moves.put(move.name, move);
		}

		// Cross-Behind
		{
			LadderMove move = new LadderMove(LADDER_CROSS_BEHIND, Category.AGILITY);

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(0, false, true), 1, 1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, true)));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(1, false, false), -1, -1));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(1, false, false), 1, 1));

			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, true)));
			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(2, false, true), 1, -1));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(2, false, true), -1, 1));

			move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, true)));
			move.steps.add(new OnePointStep(Feet.LEFT, Ladder.getLocation(3, false, false), 1, -1));
			//move.steps.add(new OnePointStep(Feet.RIGHT, Ladder.getLocation(3, false, false), -1, 1));

			moves.put(move.name, move);
		}
	}

	private static void generateSoccerMoves() {

		// Inside Rolls
		{
			SoccerMove move = new SoccerMove(SOCCER_INSIDE_ROLLS, Category.SOCCER, "Sole, sole");

			Point toe = move.getToe();
			move.ball = new Point(toe).offset(0, SoccerMove.ballSize/2);

			Point arrowRight = move.ball;
			Point arrowLeft = arrowRight.mirror();
			move.arrows.add(new Arrow(arrowRight.offset(0, 1), arrowLeft.offset(0, 1), Arrow.colorRight));
			move.arrows.add(new Arrow(arrowLeft.offset(0, -1), arrowRight.offset(0, -1), Arrow.colorLeft));

			moves.put(move.name, move);
		}

		// Bells
		{
			SoccerMove move = new SoccerMove(SOCCER_BELLS, Category.SOCCER, "Inside, inside");

			Point toe = move.getToe();
			move.ball = new Point(toe).offset(-SoccerMove.footWidth/2 - SoccerMove.ballSize/2, 0);

			Point arrowRight = toe.offset(-SoccerMove.footWidth/2, 0);
			Point arrowLeft = arrowRight.mirror();
			move.arrows.add(new Arrow(arrowRight.offset(0, 1), arrowLeft.offset(0, 1), Arrow.colorRight));
			move.arrows.add(new Arrow(arrowLeft.offset(0, -1), arrowRight.offset(0, -1), Arrow.colorLeft));

			moves.put(move.name, move);
		}

		// Pull & Open Outward
		{
			SoccerMove move = new SoccerMove(SOCCER_PULL_OPEN_OUTWARD, Category.SOCCER, true, "Pull, open hips, push");

			//move.ballX = SoccerMove.footGap/2 - SoccerMove.footWidth/2 + SoccerMove.footTurnOut + SoccerMove.ballSize/2;
			//move.ballY = SoccerMove.footLength + SoccerMove.torsoThickness/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Outside Turn
		{
			SoccerMove move = new SoccerMove(SOCCER_OUTSIDE_TURN, Category.SOCCER, true, "Pull back and turn outside");

			//move.ballX = SoccerMove.footGap/2 - SoccerMove.footWidth/2 + SoccerMove.footTurnOut + SoccerMove.ballSize/2;
			//move.ballY = SoccerMove.footLength + SoccerMove.torsoThickness/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Triangle
		{
			SoccerMove move = new SoccerMove(SOCCER_TRIANGLE, Category.SOCCER, true, "Pull back, inside, inside");

			/*move.ballX = SoccerMove.footGap/2;
			move.ballY = SoccerMove.footLength + SoccerMove.footWidth/2 + SoccerMove.ballSize/2;
			float arrowX = move.ballX + SoccerMove.ballSize/2;
			float arrowY = move.ballY;
			move.arrows.add(new Arrow(arrowX, arrowY+1, -arrowX, arrowY+1, Arrow.colorRight));
			move.arrows.add(new Arrow(-arrowX, arrowY-1, arrowX, arrowY-1, Arrow.colorLeft));*/

			moves.put(move.name, move);
		}

		// Advanced Turn
		{
			SoccerMove move = new SoccerMove(SOCCER_ADVANCED_TURN, Category.SOCCER, true, "Pull back, inside between");

			//move.ballX = SoccerMove.footGap/2;
			//move.ballY = SoccerMove.footLength + SoccerMove.footWidth/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Triangle, Outside, Advanced
		{
			SoccerMove move = new SoccerMove(SOCCER_TRIANGLE_OUTSIDE_ADVANCED, Category.SOCCER, true, "Triangle, Outside Turn, Advanced Turn");

			//move.ballX = SoccerMove.footGap/2;
			//move.ballY = SoccerMove.footLength + SoccerMove.footWidth/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Ziko Turn
		{
			SoccerMove move = new SoccerMove(SOCCER_ZIKO_TURN, Category.SOCCER, true, "Step over, plant, plant, escape outside");

			//move.ballX = SoccerMove.footGap/2 - SoccerMove.footWidth/2 + SoccerMove.footTurnOut - SoccerMove.ballSize/2;
			//move.ballY = SoccerMove.torsoThickness/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Cruyff Turn
		{
			SoccerMove move = new SoccerMove(SOCCER_CRUYFF_TURN, Category.SOCCER, true, "Feint to inside between");

			//move.ballX = SoccerMove.footGap/2;
			//move.ballY = SoccerMove.footLength + SoccerMove.footWidth/2 + SoccerMove.ballSize/2;

			moves.put(move.name, move);
		}

		// Step-Over, Escape Out
		{
			SoccerMove move = new SoccerMove(SOCCER_STEP_OVER_ESCAPE_OUT, Category.SOCCER, true, "Outward step-over, escape with other foot");

			moves.put(move.name, move);
		}

		// 2 Step-Overs, Escape Out
		{
			SoccerMove move = new SoccerMove(SOCCER_2_STEP_OVERS_ESCAPE_OUT, Category.SOCCER, true, "Double outside step-over, escape");

			moves.put(move.name, move);
		}

		// Hat Dance
		{
			SoccerMove move = new SoccerMove(SOCCER_HAT_DANCE, Category.SOCCER, "Tap ball with alternating soles");

			moves.put(move.name, move);
		}

		// Hat Dance Circle
		{
			SoccerMove move = new SoccerMove(SOCCER_HAT_DANCE_CIRCLE, Category.SOCCER, true, "Hat Dance moving the ball");

			moves.put(move.name, move);
		}

		// 2 touches then across
		{
			SoccerMove move = new SoccerMove(SOCCER_2_TOUCHES_THEN_ACROSS, Category.SOCCER, "Bell then push and move");

			moves.put(move.name, move);
		}

	}

}
