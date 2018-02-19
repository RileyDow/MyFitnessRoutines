package com.devindow.myfitnessroutines;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.devindow.myfitnessroutines.routine.*;

public class PlayRoutineActivity extends AppCompatActivity implements PlayRoutineTaskFragment.PlayRoutineCallbacks {

	// Constants
	public static final String PLAY_ROUTINE_TASK_FRAGMENT = "PlayRoutineTaskFragment";


	// Private Fields
	private PlayRoutineTaskFragment taskFragment;


	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_routine);

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

		// Show the current Step w/o affecting PlayRoutineTaskFragment's countDownTimer.
		showStep(false);

		Log.d(Debug.TAG_EXIT, "PlayRoutineActivity.onCreate()");
	}

	@Override
	public void showStep(boolean resetTimer) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.showStep()");
		clearNextStep();

		if (taskFragment.stepNum > taskFragment.routine.steps.size()) { // Finished, so show DONE & kill timer
			taskFragment.move = MoveLibrary.moves.get(MoveLibrary.DONE);
			taskFragment.countDownTimer = null;
		} else {
			Step currentStep = taskFragment.getCurrentStep();
			taskFragment.move = currentStep.move;
			updateTimerView(taskFragment.move1SecondsRemaining + taskFragment. move2SecondsRemaining);
		}

		showMove(taskFragment.move, false);

		showNextMoveName();

		Log.d(Debug.TAG_EXIT, "PlayRoutineActivity.showStep()");
	}

	@Override
	public void showMove(Move move, boolean secondSide) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.showMove()");
		final TextView txtPoseName = findViewById(R.id.txtPoseName);
		final ImageView imgPose = findViewById(R.id.imgPose);

		if (move == null) {
			txtPoseName.setText("NULL");
			imgPose.setImageBitmap(Bitmap.createBitmap(move.bitmapSize, move.bitmapSize, Bitmap.Config.ARGB_8888));
		} else {
			if (move.twoSides) {
				if (secondSide) {
					txtPoseName.setText(move.name + " ->");
				} else {
					txtPoseName.setText(move.name + " <-");
				}
			} else {
				txtPoseName.setText(move.name);
			}
			imgPose.setImageBitmap(move.getBitmap(secondSide));
		}
		Log.d(Debug.TAG_EXIT, "PlayRoutineActivity.showMove()");
	}

	private void clearNextStep() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.clearNextStep()");
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		if (txtNextStep != null) {
			txtNextStep.setText("");
		}
	}

	private void showNextMoveName() {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.showNextMoveName()");
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		if (txtNextStep != null) {
			Step nextStep = taskFragment.getNextStep();
			if (nextStep == null) {
				txtNextStep.setText("");
			} else {
				txtNextStep.setText("Next up: " + nextStep.move.name);
			}
		}
	}

	@Override
	public void updateTimerView(long secondsRemaining) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.updateTimerView()");
		TextView txtTimer = findViewById(R.id.txtTimer);
		if (txtTimer != null) {
			String timeRemaining = String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60);
			Log.d(Debug.TAG_TIME, timeRemaining);
			txtTimer.setText(timeRemaining);
		}
	}

	public void onPlayClick(View v) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPlayClick()");
		ImageButton btnPlay = findViewById(R.id.btnPlay);

		// Pause Routine
		if (taskFragment.countDownTimer != null) {
			taskFragment.countDownTimer.cancel();
			taskFragment.countDownTimer = null;

			// Set btnPlay image to Play
			btnPlay.setImageResource(android.R.drawable.ic_media_play);
		}

		// Play Routine
		else {
			if (taskFragment.stepNum > taskFragment.routine.steps.size()) {
				taskFragment.stepNum = 1; // Restart ended Routine
				showStep(true);
			}

			// Set btnPlay image to Pause
			btnPlay.setImageResource(android.R.drawable.ic_media_pause);

			if (taskFragment.move1SecondsRemaining > 0) {
				taskFragment.runMove1Timer();
			} else if (taskFragment.move2SecondsRemaining > 0) {
				taskFragment.runMove2Timer();
			} else {
				taskFragment.runRestTimer();
			}
		}

	}

	public void onNextClick(View v) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.onNextClick()");
		if (taskFragment.stepNum < taskFragment.routine.steps.size()) {
			if (taskFragment.countDownTimer != null) {
				taskFragment.countDownTimer.cancel();
			}
			taskFragment.stepNum++;
			showStep(true);

			// If timer was running then run.
			if (taskFragment.countDownTimer != null) {
				taskFragment.runMove1Timer();
			}
		}
	}

	public void onPrevClick(View v) {
		Log.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPrevClick()");
		if (taskFragment.stepNum > 1) {
			if (taskFragment.countDownTimer != null) {
				taskFragment.countDownTimer.cancel();
			}
			taskFragment.stepNum--;
			showStep(true);

			// If timer was running then run.
			if (taskFragment.countDownTimer != null) {
				taskFragment.runMove1Timer();
			}
		}
	}

}
