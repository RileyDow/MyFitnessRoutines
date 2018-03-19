package com.devindow.myfitnessroutines;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.devindow.myfitnessroutines.pose.MoveWithPose;
import com.devindow.myfitnessroutines.routine.*;
import com.devindow.myfitnessroutines.util.Debug;

import java.util.Locale;

public class PlayRoutineActivity extends OptionsMenuActivity implements PlayRoutineTaskFragment.PlayRoutineCallbacks {

	// Constants
	public static final String PLAY_ROUTINE_TASK_FRAGMENT = "PlayRoutineTaskFragment";


	// Private Fields
	private PlayRoutineTaskFragment taskFragment;
	private TextToSpeech speech;
	private boolean speechInitialized = false;
	private String textToSpeak;


	// Lifecycle Overrides
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_routine);

		speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			@Override
			public void onInit(int status) {
				Debug.d(Debug.TAG_ENTER, "TextToSpeech.onInit()");
				if (status != TextToSpeech.SUCCESS) {
					Debug.e(Debug.TAG_ERROR, "TTS Initialization Failed");
					return;
				}
				int result = speech.setLanguage(Locale.US);
				if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
					Debug.e(Debug.TAG_ERROR, "This Language is not supported");
				}
				speechInitialized = true;
				if (textToSpeak != null) {
					speech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);
					textToSpeak = null;
				}
				Debug.d(Debug.TAG_EXIT, "TextToSpeech.onInit()");
			}
		});

		// keep Screen ON
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		// If the Fragment is non-null, then it is currently being retained across a configuration change.
		FragmentManager fragmentManager = getFragmentManager();
		taskFragment = (PlayRoutineTaskFragment) fragmentManager.findFragmentByTag(PLAY_ROUTINE_TASK_FRAGMENT);
		if (taskFragment == null) {
			taskFragment = new PlayRoutineTaskFragment();
			fragmentManager.beginTransaction().add(taskFragment, PLAY_ROUTINE_TASK_FRAGMENT).commit();
		}

		// get Routine passed in by Intent
		Intent intent = getIntent();
		taskFragment.routine = (Routine)intent.getSerializableExtra("routine");

		// Routine Name in Title
		setTitle(taskFragment.routine.name);

		// show the current Task
		displayTask();

		// update btnPlay in case it is running
		updatePlayButton();

		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.onCreate()");
	}

	@Override protected void onDestroy() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onDestroy()");
		super.onDestroy();

		speech.shutdown();
	}


	// PlayRoutineCallbacks implementation
	@Override
	public void displayTask() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayTask()");

		clearInstructions();
		clearNextMoveName();

		displayInstructions();

		displayMove();

		updatePlayButton(); // taskFragment.next() might have reached DONE and paused it

		updateTimer(taskFragment.getSecondsRemaining());

		displayNextMoveName();

		displayTasksRemaining();

		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.displayTask()");
	}

	@Override
	public void displayMove() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayMove()");

		final TextView txtMoveName = findViewById(R.id.txtMoveName);
		final ImageView imgMove = findViewById(R.id.imgMove);

		if (taskFragment.move == null) {
			txtMoveName.setText("NULL");
			imgMove.setImageBitmap(Bitmap.createBitmap(MoveWithPose.BITMAP_PIXELS, MoveWithPose.BITMAP_PIXELS, Bitmap.Config.ARGB_8888));
		} else {
			Task currentTask = taskFragment.getCurrentTask();
			String moveName = taskFragment.move.name;
			boolean mirrored = false;
			if (taskFragment.move.twoSides) {
				if (currentTask.side.hasBoth()) {
					if (taskFragment.isSecondSide()) {
						moveName += " <-";
						mirrored = true;
					} else {
						moveName += " ->";
					}
				} else if (currentTask.side.hasRight()) {
					moveName += " ->";
				} else if (currentTask.side.hasLeft()) {
					moveName += " <-";
					mirrored = true;
				}
			}
			txtMoveName.setText(moveName);
			imgMove.setImageBitmap(taskFragment.move.getBitmap(mirrored));
		}
		Debug.d(Debug.TAG_EXIT, "PlayRoutineActivity.displayMove()");
	}

	@Override
	public void updateTimer(int secondsRemaining) { // pass in secondsRemaining because otherwise it would show Rest Time instead of 0 at the end of Move
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.updateTimer()");

		TextView txtTimer = findViewById(R.id.txtTimer);
		if (txtTimer != null) {
			String timeRemaining = String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60);
			Debug.d(Debug.TAG_TIME, timeRemaining);
			txtTimer.setText(timeRemaining);
		}
	}

	@Override
	public void clearInstructions() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.clearInstructions()");
		final TextView txtInstructions = findViewById(R.id.txtInstructions);
		if (txtInstructions != null) {
			txtInstructions.setText("");
		}
	}

	@Override
	public void speak(String moveName, String moveInstructions) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.speak()");

		if (Preferences.getSpeakMoveNames()) {
			String text = moveName;
			if (moveInstructions != null && Preferences.getSpeakMoveInstructions()) {
				text += ". " + moveInstructions;
			}

			if (speechInitialized) {
				speech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				textToSpeak = null;
			} else {
				textToSpeak = text;
			}
		}
	}


	// Private Methods
	private void displayInstructions() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayInstructions()");

		final TextView txtInstructions = findViewById(R.id.txtInstructions);
		if (txtInstructions != null) {
			txtInstructions.setText(taskFragment.getInstructions());
		}
	}

	private void clearNextMoveName() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.clearNextMoveName()");
		final TextView txtNextTask = findViewById(R.id.txtNextTask);
		if (txtNextTask != null) {
			txtNextTask.setText("");
		}
	}

	private void displayNextMoveName() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayNextMoveName()");

		final TextView txtNextTask = findViewById(R.id.txtNextTask);
		if (txtNextTask != null) {
			Task nextTask = taskFragment.getNextTask();
			if (nextTask == null) {
				txtNextTask.setText("");
			} else {
				txtNextTask.setText("Next: " + nextTask.moveName);
			}
		}
	}

	private void displayTasksRemaining() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.displayTasksRemaining()");

		final TextView txtRemaining = findViewById(R.id.txtRemaining);
		if (txtRemaining != null) {
			txtRemaining.setText(taskFragment.getTasksRemaining());
		}
	}

	private void updatePlayButton() {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.updatePlayButton()");

		ImageButton btnPlay = findViewById(R.id.btnPlay);

		if (taskFragment.isPaused()) {
			btnPlay.setImageResource(android.R.drawable.ic_media_play);
		} else {
			btnPlay.setImageResource(android.R.drawable.ic_media_pause);
		}
	}


	// Event Handlers
	public void onScreenClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onScreenClick()");

		if (!taskFragment.isPaused()) {
			taskFragment.pause();
		} else {
			taskFragment.next();
		}

		updatePlayButton();
	}

	public void onPlayClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPlayClick()");

		if (!taskFragment.isPaused()) {
			taskFragment.pause();
		} else {
			taskFragment.play();
		}

		updatePlayButton();
	}

	public void onNextClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onNextClick()");

		taskFragment.next();
	}

	public void onPrevClick(View v) {
		Debug.d(Debug.TAG_ENTER, "PlayRoutineActivity.onPrevClick()");

		taskFragment.prev();
	}

}
