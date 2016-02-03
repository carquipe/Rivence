package katiostudio.rivence;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class SplashScreenActivity extends Activity {

    /**
     * The thread to process splash screen events
     */


    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private boolean Splashoff = false;
    private ProgressBar spinner;
    final SplashScreenActivity sPlashScreen = this;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        final RelativeLayout background = (RelativeLayout) findViewById(R.id.background);
        background.setBackgroundResource(DinamicBackground.getBackOnTime());

    }

    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(sPlashScreen, Login.class);
                sPlashScreen.startActivity(mainIntent);
                sPlashScreen.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        }

    }

