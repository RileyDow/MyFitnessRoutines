package com.devindow.myfitnessroutines;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Devin on 3/17/2018.
 */

public class OptionsMenuActivity extends AppCompatActivity {

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

		switch (id) {

			case R.id.action_speakMoveNames: {
				if (Preferences.getSpeakMoveNames(this)) {
					item.setChecked(false);
					Preferences.setSpeakMoveNames(this, false);
				} else {
					item.setChecked(true);
					Preferences.setSpeakMoveNames(this, true);
				}

				return true;
			}

			case R.id.action_speakMoveInstructions: {
				if (Preferences.getSpeakMoveInstructions(this)) {
					item.setChecked(false);
					Preferences.setSpeakMoveInstructions(this, false);
				} else {
					item.setChecked(true);
					Preferences.setSpeakMoveInstructions(this, true);
				}

				return true;
			}

			case R.id.action_tips: {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

				final TextView textView = new TextView(this);
				textView.setText("Some Poses have a Left and a Right component.  The app will signal you to switch half way through.\n" +
						"\n" +
						"I like to:\n" +
						"- do \"Morning Yoga\" then \"Warmup\" then \"Pre-Activation\" before playing soccer.\n" +
						"- go for a 3 mile walk where I stop in the middle at the park and do \"7 Minute Workout\" 1 or 2 times.\n" +
						"\n" +
						"Sometimes I hit Play and follow the timer, sometimes I just use the >> button to progress at my own pace.\n" +
						"(I recommend first getting familiar with a routine and its poses before working with the timer.)\n" +
						"\n" +
						"Tapping the screen while playing will pause.  Tapping while paused will manually advance to the next move.");
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

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem mnuSpeakNames = menu.findItem(R.id.action_speakMoveNames);
		MenuItem mnuSpeakInstructions = menu.findItem(R.id.action_speakMoveInstructions);

		if (Preferences.getSpeakMoveNames(this)) {
			mnuSpeakNames.setChecked(true);
			mnuSpeakInstructions.setEnabled(true);
		} else {
			mnuSpeakNames.setChecked(false);
			mnuSpeakInstructions.setEnabled(false);
		}

		mnuSpeakInstructions.setChecked(Preferences.getSpeakMoveInstructions(this));

		return true;
	}

}
