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
public class main extends Activity  {

    final static public  int x = R.id.content;
    final main main = this;
    private DrawerLayout drawerLayout;
    private ImageView DrawerToggle;
    private TextView titleText;
    private RelativeLayout drawer;
    private final  String FONTPATH = "fonts/Ailerons-Typeface.otf";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        DrawerToggle = (ImageView) findViewById(R.id.DrawerToggle);
        titleText = (TextView) findViewById(R.id.titletext);
        drawerLayout = (DrawerLayout) findViewById(R.id.Background);
        drawer = (RelativeLayout) findViewById(R.id.drawerPane);


        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), FONTPATH);
        // Applying font
        titleText.setTypeface(tf);

        //Creamos y mostramos el menu
        Fragment menuFragment = new menu_fragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, menuFragment)
                .commit();


        DrawerToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);
            }

        });






    }
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}