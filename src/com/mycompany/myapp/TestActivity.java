package com.mycompany.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestActivity extends Activity {
    int idTheme = 0;
    String strAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        initValues(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdoOption1:
                if (checked){
                    if (strAnswer.contains("1")) {
                        alert.setMessage("Correcto!!");
                        alert.setIcon(R.drawable.ic_info_black_18dp);
                        alert.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            // aquí puedes añadir funciones
                            }
                        });
                        alert.show();
                    } else {
                        alert.setMessage("InCorrecto!!");
                        alert.show();
                    }
                }
                break;
            case R.id.rdoOption2:
                if (checked) {
                    if (strAnswer.contains("2")) {
                        alert.setMessage("Correcto!!");
                        alert.show();
                    } else {
                        alert.setMessage("InCorrecto!!");
                        alert.show();
                    }
                }
                break;
            case R.id.rdoOption3:
                if (checked) {
                    if (strAnswer.contains("3")) {
                        alert.setMessage("Correcto!!");
                        alert.show();
                    } else {
                        alert.setMessage("InCorrecto!!");
                        alert.show();
                    }
                }
                break;
        }
    }

    private void initValues(Bundle savedInstanceState){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (savedInstanceState == null) {
            if (bundle != null) {
                idTheme = Integer.parseInt(bundle.getString("idTheme"));
            }
        } else {
            String stridTheme = (String)savedInstanceState.getSerializable("idTheme");
            idTheme = Integer.parseInt(stridTheme);
        }
        setInitValues();
    }

    private void setInitValues(){
        StudiesDBHelper db = new StudiesDBHelper(TestActivity.this);
        Theme theme = db.readTheme(idTheme);
        TextView tvwTitle  = (TextView) findViewById(R.id.tvwTitle);
        tvwTitle.setText(theme.getQuestion());
        RadioButton rdoOption1 = (RadioButton) findViewById(R.id.rdoOption1);
        rdoOption1.setText(theme.getOPTION1());
        RadioButton rdoOption2 = (RadioButton) findViewById(R.id.rdoOption2);
        rdoOption2.setText(theme.getOPTION2());
        RadioButton rdoOption3 = (RadioButton) findViewById(R.id.rdoOption3);
        rdoOption3.setText(theme.getOPTION3());
        strAnswer = theme.getANSWER();
        db.close();
    }
}
