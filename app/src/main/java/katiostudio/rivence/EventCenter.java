package katiostudio.rivence;


import android.app.FragmentTransaction;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;

/**
 * Created by cquinz on 10/5/16.
 */
public class EventCenter {


    FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();

    public EventCenter() {
        //Empty Constructor
    }


    /* Botón Back Top Side */
    public void submenuCreated() {
        main.backicon.setVisibility(View.VISIBLE);
    }

    public void submenuDeleted() {
        main.backicon.setVisibility(View.INVISIBLE);
    }


}
