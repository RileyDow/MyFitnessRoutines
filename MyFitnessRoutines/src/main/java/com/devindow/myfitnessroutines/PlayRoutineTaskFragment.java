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
import com.devindow.myfitnessroutines.util.Debug;

// This Fragment manages a the timers and retains itself across configuration changes.
public class PlayRoutineTaskFragment extends Fragment {

	// PlayRoutineCallbacks Interface (PlayRoutineTaskFragment calls to update PlayRoutineActivity)
	interface PlayRoutineCallbacks {
		void displayTask();
		void displayMove();
		void updateTimer(int secondsRemaining);
		void clearInstructions();
	}


	// Public Fields
	public Routine routine;
	public Move move;
	public int move1SecondsRemaining;
	public int move2SecondsRemaining;
	public int restSecondsRemaining;


	// Private Fields
	private PlayRoutineCallbacks playRoutineActivity;
	private int taskNum = 1;
	private CountDownTimer countDownTimer;


	// Public Properties
	public boolean isPaused() { return countDownTimer == null; }

	public Task getCurrentTask() {
		return routine.getTask(taskNum);
	}

	public Task getNextTask() {
		return routine.getTask(taskNum+1);
	}

	public String getTasksRemaining() {
		return routine.getTasksRemainingString(taskNum);
	}

	public int getSecondsRemaining() {
		int secondsRemaining = move1SecondsRemaining + move2SecondsRemaining;
		if (secondsRemaining == 0) {
			secondsRemaining = restSecondsRemaining;
		}
		return secondsRemaining;
	}

	public boolean isSecondSide() {
		return move1SecondsRemaining == 0;
	}


	// Fragment Class Overrides
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.onCreate()");
		super.onCreate(savedInstanceState);

		// Retain this fragment across configuration changes.
		setRetainInstance(true);

		// set move
		Task currentTask = getCurrentTask();
		if (currentTask == null) { // Finished, so show DONE & kill timer
			move = MoveLibrary.moves.get(MoveLibrary.DONE);
			pause();
		} else {
			move = MoveLibrary.moves.get(currentTask.moveName);
		}

		// need to set SecondsRemaining when showing first Task
		resetSecondsRemaining();

		playRoutineActivity.displayTask();

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

		// set playRoutineActivity to NULL
		playRoutineActivity = null;

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.onDetach()");
	}


	// Public Methods
	public void cancelTimer() {
		if (countDownTimer != null) {
			countDownTimer.cancel();
		}
	}

	public void resetSecondsRemaining() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.resetSecondsRemaining()");

		Task currentTask = getCurrentTask();
		if (currentTask == null) {
			move1SecondsRemaining = move2SecondsRemaining = restSecondsRemaining = 0;
		} else {
			if (move != null && move.twoSides) {
				move1SecondsRemaining = currentTask.moveSeconds / 2;
				move2SecondsRemaining = currentTask.moveSeconds - move1SecondsRemaining;
			} else {
				move1SecondsRemaining = currentTask.moveSeconds;
				move2SecondsRemaining = 0;
			}
			restSecondsRemaining = currentTask.restSeconds;
		}

		Debug.d(Debug.TAG_EXIT, "PlayRoutineTaskFragment.resetSecondsRemaining()");
	}

	public void pause() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.pause()");

		cancelTimer();
		countDownTimer = null;
	}

	public void resume() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.resume()");

		if (move1SecondsRemaining > 0) {
			runMove1Timer();
		} else if (move2SecondsRemaining > 0) {
			runMove2Timer();
		} else if (restSecondsRemaining > 0) {
			runRestTimer();
		}
		else {
			restart();
		}
	}

	public void next() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.next()");

		cancelTimer();

		if (taskNum <= routine.tasks.size()) {
			taskNum++;
		} else {
			taskNum = 1; // Restart ended Routine
		}

		Task currentTask = getCurrentTask();
		if (currentTask == null) {
			move = null;
		} else {
			move = MoveLibrary.moves.get(currentTask.moveName);
		}
		resetSecondsRemaining();

		if (playRoutineActivity != null) {
			playRoutineActivity.displayTask();

			// If timer was running then run.
			if (!isPaused()) {
				resume();
			}
		}
	}

	public void prev() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.prev()");

		cancelTimer();

		if (taskNum > 1) {
			taskNum--;
		}

		move = MoveLibrary.moves.get(getCurrentTask().moveName);
		resetSecondsRemaining();

		if (playRoutineActivity != null) {
			playRoutineActivity.displayTask();

			// If timer was running then run.
			if (!isPaused()) {
				resume();
			}
		}
	}

	public void restart() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.restart()");

		taskNum = 1; // Restart ended Routine
		move = MoveLibrary.moves.get(getCurrentTask().moveName);
		resetSecondsRemaining();

		playRoutineActivity.displayTask();
		resume();
	}

	public void runMove1Timer() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineTaskFragment.runMove1Timer()");

		countDownTimer = new CountDownTimer(move1SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move1SecondsRemaining = (int)(millisRemaining / 1000);
				if (playRoutineActivity != null) {
					playRoutineActivity.updateTimer(move1SecondsRemaining + move2SecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();

				// second side
				if (move2SecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.displayMove();
					}
					runMove2Timer();

				// rest
				} else if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.clearInstructions();
						move = MoveLibrary.moves.get(MoveLibrary.REST);
						playRoutineActivity.displayMove();
					}
					runRestTimer();

				// next Task
				} else {
					next();
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
					playRoutineActivity.updateTimer(move2SecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();

				// rest
				if (restSecondsRemaining > 0) {
					if (playRoutineActivity != null) {
						playRoutineActivity.clearInstructions();
						move = MoveLibrary.moves.get(MoveLibrary.REST);
						playRoutineActivity.displayMove();
					}
					runRestTimer();

				// next Task
				} else {
					next();
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
					playRoutineActivity.updateTimer(restSecondsRemaining);
				}
			}

			@Override
			public void onFinish() {
				playChime();

				next();
			}
		}.start();
	}


	// Private Methods
	private void playChime() {
		ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);
		toneGenerator.startTone(AudioManager.STREAM_NOTIFICATION,100);
	}

}