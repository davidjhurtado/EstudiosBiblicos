package com.mycompany.myapp;

/**
 * Created by David on 29/07/2015.
 */


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class StudiesInteractionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studiesinteraction);
        WebView wbwStudie  = (WebView) findViewById(R.id.wvwStudiesInteraction);
        wbwStudie.getSettings().setJavaScriptEnabled(true);
        String html_data = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"><title>Lorem Ipsum</title></head><body style=\"width:300px; color: #00000; \"><p><strong> About us</strong> </p><p><strong> Lorem Ipsum</strong> is simply dummy text .</p><p><strong> Lorem Ipsum</strong> is simply dummy text </p><p><strong> Lorem Ipsum</strong> is simply dummy text </p></body></html>";
        wbwStudie.loadData(html_data,"text/html", "UTF-8");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_studies_interaction, menu);
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

    public void onClickBtnNextStr (View v){
        try {
            Intent act = new Intent(this, TestActivity.class);
            startActivity(act);
        } catch (Exception e) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Error: " + e.getMessage() );
            alert.show();
        }
    }
}

