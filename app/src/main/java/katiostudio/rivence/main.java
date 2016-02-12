package katiostudio.rivence;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity {


    final main main = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ImageView DrawerToggle = (ImageView) findViewById(R.id.DrawerToggle);
        final TextView titleText = (TextView) findViewById(R.id.titletext);
        final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.Background);
        final RelativeLayout drawer = (RelativeLayout)findViewById(R.id.drawerPane);


        // Font path
        String fontPath = "fonts/Ailerons-Typeface.otf";
        // text view label
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        titleText.setTypeface(tf);

        Fragment fragment = new menu_fragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();


        DrawerToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);
            }

        });
        }


    }
