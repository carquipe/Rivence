package katiostudio.rivence;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity {

    public static int Fragcontainer = R.id.content;
    final main main = this;

    private RelativeLayout drawer ;
    static DrawerLayout drawerLayout;
    private TextView titleText;
    static ImageView DrawerToggle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        DrawerToggle = (ImageView) findViewById(R.id.DrawerToggle);
        titleText = (TextView) findViewById(R.id.titletext);
        drawerLayout = (DrawerLayout)findViewById(R.id.Background);
        drawer = (RelativeLayout)findViewById(R.id.drawerPane);


        // Font path
        String fontPath = "fonts/Ailerons-Typeface.otf";
        // text view label
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        titleText.setTypeface(tf);

        Fragment menuFrag = new menu_fragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, menuFrag)
                .commit();
        Fragment chatFrag = new chat_fragment();
        fragmentManager.beginTransaction()
                .replace(R.id.drawerPane, chatFrag)
                .commit();


        DrawerToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);
                DrawerToggle.setVisibility(View.INVISIBLE);
            }

        });
        }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    }
