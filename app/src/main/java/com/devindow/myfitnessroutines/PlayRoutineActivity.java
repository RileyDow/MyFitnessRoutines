package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayRoutineActivity extends AppCompatActivity {

	// Private Fields
	private Routine routine;
	private int stepNum = 1;

	private CountDownTimer countDownTimer;
	private TextView txtTimer;
	long poseSecondsRemaining;
	long restSecondsRemaining;


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

		Pose pose;
		if (stepNum > routine.steps.size()) {
			pose = PoseLibrary.poses.get(PoseLibrary.DONE);
			countDownTimer = null;
		} else {
			Step currentStep = getCurrentStep();
			pose = currentStep.pose;
			poseSecondsRemaining = currentStep.poseDuration;
			restSecondsRemaining = currentStep.restDuration;
			updateTimerView(poseSecondsRemaining);
		}

		showPose(pose);

		// If timer was running then run.
		if (countDownTimer != null) {
			runPoseTimer();
		}
	}

	private void showPose(Pose pose) {
		// txtPoseName
		final TextView txtPoseName = findViewById(R.id.txtPoseName);
		txtPoseName.setText(pose.name);

		// imgPose
		final ImageView imgPose = findViewById(R.id.imgPose);
		imgPose.setImageBitmap(pose.getBitmap());
	}

	private void clearNextStep() {
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		txtNextStep.setText("");
	}

	private void showNextPoseName() {
		final TextView txtNextStep = findViewById(R.id.txtNextStep);
		Step nextStep = getNextStep();
		if (nextStep == null) {
			txtNextStep.setText("");
		} else {
			txtNextStep.setText("Next up: " + nextStep.pose.name);
		}
	}

	private void updateTimerView(long secondsRemaining) {
		txtTimer.setText(String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60));
	}

	public void onGoClick(View v) {
		if (countDownTimer != null) { // Pause Routine
			countDownTimer.cancel();
			countDownTimer = null;
			// Set btnGo image to Play
		} else { // Play Routine
			if (stepNum > routine.steps.size()) {
				stepNum = 1; // Restart ended Routine
				showStep();
			}
			// Set btnGo image to Pause

			if (poseSecondsRemaining > 0) {
				runPoseTimer();
			} else {
				runRestTimer();
			}
		}
	}

	private void runPoseTimer() {
		countDownTimer = new CountDownTimer(poseSecondsRemaining * 1000, 1000) {
			@Override
			public void onTick(long millisRemaining) {
				poseSecondsRemaining = millisRemaining / 1000;
				updateTimerView(poseSecondsRemaining);
			}

			@Override
			public void onFinish() {
				playChime();

				if (restSecondsRemaining > 0) {
					showPose(PoseLibrary.poses.get(PoseLibrary.REST));
					showNextPoseName();
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
				restSecondsRemaining = millisRemaining / 1000;
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
