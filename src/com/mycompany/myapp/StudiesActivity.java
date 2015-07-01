package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import junit.framework.*;

public class StudiesActivity extends Activity
{
	 ListView listView ;
	 @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studies);
		  // Get ListView object from xml
            listView = (ListView) findViewById(R.id.list);
            
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
    
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, android.R.id.text1, values);
    
    
            // Assign adapter to ListView
            listView.setAdapter(adapter); 
    }
	
}