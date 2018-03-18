package com.devindow.myfitnessroutines.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.devindow.myfitnessroutines.App;

/**
 * Created by Devin on 3/17/2018.
 */

public abstract class Database extends RoomDatabase {

	private static Database instance;

	public static void init() {
		//instance = Room.databaseBuilder(App.getContext(), Database.class, "App.db").build();
		int i=0;
	}
}
