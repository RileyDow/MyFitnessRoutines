package com.devindow.myfitnessroutines.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;

import com.devindow.myfitnessroutines.App;

/**
 * Created by Devin on 3/19/2018.
 */

public class MessageDialog {

	public static void show(Context context, String text) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		final TextView textView = new TextView(context);
		textView.setText(text);

		int padding = 30;
		textView.setPadding(padding, padding, padding, padding);
		alertDialogBuilder.setView(textView);

		alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
			}
		});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

}
