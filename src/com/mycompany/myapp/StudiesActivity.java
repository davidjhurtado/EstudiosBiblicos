package com.mycompany.myapp;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import android.app.ListActivity;
import java.util.List;

public  class StudiesActivity extends Activity
{
	 ListView listView ;
	 @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studies);
		// Get ListView object from xml
        listView = (ListView) findViewById(R.id.lstStudies);
        StudiesDBHelper db = new StudiesDBHelper(StudiesActivity.this);
        List<Study> studies = db.getAllStudies();
        List<String> listTitle = new ArrayList();
        for (int index =0; index < studies.size(); index++){
            listTitle.add(index,studies.get(index).getTitle());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.studiesitem, listTitle);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item " + listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                StudiesDBHelper db = new StudiesDBHelper(StudiesActivity.this);
                Study study = db.readStudyByTitlte(listView.getItemAtPosition(position).toString());
                Intent activity = new Intent(StudiesActivity.this, StudiesInteractionActivity.class);
                activity.putExtra("id",String.valueOf(study.getIdStudy()));
                startActivity(activity);

            }
        });
        db.close();
    }

}