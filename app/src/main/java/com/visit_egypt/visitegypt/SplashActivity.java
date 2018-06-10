package com.visit_egypt.visitegypt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.visit_egypt.visitegypt.utils.MyContextWrapper;
import com.visit_egypt.visitegypt.utils.VisitEgyptApplication;

import java.util.Locale;

/**
 * Created by Muhammad on 1/5/2017
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale languageType = VisitEgyptApplication.getInstance().getLocale();
        super.attachBaseContext(MyContextWrapper.wrap(newBase, languageType));
    }
}
