package com.devindow.myfitnessroutines.routine;

import com.devindow.myfitnessroutines.Debug;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class SampleRoutines {

	// Default Routines
	public static ArrayList<Routine> getSampleRoutines() {
		Debug.d(Debug.TAG_ENTER, "getSampleRoutines()");

		ArrayList<Routine> defaultRoutines = new ArrayList<>();

		defaultRoutines.add(get7MinuteWorkout());

		defaultRoutines.add(getMorningYogaRoutine());

		defaultRoutines.add(getWarmupRoutine());

		defaultRoutines.add(getPreActivationRoutine());

		defaultRoutines.add(get5MinMeditation());
		defaultRoutines.add(get10MinMeditation());
		defaultRoutines.add(get15MinMeditation());

		if (Debug.on) {
			defaultRoutines.add(getSoccerTouches());
			defaultRoutines.add(getLadderDrills());
			defaultRoutines.add(getStretchRoutine());
			defaultRoutines.add(getTestPoses());
			defaultRoutines.add(getTestShortRoutine());
/*
			defaultRoutines.add(getSunSalutation());


			defaultRoutines.add(getLiftRoutine());

			defaultRoutines.add(getCardioRoutine());

			defaultRoutines.add(getRileyRoutine());
*/
		}

		return defaultRoutines;
	}


	// Private Methods
	private static Routine getTestPoses() {
		Routine routine = new Routine("Test Poses");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 3, 2));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DONE), 3));

		return routine;
	}

	private static Routine getTestShortRoutine() {
		Routine routine = new Routine("Short Routine with long, long, long, long, long, long, long name", "Short Routine for testing. Long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long description.");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PLANK), 5, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_PLANK), 10));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PLANK), 5));

		return routine;
	}

	private static Routine get7MinuteWorkout() {
		Routine routine = new Routine("7 Minute Workout", "High-intensity circuit training that alternates muscle groups");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPING_JACKS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WALL_SIT), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.CRUNCHES), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.STEP_UPS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SQUATS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.CHAIR_DIPS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PLANK), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIGH_KNEES), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LUNGES), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UP_ROTATE), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_PLANK), 30));

		return routine;
	}

	private static Routine getMorningYogaRoutine() {
		Routine routine = new Routine("Morning Yoga", "Yoga for getting going when stiff from inactivity.  Breathe with each movement.");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.CORPSE_POSE), 60, "Lie on your back. Relax. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.KNEE_CROSS_OVER), 30, "Knee across body. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIP_OPEN), 30, "Hip opened up. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.RECLINED_COBBLER_POSE), 15, "Legs open, feet together. Press legs to extend spine."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HEAD_TO_KNEES_TOPVIEW), 15, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.RECLINED_TWIST), 30, "Knees across body a few inches off the ground. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.RECLINED_HAMSTRING_W_STRAP), 60, "Bend knee then straighten. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.BRIDGE_POSE), 20, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.COBBLER_POSE), 20, "Sit. Butterfly. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.BOAT_POSE), 15, "Body & legs in a V. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SHOULDER_PRESS), 20, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOCUST_POSE), 15, "On Belly. Lift legs & chest. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.ROTATE_ON_ALL_FOURS), 20, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.CAT_POSE), 20, "Arch back, then bow back. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG_ALTERNATING_CALVES), 40, "Alternate calves. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.CHILD_POSE), 20, "Walk your fingers out. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WIDE_LEG_BEND), 30, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.MOUNTAIN_POSE), 15, "Roll up slowly. Stand tall. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.STANDING_SIDE_BEND), 20, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WARRIOR_2), 30, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIP_STRETCH), 40, "Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SAGE_POSE), 10, "Sit Tall. Legs together. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.TWISTED_SAGE_POSE), 30, "Sit Tall. Pretzel. Breathe."));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 5*60, "Meditate & Breathe. Namaste."));

		return routine;
	}

	private static Routine getWarmupRoutine() {
		Routine routine = new Routine("Warmup/Thermoregulation", "A warmup to do when starting out cold");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JOG_LATERALLY), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG_ALTERNATING_CALVES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.TWIST_PIVOT), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.ROMAN_LUNGES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SAFETY_JACKS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIP_HAMSTRING), 60));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LEG_SWINGS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIGH_KNEES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.FAST_FEET), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SKIP), 30));

		return routine;
	}

	private static Routine getPreActivationRoutine() {
		Routine routine = new Routine("Pre-Activation", "From the England National Soccer Team.  Do a warmup first.");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.FOAM_ROLLER), 60));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.THORACIC_ROLL_OUTS), 60));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.REACH_BACK), 20));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WARRIOR_3), 40));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.INCH_WORMS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WALKING_BACKWARD_LUNGES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SINGLE_LEG_BRIDGES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_LYING_ABDUCTION_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SQUATS_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LATERAL_WALK_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.STANDING_HURDLES_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPS_180), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPS_90_TO_1_FOOT_LANDING), 30));

		return routine;
	}

	private static Routine getSunSalutation() {
		Routine routine = new Routine("Sun Salutation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.TOUCH_TOES), 30, 5));

		return routine;
	}

	private static Routine getStretchRoutine() {
		Routine routine = new Routine("Stretch Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.TOUCH_TOES), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WIDE_LEG_BEND), 30, "Breathe."));

		return routine;
	}

	private static Routine getLiftRoutine() {
		Routine routine = new Routine("Lift Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30));

		return routine;
	}

	private static Routine getCardioRoutine() {
		Routine routine = new Routine("Cardio Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPING_JACKS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30));

		return routine;
	}

	private static Routine get5MinMeditation() {
		Routine routine = new Routine("5 min Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 5*60));

		return routine;
	}

	private static Routine get10MinMeditation() {
		Routine routine = new Routine("10 min Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 10*60));

		return routine;
	}

	private static Routine get15MinMeditation() {
		Routine routine = new Routine("15 min Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 15*60));

		return routine;
	}

	private static Routine getSoccerTouches() {
		Routine routine = new Routine("Soccer Touches");

		routine.steps.add(new Step(new SoccerMove("Inside Rolls", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Bells", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Triangle", Category.SOCCER, true), 30));
		routine.steps.add(new Step(new SoccerMove("Triangle, Outside, Advanced", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Ziko Turn", Category.SOCCER, true), 30));
		routine.steps.add(new Step(new SoccerMove("Cruyff Turn", Category.SOCCER, true), 30));
		routine.steps.add(new Step(new SoccerMove("Pull, Open", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Step-Over, Escape Out", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Step-Over 2x, Escape Out", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Hat Dance", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("Hat Dance Circle", Category.SOCCER), 30));
		routine.steps.add(new Step(new SoccerMove("2 touches then across", Category.SOCCER), 30));

		return routine;
	}

	private static Routine getLadderDrills() {
		Routine routine = new Routine("Ladder Drills");

		routine.steps.add(new Step(new SoccerMove("Grapevine", Category.LADDER, true), 15));
		routine.steps.add(new Step(new SoccerMove("Shuffle", Category.LADDER, true), 15));

		return routine;
	}

	private static Routine getRileyRoutine() {
		Routine routine = new Routine("Riley Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_PLANK), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG), 30, 0));

		return routine;
	}
}
