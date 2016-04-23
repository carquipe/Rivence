package katiostudio.rivence;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by Kevin on 13/02/2016.
 */
public class nearyou_fragment extends Fragment {

    public static int Nearyou_container= R.id.Nearyou_Pane;
    public nearyou_fragment() {
        // Constructor vacio para los fragmentos subclases
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.nearyou_fragment, container, false);
        ScrollView Nearyou_Pane = (ScrollView) rootView.findViewById(R.id.Nearyou_Pane);


        FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();
        Fragment fitems =  new item_nearyou_fragment();
        fragmentTransaction.replace(Nearyou_container, fitems);
/*        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out); */

        fragmentTransaction.commit();

        return rootView;
    }





    }

