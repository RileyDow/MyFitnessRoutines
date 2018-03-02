package com.devindow.myfitnessroutines;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.devindow.myfitnessroutines.routine.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	// Fields
	private ListView lstRoutines;


	// Overrides
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Toolbar
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);


		// MoveLibrary
		MoveLibrary.generateMoves();


		// btnNewRoutine
		FloatingActionButton btnNewRoutine = (FloatingActionButton) findViewById(R.id.btnNewRoutine);
		btnNewRoutine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Creating new Routines is coming soon.", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});


		// lstRoutines
		ArrayList<Routine> sampleRoutines = SampleRoutines.generateSampleRoutines();
		lstRoutines = findViewById(R.id.lstRoutines);
		RoutineAdapter adapter = new RoutineAdapter(this, R.layout.routine_row, sampleRoutines);
		lstRoutines.setAdapter(adapter);
		lstRoutines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Routine routine = (Routine)lstRoutines.getItemAtPosition(position);
				Intent intent = new Intent(view.getContext(), PlayRoutineActivity.class);
				intent.putExtra("routine", routine);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() { // becoming visible
		super.onStart();

	}

	@Override
	protected void onResume() { // becoming interactive
		super.onResume();

	}

	@Override
	protected void onPause() { // still visible
		super.onPause();

	}

	@Override
	protected void onStop() { // no longer visible
		super.onStop();

	}

	@Override
	protected void onRestart() { // restore from stopped
		super.onRestart();

	}

	@Override
	protected void onDestroy() { // ensure resources are freed before being destroyed
		super.onDestroy();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_tips) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

			final TextView textView = new TextView(this);
			textView.setText("Some Poses have a Left and a Right component.  The app will signal you to switch half way through.\n" +
					"\n" +
					"I like to:\n" +
					"- do \"Morning Yoga\" then \"Warmup\" then \"Pre-Activation\" before playing soccer\n" +
					"- go for a 3 mile walk where I stop in the middle at the park and do \"7 Minute Workout\" 1 or 2 times\n" +
					"\n" +
					"Sometimes I hit Play and follow the timer, sometimes I just use the Next button at my own pace.\n" +
					"(I recommend getting familiar with a Routine and its Poses before working with the timer.)");
			int padding = 30;
			textView.setPadding(padding, padding, padding, padding);
			alertDialogBuilder.setView(textView);

			alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
				}
			});

			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();

			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
