package com.devindow.myfitnessroutines.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;

import com.devindow.myfitnessroutines.App;
import com.devindow.myfitnessroutines.routine.Session;

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

}
