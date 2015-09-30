package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.util.List;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button myButton = (Button) findViewById(R.id.myButton);
		Button txtvregister = (Button) findViewById(R.id.txtvRegister);
        StudiesDBHelper db = new StudiesDBHelper(this);
        List users = db.getAllUsers();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if (users.size() > 0){
            alert.setMessage("Size list: " + String.valueOf( users.size()) );
            alert.show();
        } else {
            alert.setMessage("Size Cero : " + String.valueOf( users.size()) );
            alert.show();
        };
    }

	public void onClickBtnfblogin (View v) { 
	TextView test;
	 Intent act = new Intent(this, RegisterActivity.class);
	
	 try{
	 startActivity(act);
	 } catch (Exception e){
		 test = (TextView) findViewById(R.id.test);
		 test.setText(e.toString());
		 //System.out.println(e.toString());
	 }
	}
	public void  onClicktxtvRegister (View v) { 
		TextView test;
		Intent act = new Intent(this, RegisterActivity.class);

		try{
			startActivity(act);
		} catch (Exception e){
			test = (TextView) findViewById(R.id.test);
			test.setText(e.toString());
			//System.out.println(e.toString());
		}
	}
	
	public void  onClickBtnStudies (View v) { 
		TextView test;
		Intent act = new Intent(this, StudiesActivity.class);

		try{
			startActivity(act);
		} catch (Exception e){
			test = (TextView) findViewById(R.id.test);
			test.setText(e.toString());
			//System.out.println(e.toString());
		}
	}

	public void  onClickBtnStudiesInteraction (View v) {
		TextView test;
		Intent act = new Intent(this, StudiesInteractionActivity.class);

		try{
			startActivity(act);
		} catch (Exception e){
			test = (TextView) findViewById(R.id.test);
			test.setText(e.toString());
			//System.out.println(e.toString());
		}
	}
}
