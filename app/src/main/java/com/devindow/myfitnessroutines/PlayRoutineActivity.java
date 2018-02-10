package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayRoutineActivity extends AppCompatActivity {

	// Private Fields
	private Routine routine;
	private int stepNum = 1;

	private TextView txtTimer;
	private int secondsRemaining;
	private long startTime = 0;

	// Runs without a timer by reposting this handler at the end of the runnable
	Handler timerHandler = new Handler();
	Runnable timerRunnable = new Runnable() {
		@Override
		public void run() {
			long millis = System.currentTimeMillis() - startTime;
			int secondsElapsed = (int) (millis / 1000);
			int secondsRemaining =
			int minutesRemaining = seconds / 60;
			seconds = seconds % 60;

			txtTimer.setText(String.format("%d:%02d", minutes, seconds));

			timerHandler.postDelayed(this, 500);
		}
	};

	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play_routine);

		Intent intent = getIntent();
		routine = (Routine)intent.getSerializableExtra("routine");

		// txtRoutineName
		final TextView txtRoutineName = findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.Name);

		// txtTimer
		txtTimer = findViewById(R.id.txtTimer);

		ShowStep();
	}

	private void ShowStep() {
		Step step = routine.Steps.get(stepNum-1);

		// txtPoseName
		final TextView txtPoseName = findViewById(R.id.txtPoseName);
		txtPoseName.setText(step.Pose.Name);

		// imgPose
		final ImageView imgPose = findViewById(R.id.imgPose);
		int w = imgPose.getWidth();
		int h = imgPose.getHeight();
		Bitmap bitmap = step.Pose.getBitmap();
		imgPose.setImageBitmap(bitmap);

		// secondsRemaining
		secondsRemaining = step.Duration;
	}

	public void onGoClick(View v) {
		// Toggle Play/Pause button image

		if (startTime == 0) {
			startTime = System.currentTimeMillis();
			timerHandler.postDelayed(timerRunnable, 0);
		}
		else {
			timerHandler.removeCallbacks(timerRunnable);
			startTime = 0;
		}
	}

	public void onNextClick(View v) {
		if (stepNum < routine.Steps.size()) {
			stepNum++;
			ShowStep();
		}
	}

	public void onPrevClick(View v) {
		if (stepNum > 1) {
			stepNum--;
			ShowStep();
		}
	}
}
