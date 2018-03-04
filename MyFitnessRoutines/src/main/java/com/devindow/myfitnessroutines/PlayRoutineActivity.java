package com.devindow.myfitnessroutines;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.devindow.myfitnessroutines.pose.MoveWithPose;
import com.devindow.myfitnessroutines.routine.*;

public class PlayRoutineActivity extends AppCompatActivity implements PlayRoutineTaskFragment.PlayRoutineCallbacks {

	// Constants
	public static final String PLAY_ROUTINE_TASK_FRAGMENT = "PlayRoutineTaskFragment";


	// Private Fields
	private PlayRoutineTaskFragment taskFragment;


	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_routine);

		// Keep Screen On
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		// If the Fragment is non-null, then it is currently being retained across a configuration change.
		FragmentManager fragmentManager = getFragmentManager();
		taskFragment = (PlayRoutineTaskFragment) fragmentManager.findFragmentByTag(PLAY_ROUTINE_TASK_FRAGMENT);
		if (taskFragment == null) {
			taskFragment = new PlayRoutineTaskFragment();
			fragmentManager.beginTransaction().add(taskFragment, PLAY_ROUTINE_TASK_FRAGMENT).commit();
		}

		// Get Routine passed in by Intent
		Intent intent = getIntent();
		taskFragment.routine = (Routine)intent.getSerializableExtra("routine");

		// txtRoutineName
		final TextView txtRoutineName = findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(taskFragment.routine.name);

		// Show the current Task w/o affecting PlayRoutineTaskFragment's countDownTimer.
		displayTask(false);

		// Update btnPlay in case it is running.
		updatePlayButton();

		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.onCreate()");
	}

	@Override
	public void displayTask(boolean resetSecondsRemaining) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayTask()");

		clearNextMoveName();

		if (taskFragment.taskNum > taskFragment.routine.tasks.size()) { // Finished, so show DONE & kill timer
			taskFragment.move = MoveLibrary.moves.get(MoveLibrary.DONE);
			taskFragment.countDownTimer = null;
			updatePlayButton();
		} else {
			Task currentTask = taskFragment.getCurrentTask();
			taskFragment.move = MoveLibrary.moves.get(currentTask.moveName);

			final TextView txtInstructions = findViewById(R.id.txtInstructions);
			if (!currentTask.instructions.isEmpty()) {
				txtInstructions.setText(currentTask.instructions);
			} else if (taskFragment.move != null) {
				txtInstructions.setText(taskFragment.move.description);
			}
		}

		if (resetSecondsRemaining) {
			taskFragment.resetSecondsRemaining();
		}
		updateTimer();

		displayMove(taskFragment.move, false);

		displayNextMoveName();

		displayRemaining();

		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.displayTask()");
	}

	@Override
	public void displayMove(Move move, boolean secondSide) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayMove()");
		final TextView txtMoveName = findViewById(R.id.txtMoveName);
		final ImageView imgMove = findViewById(R.id.imgMove);

		if (move == null) {
			txtMoveName.setText("NULL");
			imgMove.setImageBitmap(Bitmap.createBitmap(MoveWithPose.BITMAP_PIXELS, MoveWithPose.BITMAP_PIXELS, Bitmap.Config.ARGB_8888));
		} else {
			if (move.twoSides) {
				if (secondSide) {
					txtMoveName.setText(move.name + " ->");
				} else {
					txtMoveName.setText(move.name + " <-");
				}
			} else {
				txtMoveName.setText(move.name);
			}
			imgMove.setImageBitmap(move.getBitmap(secondSide));
		}
		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.displayMove()");
	}

	@Override
	public void updateTimer() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.updateTimer()");

		TextView txtTimer = findViewById(R.id.txtTimer);
		if (txtTimer != null) {
			long secondsRemaining = taskFragment.move1SecondsRemaining + taskFragment.move2SecondsRemaining;
			if (secondsRemaining == 0) {
				secondsRemaining = taskFragment.restSecondsRemaining;
			}
			String timeRemaining = String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60);
			Debug.d(Debug.TAG_TIME, timeRemaining);
			txtTimer.setText(timeRemaining);
		}
	}

	private void clearNextMoveName() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.clearNextMoveName()");
		final TextView txtNextTask = findViewById(R.id.txtNextTask);
		if (txtNextTask != null) {
			txtNextTask.setText("");
		}
	}

	private void displayNextMoveName() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayNextMoveName()");

		final TextView txtNextTask = findViewById(R.id.txtNextTask);
		if (txtNextTask != null) {
			Task nextTask = taskFragment.getNextTask();
			if (nextTask == null) {
				txtNextTask.setText("");
			} else {
				txtNextTask.setText("Next: " + nextTask.moveName);
			}
		}
	}

	private void displayRemaining() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayRemaining()");

		final TextView txtRemaining = findViewById(R.id.txtRemaining);
		if (txtRemaining != null) {
			txtRemaining.setText(taskFragment.getRemaining());
		}
	}

	private void updatePlayButton() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.updatePlayButton()");

		ImageButton btnPlay = findViewById(R.id.btnPlay);

		if (taskFragment.countDownTimer == null) {
			// No timer, so it is paused, so set btnPlay image to Play
			btnPlay.setImageResource(android.R.drawable.ic_media_play);
		} else {
			// Timer is running, so it is playing, so set btnPlay image to Pause
			btnPlay.setImageResource(android.R.drawable.ic_media_pause);
		}
	}

	public void onPlayClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPlayClick()");

		if (taskFragment.countDownTimer != null) {
			// Pause Routine
			taskFragment.countDownTimer.cancel();
			taskFragment.countDownTimer = null;
		} else {
			// Play Routine
			if (taskFragment.taskNum > taskFragment.routine.tasks.size()) {
				taskFragment.taskNum = 1; // Restart ended Routine
				displayTask(true);
			}

			if (taskFragment.move1SecondsRemaining > 0) {
				taskFragment.runMove1Timer();
			} else if (taskFragment.move2SecondsRemaining > 0) {
				taskFragment.runMove2Timer();
			} else {
				taskFragment.runRestTimer();
			}
		}

		updatePlayButton();
	}

	public void onNextClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onNextClick()");

		if (taskFragment.taskNum <= taskFragment.routine.tasks.size()) {
			if (taskFragment.countDownTimer != null) {
				taskFragment.countDownTimer.cancel();
			}
			taskFragment.taskNum++;
			displayTask(true);

			// If timer was running then run.
			if (taskFragment.countDownTimer != null) {
				taskFragment.runMove1Timer();
			}
		}
	}

	public void onPrevClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPrevClick()");

		if (taskFragment.taskNum > 1) {
			if (taskFragment.countDownTimer != null) {
				taskFragment.countDownTimer.cancel();
			}
			taskFragment.taskNum--;
			displayTask(true);

			// If timer was running then run.
			if (taskFragment.countDownTimer != null) {
				taskFragment.runMove1Timer();
			}
		}
	}

}
