package com.devindow.myfitnessroutines;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Fields
    private ListView lstRoutines;


    // Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // PoseLibrary
        PoseLibrary.generatePoses();


        // btnNewRoutine
        FloatingActionButton btnNewRoutine = (FloatingActionButton) findViewById(R.id.btnNewRoutine);
        btnNewRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create Routine", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // lstRoutines
        lstRoutines = (ListView) findViewById(R.id.lstRoutines);
        ArrayAdapter<Routine> arrayAdapter = new ArrayAdapter<Routine>(this, R.layout.routine_row, Samples.getSampleRoutines());
        lstRoutines.setAdapter(arrayAdapter);
        lstRoutines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Routine routine = (Routine)lstRoutines.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), PlayRoutineActivity.class);
                intent.putExtra("routine", routine);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() { // becoming visible
        super.onStart();

    }

    @Override
    protected void onResume() { // becoming interactive
        super.onResume();

    }

    @Override
    protected void onPause() { // still visible
        super.onPause();

    }

    @Override
    protected void onStop() { // no longer visible
        super.onStop();

    }

    @Override
    protected void onRestart() { // restore from stopped
        super.onRestart();

    }

    @Override
    protected void onDestroy() { // ensure resources are freed before being destroyed
        super.onDestroy();

    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
