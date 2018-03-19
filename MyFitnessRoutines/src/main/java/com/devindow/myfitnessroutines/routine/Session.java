package com.devindow.myfitnessroutines.routine;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by Devin on 3/18/2018.
 */

@Entity(tableName = "sessions")
public class Session {

	// Private Fields
	@PrimaryKey(autoGenerate = true)
	private int uid;

	private long timestamp;

	@ColumnInfo(name = "routine_name")
	private String routineName;

	@ColumnInfo(name = "duration_seconds")
	private int durationSeconds;


	// Public Properties
	public int getUid() { return uid; }
	public void setUid(int val) { uid = val; }

	public long getTimestamp() { return timestamp; }
	public void setTimestamp(long val) { timestamp = val; }
	public Date getDate() { return new Date(timestamp); }

	public String getRoutineName() { return routineName; }
	public void setRoutineName(String val) { routineName = val; }

	public int getDurationSeconds() { return durationSeconds; }
	public void setDurationSeconds(int val) { durationSeconds = val; }


	// Constructors
	@Ignore
	public Session(String routineName, int durationSeconds) {
		timestamp = System.currentTimeMillis();
		this.routineName = routineName;
		this.durationSeconds = durationSeconds;
	}

	public Session(int uid, long timestamp, String routineName, int durationSeconds) {
		this.uid = uid;
		this.timestamp = timestamp;
		this.routineName = routineName;
		this.durationSeconds = durationSeconds;
	}


	// Overrides
	@Override
	public String toString() {
		return String.format("( uid=%d, routine=%s, duration=%d, date=%s )", uid, routineName, durationSeconds, getDate().toLocaleString());
	}
}
