package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayRoutineActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play_routine);

		Intent intent = getIntent();
		Routine routine = (Routine)intent.getSerializableExtra("routine");

		TextView txtRoutineName = (TextView) findViewById(R.id.txtRoutineName);
		txtRoutineName.setText(routine.Name);
	}
}
