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

import java.util.ArrayList;
import java.util.List;

public class StudiesInteractionActivity extends Activity {
    int themePosition = 0;
    int MaxStudiesItem = 0;
    int idStudy = 0;
    int idTheme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studiesinteraction);
        initValues(savedInstanceState);
        WebView wbwStudie  = (WebView) findViewById(R.id.wvwStudiesInteraction);
        wbwStudie.getSettings().setJavaScriptEnabled(true);
        String html_data = getNextHTMLContent();
        if (html_data.length() == 0) {
            html_data = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"><title>Lorem Ipsum</title></head><body style=\"width:300px; color: #00000; \"><p><strong> About us</strong> </p><p><strong> ID STUDY:" + Integer.toString(idStudy) + "</strong> is simply dummy text .</p><p><strong> Lorem Ipsum</strong> is simply dummy text </p><p><strong> Lorem Ipsum</strong> is simply dummy text </p></body></html>";
        }
        wbwStudie.loadData(html_data, "text/html", "UTF-8");
    }
    private void initValues(Bundle savedInstanceState){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (savedInstanceState == null) {
            if (bundle != null) {
                idStudy = Integer.parseInt(bundle.getString("id"));
            }
        } else {
            String stridStudy = (String)savedInstanceState.getSerializable("id");
            idStudy = Integer.parseInt(stridStudy);
        }
    }
    private String getNextHTMLContent() {
        String HTMLContent ="";
        StudiesDBHelper db = new StudiesDBHelper(StudiesInteractionActivity.this);
        List<Theme> themes = db.getAllThemesByStudy(idStudy);
        if (MaxStudiesItem == 0) {
            MaxStudiesItem = themes.size();
        }
        if ((themePosition <= MaxStudiesItem-1) && (themes.size() > 0) ){
            idTheme = themes.get(themePosition).getIdTheme();
            HTMLContent = themes.get(themePosition).getHTMLContent();
            themePosition++;
        }
        db.close();
        return HTMLContent;
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
            WebView wbwStudie  = (WebView) findViewById(R.id.wvwStudiesInteraction);
            wbwStudie.loadData(getNextHTMLContent(),"text/html", "UTF-8");
            //Intent act = new Intent(this, TestActivity.class);
            //startActivity(act);
        } catch (Exception e) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Error: " + e.getMessage() );
            alert.show();
        }
    }

    public void onClickBtnTest (View v){
        try {
            Intent testactivity = new Intent(this, TestActivity.class);
            testactivity.putExtra("idTheme", String.valueOf(idTheme));
            startActivity(testactivity);
        } catch (Exception e) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Error: " + e.getMessage() );
            alert.show();
        }
    }
}

