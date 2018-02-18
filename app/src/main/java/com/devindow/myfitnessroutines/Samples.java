package com.devindow.myfitnessroutines;

import java.util.ArrayList;

/**
 * Created by Devin on 1/27/2018.
 */

public class Samples {

	// Default Routines
	public static ArrayList<Routine> getSampleRoutines() {
		ArrayList<Routine> defaultRoutines = new ArrayList<>();

		defaultRoutines.add(get7MinuteWorkout());

		defaultRoutines.add(getWarmupRoutine());

		defaultRoutines.add(getPreActivationRoutine());

		defaultRoutines.add(get5MinMeditation());
		defaultRoutines.add(get10MinMeditation());
		defaultRoutines.add(get15MinMeditation());

		/*if (Debug.on) {
			defaultRoutines.add(getRileySample());

			defaultRoutines.add(getTestSample());

			defaultRoutines.add(getSunSalutation());

			defaultRoutines.add(getStretchRoutine());

			defaultRoutines.add(getYogaRoutine());

			defaultRoutines.add(getLiftRoutine());

			defaultRoutines.add(getCardioRoutine());
		}*/

		return defaultRoutines;
	}


	// Private Methods
	private static Routine getTestSample() {
		Routine routine = new Routine("Test Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.TOUCH_TOES), 3, 2));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 3, 2));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DONE), 3, 0));

		return routine;
	}

	private static Routine getRileySample() {
		Routine routine = new Routine("Riley Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.TOUCH_TOES), 20, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DOWN_DOG), 30, 0));

		return routine;
	}
	private static Routine get7MinuteWorkout() {
		Routine routine = new Routine("7 Minute Workout");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.WALL_SIT), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.CRUNCHES), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.STEP_UPS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SQUATS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.CHAIR_DIPS), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PLANK), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.HIGH_KNEES), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LUNGES), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UP_ROTATE), 30, 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SIDE_PLANK), 30));

		return routine;
	}

	private static Routine getWarmupRoutine() {
		Routine routine = new Routine("Warmup");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.ROTATE_ON_ALL_FOURS), 5));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.TWIST_PIVOT), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.ROMAN_LUNGES), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DOWN_DOG), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.HIP_STRETCH), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.HAMSTRING_STRETCH), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LEG_SWINGS), 30));

		return routine;
	}

	private static Routine getPreActivationRoutine() {
		Routine routine = new Routine("Pre-Activation");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.WALKING_BACKWARD_LUNGES), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.FOAM_ROLLER), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.THORACIC_ROLL_OUTS), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.INCH_WORMS), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SINGLE_LEG_BRIDGE), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SIDE_LYING_ABDUCTION_W_BAND), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.SQUATS_W_BAND), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LATERAL_WALK_W_BAND), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.STANDING_HURDLES_W_BAND), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPS_180), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPS_90_TO_1_FOOT_LANDING), 30));

		return routine;
	}

	private static Routine getSunSalutation() {
		Routine routine = new Routine("Sun Salutation");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.TOUCH_TOES), 30, 5));

		return routine;
	}

	private static Routine getStretchRoutine() {
		Routine routine = new Routine("Stretch Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.TOUCH_TOES), 30, 5));

		return routine;
	}

	private static Routine getYogaRoutine() {
		Routine routine = new Routine("Yoga Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.DOWN_DOG), 30));

		return routine;
	}

	private static Routine getLiftRoutine() {
		Routine routine = new Routine("Lift Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30));

		return routine;
	}

	private static Routine getCardioRoutine() {
		Routine routine = new Routine("Cardio Routine");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.JUMPING_JACKS), 30));
		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.PUSH_UPS), 30));

		return routine;
	}

	private static Routine get5MinMeditation() {
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 5*60));

		return routine;
	}

	private static Routine get10MinMeditation() {
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 10*60));

		return routine;
	}

	private static Routine get15MinMeditation() {
		Routine routine = new Routine("Meditation");

		routine.steps.add(new Step(PoseLibrary.poses.get(PoseLibrary.LOTUS), 15*60));

		return routine;
	}

}
