package com.mycompany.myapp;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

public class StudiesActivity extends Activity
{
	 ListView listView ;
	 @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studies);
		// Get ListView object from xml
        listView = (ListView) findViewById(R.id.lstStudies);
        // Defined Array values to show in ListView
        String[] values = new String[] { "Estudio 1",
                                             "Estudio 2",
                                             "Estudio 3",
                                             "Estudio 4",
                                             "Estudio 5"
                                            };

	 // Define a new Adapter
            // First parameter - Context
            // Second parameter - Layout for the row
            // Third parameter - ID of the TextView to which the data is written
            // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.studiesitem, values);
        // Assign adapter to ListView
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item " + listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                Intent activity = new Intent(StudiesActivity.this, StudiesInteractionActivity.class);
                startActivity(activity);

            }
        });

    }

}