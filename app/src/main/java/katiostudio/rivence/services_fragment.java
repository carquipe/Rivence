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
public class services_fragment extends Fragment {

    public static int Servicescontainer= R.id.ServicesPane;
    public services_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.services_fragment, container, false);
        ScrollView ServicesPane = (ScrollView) rootView.findViewById(R.id.ServicesPane);



        FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();
        Fragment items =  new item_service_fragment();
        fragmentTransaction.replace(Servicescontainer, items);
        /*fragmentTransaction.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);*/

        fragmentTransaction.commit();



        return rootView;
    }





    }

