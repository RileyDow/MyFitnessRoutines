package com.devindow.myfitnessroutines;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.devindow.myfitnessroutines.routine.Routine;

import java.util.ArrayList;

/**
 * Created by Devin on 2/21/2018.
 */

public class RoutineAdapter extends ArrayAdapter<Routine> {

	// Private Fields
	private Context context;
	private int resource;


	// Constructor
	public RoutineAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Routine> routines) {
		super(context, resource, routines);
		this.context = context;
		this.resource = resource;
	}


	// ArrayAdapter implementation
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		Routine routine = getItem(position);

		LayoutInflater inflater = LayoutInflater.from(context);
		convertView = inflater.inflate(resource, parent, false);

		TextView txtName = convertView.findViewById(R.id.txtName);
		txtName.setText(routine.name);

		TextView txtDuration = convertView.findViewById(R.id.txtDuration);
		txtDuration.setText(routine.getTotalMinutesString());

		TextView txtDescription = convertView.findViewById(R.id.txtDescription);
		txtDescription.setText(routine.description);

		return convertView;
	}

}
