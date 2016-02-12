package katiostudio.rivence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//Custom Font
import android.widget.TextView;
import android.graphics.Typeface;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity {


    final main main = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Font path
        String fontPath = "fonts/Ailerons-Typeface.otf";

        // text view label
        TextView titleText = (TextView) findViewById(R.id.titleText);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        titleText.setTypeface(tf);

        final ImageButton Services = (ImageButton) findViewById(R.id.Menu1);

        Services.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {

                    Intent intent = new Intent();
                    intent.setClass(main, services.class);

                    startActivity(intent);
                }

            });
        }


    }
