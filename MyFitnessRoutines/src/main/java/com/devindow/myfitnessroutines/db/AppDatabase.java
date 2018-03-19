package com.devindow.myfitnessroutines.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.os.AsyncTask;

import com.devindow.myfitnessroutines.App;
import com.devindow.myfitnessroutines.routine.Session;

import java.util.List;

/**
 * Created by Devin on 3/17/2018.
 */

@Database(entities = {Session.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {

	// Static Fields
	public static AppDatabase instance;


	// Public Methods
	public abstract SessionDao sessionDao();

	public static void init() {
		instance = Room.databaseBuilder(App.getContext(), AppDatabase.class, "App.db").build();
	}


	// Static Methods
	public static void insertSession(Session session) {
		new InsertTask().execute(session);
	}

	private static class InsertTask extends AsyncTask<Session, Void, Void> {
		@Override
		protected Void doInBackground(Session... session) {
			instance.sessionDao().insert(session[0]);
			return null;
		}
	}


	public static List<Session> getSessionsInLast24HoursAsync() {
		long millisFrom24HoursAgo = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		return AppDatabase.instance.sessionDao().getAllSinceTimestamp(millisFrom24HoursAgo);
	}

}
