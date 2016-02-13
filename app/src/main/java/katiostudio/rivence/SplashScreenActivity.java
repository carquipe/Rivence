package katiostudio.rivence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.rahatarmanahmed.cpv.CircularProgressView;

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
        background.setBackgroundResource(DinamicBackground.getBackOnTime("splash"));
        CircularProgressView progressView = (CircularProgressView) findViewById(R.id.progress_view);
        progressView.startAnimation();

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

