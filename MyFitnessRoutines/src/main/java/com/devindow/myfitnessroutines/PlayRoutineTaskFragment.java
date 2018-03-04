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

import com.devindow.myfitnessroutines.routine.Move;
import com.devindow.myfitnessroutines.routine.MoveLibrary;
import com.devindow.myfitnessroutines.routine.Routine;
import com.devindow.myfitnessroutines.routine.Task;

// This Fragment manages a the timers and retains itself across configuration changes.
public class PlayRoutineTaskFragment extends Fragment {

	// PlayRoutineCallbacks Interface (PlayRoutineTaskFragment calls to update PlayRoutineActivity)
	interface PlayRoutineCallbacks {
		void displayTask(boolean startTimer);
		void displayMove(Move move, boolean secondSide);
		void updateTimer();
	}


	// Public Fields
	public CountDownTimer countDownTimer;
	public int taskNum = 1;
	public Routine routine;
	public Move move;
	public int move1SecondsRemaining;
	public int move2SecondsRemaining;
	public int restSecondsRemaining;


	// Public Properties
	public Task getCurrentTask() {
		return routine.getTask(taskNum);
	}

	public Task getNextTask() {
		return routine.getTask(taskNum +1);
	}

	public String getRemaining() {
		return routine.getRemainingString(taskNum);
	}


	// Private Fields
	private PlayRoutineCallbacks playRoutineActivity;


	// Fragment Class Overrides
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onCreate()");
		super.onCreate(savedInstanceState);

		// Retain this fragment across configuration changes.
		setRetainInstance(true);

		// Need to set SecondsRemaining when showing first Task.
		resetSecondsRemaining();
		playRoutineActivity.updateTimer();

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onCreate()");
	}

	@Override
	public void onAttach(Activity activity) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onAttach()");
		super.onAttach(activity);

		// set playRoutineActivity to Activity
		playRoutineActivity = (PlayRoutineCallbacks)activity;

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onAttach()");
	}

	@Override
	public void onDetach() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onDetach()");
		super.onDetach();

		// kill running timer
		if (countDownTimer != null) {
			countDownTimer.cancel();
		}

		// set playRoutineActivity to NULL
		playRoutineActivity = null;

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onDetach()");
	}


	// Public Methods
	public void resetSecondsRemaining() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.resetSecondsRemaining()");

		Task currentTask = getCurrentTask();
		if (currentTask == null) {
			move1SecondsRemaining = move2SecondsRemaining = restSecondsRemaining = 0;
		} else {
			if (move != null && move.twoSides) {
				move1SecondsRemaining = move2SecondsRemaining = currentTask.moveSeconds / 2;
			} else {
				move1SecondsRemaining = currentTask.moveSeconds;
				move2SecondsRemaining = 0;
			}
			restSecondsRemaining = currentTask.restSeconds;
		}

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.resetSecondsRemaining()");
	}

	public void runMove1Timer() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runMove1Timer()");
		countDownTimer = new CountDownTimer(move1SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move1SecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimer();
				}
			}

			@Override
			public void onFinish() {
				playChime();

				if (move2SecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.displayMove(move, true);
					}
					runMove2Timer();
				} else if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.displayMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					}
					runRestTimer();
				} else {
					taskNum++;
					if (playRoutineActivity != null) {
						playRoutineActivity.displayTask(true);

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
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runMove2Timer()");
		countDownTimer = new CountDownTimer(move2SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move2SecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimer();
				}
			}

			@Override
			public void onFinish() {
				playChime();

				if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.displayMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					}
					runRestTimer();
				} else {
					taskNum++;
					if (playRoutineActivity != null) {
						playRoutineActivity.displayTask(true);

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
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runRestTimer()");
		countDownTimer = new CountDownTimer(restSecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				restSecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimer();
				}
			}

			@Override
			public void onFinish() {
				playChime();
				taskNum++;
				if (playRoutineActivity != null) {
					playRoutineActivity.displayTask(true);

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