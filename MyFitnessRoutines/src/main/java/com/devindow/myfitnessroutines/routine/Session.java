package com.devindow.myfitnessroutines.routine;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Devin on 3/18/2018.
 */

@Entity(tableName = "sessions")
public class Session {

	// Private Fields
	@PrimaryKey(autoGenerate = true)
	private int uid;

	private Date date;

	@ColumnInfo(name = "routine_name")
	private String routineName;

	@ColumnInfo(name = "duration_seconds")
	private int durationSeconds;


	// Public Properties
	public int getUid() { return uid; }
	public void setUid(int val) { uid = val; }

	public Date getDate() { return date; }
	public void setDate(Date val) { date = val; }

	public String getRoutineName() { return routineName; }
	public void setRoutineName(String val) { routineName = val; }

	public int getDurationSeconds() { return durationSeconds; }
	public void setDurationSeconds(int val) { durationSeconds = val; }


	// Constructors
	public Session(String routineName, int durationSeconds) {
		date = new Date(System.currentTimeMillis());
		this.routineName = routineName;
		this.durationSeconds = durationSeconds;
	}

	public Session(int uid, Date date, String routineName, int durationSeconds) {
		this.uid = uid;
		this.date = date;
		this.routineName = routineName;
		this.durationSeconds = durationSeconds;
	}

}
