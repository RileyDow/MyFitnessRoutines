package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayRoutineActivity extends AppCompatActivity {

	// Private Fields
	private Routine routine;


	// Methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play_routine);

		Intent intent = getIntent();
		routine = (Routine)intent.getSerializableExtra("routine");

		TextView txtRoutineName = (TextView) findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.Name);

		ShowStep(0);
	}

	private void ShowStep(int num) {
		ImageView imgPose = (ImageView) findViewById(R.id.imgPose);
		Step step = routine.Steps.get(num);
		int w = imgPose.getWidth();
		int h = imgPose.getHeight();
		Bitmap bitmap = step.Pose.getBitmap();
		imgPose.setImageBitmap(bitmap);
	}
}
