package com.devindow.myfitnessroutines;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.devindow.myfitnessroutines.db.AppDatabase;
import com.devindow.myfitnessroutines.routine.*;
import com.devindow.myfitnessroutines.util.MessageDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OptionsMenuActivity {

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
				Routine routine = (Routine) lstRoutines.getItemAtPosition(position);
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
	protected void onResume() { // becoming interactive or returning from another Activity
		super.onResume();

		new GetSessions().execute(this);
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


	// GetSessions class
	private class GetSessions extends AsyncTask<Context, Void, Void> {

		private Context context;
		private List<Session> sessions;

		@Override
		protected Void doInBackground(Context... context) {
			this.context = context[0];
			sessions = AppDatabase.instance.sessionDao().getAll();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			MessageDialog.show(context, sessions.toString());
			//lstRoutines
		}

	}

}
