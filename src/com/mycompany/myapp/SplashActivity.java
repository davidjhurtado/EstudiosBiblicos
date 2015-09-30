package com.mycompany.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {
    public static final int segundos = 8;
    public static final int milisegundos = segundos * 1000;
    public ProgressBar pgbSplash;
    private static final int delay = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        pgbSplash= (ProgressBar) findViewById(R.id.pgbSplash);
        pgbSplash.setMax(maxAvance());
        startAnimation();
    }

    private void startAnimation() {
        new CountDownTimer(milisegundos, 1000){
            @Override
            public void onTick(long millisUnitFinished){
                pgbSplash.setProgress(progressAvance(millisUnitFinished));
            }

            @Override
            public void onFinish() {
                Intent activity = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(activity);
            }

        }.start();
        createDatabase();
    }

    private int progressAvance(long milliseconds){
        return (int) ((milisegundos-milliseconds)/1000);
    }

    private int maxAvance(){
        return segundos - delay;
    }

    private void createDatabase(){
        StudiesDBHelper db = new StudiesDBHelper(SplashActivity.this);
        db.onUpgrade(db.getWritableDatabase(), 0,1);
        CreateContent content = new  CreateContent();
        content.insertContent(SplashActivity.this);
    }
}
