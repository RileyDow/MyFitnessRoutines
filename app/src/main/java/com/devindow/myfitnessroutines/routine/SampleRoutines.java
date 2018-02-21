package com.devindow.myfitnessroutines.routine;

import android.util.Log;

import com.devindow.myfitnessroutines.Debug;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class SampleRoutines {

	// Default Routines
	public static ArrayList<Routine> getSampleRoutines() {
		Log.d(Debug.TAG_ENTER, "getSampleRoutines()");

		ArrayList<Routine> defaultRoutines = new ArrayList<>();

		defaultRoutines.add(get7MinuteWorkout());

		defaultRoutines.add(getWarmupRoutine());

		defaultRoutines.add(getPreActivationRoutine());

		defaultRoutines.add(getMorningYogaRoutine());

		defaultRoutines.add(get5MinMeditation());
		defaultRoutines.add(get10MinMeditation());
		defaultRoutines.add(get15MinMeditation());

		if (Debug.on) {
			defaultRoutines.add(getRileyRoutine());
			defaultRoutines.add(getSoccerTouchesRoutine());
			defaultRoutines.add(getTestPoses());
			defaultRoutines.add(getTestShortRoutine());
/*
			defaultRoutines.add(getSunSalutation());

			defaultRoutines.add(getStretchRoutine());

			defaultRoutines.add(getLiftRoutine());

			defaultRoutines.add(getCardioRoutine());
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
		Routine routine = new Routine("Short Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PLANK), 5, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_PLANK), 10));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PLANK), 5));

		return routine;
	}

	private static Routine getRileyRoutine() {
		Routine routine = new Routine("Riley Routine");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_PLANK), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30, 5));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG), 30, 0));

		return routine;
	}
	private static Routine get7MinuteWorkout() {
		Routine routine = new Routine("7 Minute Workout");

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

	private static Routine getWarmupRoutine() {
		Routine routine = new Routine("Warmup");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.ROTATE_ON_ALL_FOURS), 20));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.PUSH_UPS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.TWIST_PIVOT), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.ROMAN_LUNGES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SAFETY_JACKS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIP_STRETCH), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.HIP_HAMSTRING), 60));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LEG_SWINGS), 30));

		return routine;
	}

	private static Routine getPreActivationRoutine() {
		Routine routine = new Routine("Pre-Activation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.WALKING_BACKWARD_LUNGES), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.FOAM_ROLLER), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.THORACIC_ROLL_OUTS), 60));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.INCH_WORMS), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SINGLE_LEG_BRIDGE), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SIDE_LYING_ABDUCTION_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.SQUATS_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LATERAL_WALK_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.STANDING_HURDLES_W_BAND), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPS_180), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.JUMPS_90_TO_1_FOOT_LANDING), 30));

		return routine;
	}

	private static Routine getMorningYogaRoutine() {
		Routine routine = new Routine("Morning Yoga");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.DOWN_DOG), 30));
		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 30));

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
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 5*60));

		return routine;
	}

	private static Routine get10MinMeditation() {
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 10*60));

		return routine;
	}

	private static Routine get15MinMeditation() {
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(MoveLibrary.moves.get(MoveLibrary.LOTUS), 15*60));

		return routine;
	}

	private static Routine getSoccerTouchesRoutine() {
		Routine routine = new Routine("Soccer Touches");

		routine.steps.add(new Step(new Move("Triangle", Category.SOCCER, true), 15));
		routine.steps.add(new Step(new Move("Ziko Turn", Category.SOCCER, true), 15));
		routine.steps.add(new Step(new Move("Cruyff Turn", Category.SOCCER, true), 15));

		return routine;
	}

}
