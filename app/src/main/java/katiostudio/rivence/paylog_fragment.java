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
public class paylog_fragment extends Fragment {

    public static int paylog_container= R.id.Paylog_Pane;
    public paylog_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.paylog_fragment, container, false);
        ScrollView Paylog_Pane = (ScrollView) rootView.findViewById(R.id.Paylog_Pane);


        FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();
        Fragment fitems =  new item_paylog_fragment();


        fragmentTransaction.replace(paylog_container, fitems);
/*        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out); */
        fragmentTransaction.commit();



        return rootView;
    }





    }

