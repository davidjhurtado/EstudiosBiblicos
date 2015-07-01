package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class RegisterActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
       try {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	    
    }
	
}
