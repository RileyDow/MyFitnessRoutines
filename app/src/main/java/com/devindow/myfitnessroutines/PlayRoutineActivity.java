package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayRoutineActivity extends AppCompatActivity {

	// Private Fields
	private Routine routine;
	private int stepNum = 0;


	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play_routine);

		Intent intent = getIntent();
		routine = (Routine)intent.getSerializableExtra("routine");

		// txtRoutineName
		final TextView txtRoutineName = (TextView) findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.Name);

		ShowStep();
	}

	private void ShowStep() {
		Step step = routine.Steps.get(stepNum);

		// txtPoseName
		final TextView txtPoseName = (TextView) findViewById(R.id.txtPoseName);
		txtPoseName.setText(step.Pose.Name);

		// imgPose
		final ImageView imgPose = (ImageView) findViewById(R.id.imgPose);
		int w = imgPose.getWidth();
		int h = imgPose.getHeight();
		Bitmap bitmap = step.Pose.getBitmap();
		imgPose.setImageBitmap(bitmap);
	}

	public void onGoClick(View v) {
	}

	public void onNextClick(View v) {
		if (stepNum < routine.Steps.size()) {
			stepNum++;
			ShowStep();
		}
	}

	public void onPrevClick(View v) {
		if (stepNum > 0) {
			stepNum--;
			ShowStep();
		}
	}
}
