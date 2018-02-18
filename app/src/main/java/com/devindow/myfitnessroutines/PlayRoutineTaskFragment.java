package com.devindow.myfitnessroutines;

/**
 * Created by Devin on 2/18/2018.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

/**
 * This Fragment manages a single background task and retains
 * itself across configuration changes.
 */
public class PlayRoutineTaskFragment extends Fragment {

	/**
	 * Callback interface through which the fragment will report the
	 * task's progress and results back to the Activity.
	 */
	interface TaskCallbacks {
		void onPreExecute();
		void onProgressUpdate(int percent);
		void onCancelled();
		void onPostExecute();
	}

	private TaskCallbacks callbacks;
	private DummyTask task;

	/**
	 * Hold a reference to the parent Activity so we can report the
	 * task's current progress and results. The Android framework
	 * will pass us a reference to the newly created Activity after
	 * each configuration change.
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbacks = (TaskCallbacks)activity;
	}

	/**
	 * This method will only be called once when the retained
	 * Fragment is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Retain this fragment across configuration changes.
		setRetainInstance(true);

		// Create and execute the background task.
		task = new DummyTask();
		task.execute();
	}

	/**
	 * Set the callback to null so we don't accidentally leak the
	 * Activity instance.
	 */
	@Override
	public void onDetach() {
		super.onDetach();
		callbacks = null;
	}

	/**
	 * A dummy task that performs some (dumb) background work and
	 * proxies progress updates and results back to the Activity.
	 *
	 * Note that we need to check if the callbacks are null in each
	 * method in case they are invoked after the Activity's and
	 * Fragment's onDestroy() method have been called.
	 */
	private class DummyTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onPreExecute() {
			if (callbacks != null) {
				callbacks.onPreExecute();
			}
		}

		/**
		 * Note that we do NOT call the callback object's methods
		 * directly from the background thread, as this could result
		 * in a race condition.
		 */
		@Override
		protected Void doInBackground(Void... ignore) {
			for (int i = 0; !isCancelled() && i < 100; i++) {
				SystemClock.sleep(100);
				publishProgress(i);
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... percent) {
			if (callbacks != null) {
				callbacks.onProgressUpdate(percent[0]);
			}
		}

		@Override
		protected void onCancelled() {
			if (callbacks != null) {
				callbacks.onCancelled();
			}
		}

		@Override
		protected void onPostExecute(Void ignore) {
			if (callbacks != null) {
				callbacks.onPostExecute();
			}
		}
	}
}