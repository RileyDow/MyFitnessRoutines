package com.devindow.myfitnessroutines;

/**
 * Created by Devin on 2/18/2018.
 */

import android.app.Activity;
import android.app.Fragment;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.devindow.myfitnessroutines.routine.Move;
import com.devindow.myfitnessroutines.routine.MoveLibrary;
import com.devindow.myfitnessroutines.routine.Routine;
import com.devindow.myfitnessroutines.routine.Step;

// This Fragment manages a the timers and retains itself across configuration changes.
public class PlayRoutineTaskFragment extends Fragment {

	// PlayRoutineCallbacks Interface (PlayRoutineTaskFragment calls to update PlayRoutineActivity)
	interface PlayRoutineCallbacks {
		void showStep(boolean startTimer);
		void showMove(Move move, boolean secondSide);
		void updateTimerView(long secondsRemaining);
	}


	// Public Fields
	public CountDownTimer countDownTimer;
	public int stepNum = 1;
	public Routine routine;
	public Move move;
	public int move1SecondsRemaining;
	public int move2SecondsRemaining;
	public int restSecondsRemaining;


	// Public Properties
	public Step getCurrentStep() {
		return routine.steps.get(stepNum - 1);
	}

	public Step getNextStep() {
		if (stepNum >= routine.steps.size()) {
			return null;
		}
		return routine.steps.get(stepNum);
	}

	// Private Fields
	private PlayRoutineCallbacks playRoutineActivity;


	// Fragment Class Overrides
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onCreate()");
		super.onCreate(savedInstanceState);

		// Retain this fragment across configuration changes.
		setRetainInstance(true);
		Log.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onCreate()");
	}

	@Override
	public void onAttach(Activity activity) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onAttach()");
		super.onAttach(activity);

		// set playRoutineActivity to Activity
		playRoutineActivity = (PlayRoutineCallbacks)activity;
		setSecondsRemaining();
		Log.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onAttach()");
	}

	@Override
	public void onDetach() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onDetach()");
		super.onDetach();

		// set playRoutineActivity to NULL
		playRoutineActivity = null;
		Log.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onDetach()");
	}


	// Public Methods
	public void setSecondsRemaining() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.setSecondsRemaining()");
		Step currentStep = getCurrentStep();
		if (move.twoSides) {
			move1SecondsRemaining = move2SecondsRemaining = currentStep.moveDuration / 2;
		} else {
			move1SecondsRemaining = currentStep.moveDuration;
			move2SecondsRemaining = 0;
		}
		restSecondsRemaining = currentStep.restDuration;
		Log.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.setSecondsRemaining()");
	}

	public void runMove1Timer() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runMove1Timer()");
		countDownTimer = new CountDownTimer(move1SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move1SecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimerView(move1SecondsRemaining + move2SecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();

				if (move2SecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.showMove(move, true);
					}
					runMove2Timer();
				} else if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.showMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					}
					runRestTimer();
				} else {
					stepNum++;
					if (playRoutineActivity != null) {
						playRoutineActivity.showStep(true);

						// If timer was running then run.
						if (countDownTimer != null) {
							runMove1Timer();
						}
					}
				}
			}
		}.start();
	}

	public void runMove2Timer() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runMove2Timer()");
		countDownTimer = new CountDownTimer(move2SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move2SecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimerView(move2SecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();

				if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.showMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					}
					runRestTimer();
				} else {
					stepNum++;
					if (playRoutineActivity != null) {
						playRoutineActivity.showStep(true);

						// If timer was running then run.
						if (countDownTimer != null) {
							runMove1Timer();
						}
					}
				}
			}
		}.start();
	}

	public void runRestTimer() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runRestTimer()");
		countDownTimer = new CountDownTimer(restSecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				restSecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimerView(restSecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();
				stepNum++;
				if (playRoutineActivity != null) {
					playRoutineActivity.showStep(true);

					// If timer was running then run.
					if (countDownTimer != null) {
						runMove1Timer();
					}
				}
			}
		}.start();
	}


	// Private Methods
	private void playChime() {
		ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);
		toneGenerator.startTone(AudioManager.STREAM_NOTIFICATION,100);
	}

}