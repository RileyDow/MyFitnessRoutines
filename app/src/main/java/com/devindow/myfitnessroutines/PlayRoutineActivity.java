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

		// txtRoutineName
		TextView txtRoutineName = (TextView) findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.Name);

		ShowStep(0);
	}

	private void ShowStep(int num) {
		Step step = routine.Steps.get(num);

		// txtPoseName
		TextView txtPoseName = (TextView) findViewById(R.id.txtPoseName);
		txtPoseName.setText(step.Pose.Name);

		// imgPose
		ImageView imgPose = (ImageView) findViewById(R.id.imgPose);
		int w = imgPose.getWidth();
		int h = imgPose.getHeight();
		Bitmap bitmap = step.Pose.getBitmap();
		imgPose.setImageBitmap(bitmap);
	}
}
