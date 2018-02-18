package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.devindow.myfitnessroutines.routine.*;

public class PlayRoutineActivity extends AppCompatActivity {

	// Private Fields
	private Routine routine;
	private int stepNum = 1;
	private Move move;
	private int move1SecondsRemaining;
	private int move2SecondsRemaining;
	private int restSecondsRemaining;

	private CountDownTimer countDownTimer;
	private TextView txtTimer;


	// Private Properties
	private Step getCurrentStep() {
		return routine.steps.get(stepNum - 1);
	}

	private Step getNextStep() {
		if (stepNum >= routine.steps.size()) {
			return null;
		}
		return routine.steps.get(stepNum);
	}


	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play_routine);

		Intent intent = getIntent();
		routine = (Routine)intent.getSerializableExtra("routine");

		// txtRoutineName
		final TextView txtRoutineName = findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.name);

		// txtTimer
		txtTimer = findViewById(R.id.txtTimer);

		showStep();
	}

	private void showStep() {
		clearNextStep();

		if (stepNum > routine.steps.size()) { // Finished
			move = MoveLibrary.moves.get(MoveLibrary.DONE);
			countDownTimer = null;
		} else {
			Step currentStep = getCurrentStep();
			move = currentStep.move;
			if (currentStep.move.twoSides) {
				move1SecondsRemaining = move2SecondsRemaining = currentStep.moveDuration / 2;
			} else {
				move1SecondsRemaining = currentStep.moveDuration;
				move2SecondsRemaining = 0;
			}
			restSecondsRemaining = currentStep.restDuration;
			updateTimerView(move1SecondsRemaining + move2SecondsRemaining);
		}

		showMove(move, false);

		showNextMoveName();

		// If timer was running then run.
		if (countDownTimer != null) {
			runMove1Timer();
		}
	}

	private void showMove(Move move, boolean secondSide) {
		final TextView txtPoseName = findViewById(R.id.txtPoseName);
		final ImageView imgPose = findViewById(R.id.imgPose);

		if (move == null) {
			txtPoseName.setText("NULL");
			imgPose.setImageBitmap(Bitmap.createBitmap(move.bitmapSize, move.bitmapSize, Bitmap.Config.ARGB_8888));
		} else {
			txtPoseName.setText(move.name);
			imgPose.setImageBitmap(move.getBitmap(secondSide));
		}
	}

	private void clearNextStep() {
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		txtNextStep.setText("");
	}

	private void showNextMoveName() {
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		Step nextStep = getNextStep();
		if (nextStep == null) {
			txtNextStep.setText("");
		} else {
			txtNextStep.setText("Next up: " + nextStep.move.name);
		}
	}

	private void updateTimerView(long secondsRemaining) {
		txtTimer.setText(String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60));
	}

	public void onPlayClick(View v) {
		ImageButton btnPlay = findViewById(R.id.btnPlay);

		// Pause Routine
		if (countDownTimer != null) {
			countDownTimer.cancel();
			countDownTimer = null;

			// Set btnPlay image to Play
			btnPlay.setImageResource(android.R.drawable.ic_media_play);
		}

		// Play Routine
		else {
			if (stepNum > routine.steps.size()) {
				stepNum = 1; // Restart ended Routine
				showStep();
			}

			// Set btnPlay image to Pause
			btnPlay.setImageResource(android.R.drawable.ic_media_pause);

			if (move1SecondsRemaining > 0) {
				runMove1Timer();
			} else if (move2SecondsRemaining > 0) {
				runMove2Timer();
			} else {
				runRestTimer();
			}
		}

	}

	private void runMove1Timer() {
		countDownTimer = new CountDownTimer(move1SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move1SecondsRemaining = (int)(millisRemaining / 1000);
				updateTimerView(move1SecondsRemaining + move2SecondsRemaining);
			}

			@Override
			public void onFinish() {
				playChime();

				if (move2SecondsRemaining > 0) {
					showMove(move, true);
					runRestTimer();
				} else if (restSecondsRemaining > 0) {
					showMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					runRestTimer();
				} else {
					stepNum++;
					showStep();
				}
			}
		}.start();
	}

	private void runMove2Timer() {
		countDownTimer = new CountDownTimer(move2SecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				move2SecondsRemaining = (int)(millisRemaining / 1000);
				updateTimerView(move2SecondsRemaining);
			}

			@Override
			public void onFinish() {
				playChime();

				if (restSecondsRemaining > 0) {
					showMove(MoveLibrary.moves.get(MoveLibrary.REST), false);
					runRestTimer();
				} else {
					stepNum++;
					showStep();
				}
			}
		}.start();
	}

	private void runRestTimer() {
		countDownTimer = new CountDownTimer(restSecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				restSecondsRemaining = (int)(millisRemaining / 1000);
				updateTimerView(restSecondsRemaining);
			}

			@Override
			public void onFinish() {
				playChime();
				stepNum++;
				showStep();
			}
		}.start();
	}

	private void playChime() {
		ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);
		toneGenerator.startTone(AudioManager.STREAM_NOTIFICATION,100);
	}

	public void onNextClick(View v) {
		if (stepNum < routine.steps.size()) {
			if (countDownTimer != null) {
				countDownTimer.cancel();
			}
			stepNum++;
			showStep();
		}
	}

	public void onPrevClick(View v) {
		if (stepNum > 1) {
			if (countDownTimer != null) {
				countDownTimer.cancel();
			}
			stepNum--;
			showStep();
		}
	}
}
