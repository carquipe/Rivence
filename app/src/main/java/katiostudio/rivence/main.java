package katiostudio.rivence;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    boolean closed = true;
    public static int Fragcontainer = R.id.content;
    public static FragmentManager fragmentManager;
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
        drawerLayout.setBackgroundResource(DinamicBackground.getBackOnTime("main"));

        // Font path
        String fontPath = "fonts/Ailerons-Typeface.otf";
        // text view label
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        titleText.setTypeface(tf);


        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment menuFrag = new menu_fragment();
        Fragment chatFrag = new chat_fragment();

        fragmentTransaction.add(R.id.content,menuFrag);
        fragmentTransaction.add(R.id.drawerPane, chatFrag);


        fragmentTransaction.commit();
        drawerLayout.setDrawerListener(myDrawerListener);
        DrawerToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);

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
    DrawerLayout.DrawerListener myDrawerListener = new DrawerLayout.DrawerListener(){

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            
        }

        @Override
        public void onDrawerStateChanged(int newState) {


            if (newState == DrawerLayout.STATE_SETTLING) {
                if (closed) {
                    DrawerToggle.setVisibility(View.INVISIBLE);
                    closed = false;

                }else{
                    DrawerToggle.setVisibility(View.VISIBLE);
                    closed = true;
                }
            }


        }};

}

