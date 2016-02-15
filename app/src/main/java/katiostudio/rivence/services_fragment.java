package katiostudio.rivence;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Kevin on 13/02/2016.
 */
public class services_fragment extends Fragment {
    public static int Catcontainer= R.id.bottom_bar;
    public static int Servicescontainer= R.id.ServicesPane;
    public services_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.services_fragment, container, false);
        LinearLayout ServicesPane = (LinearLayout) rootView.findViewById(R.id.ServicesPane);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment categories = new category_fragment();
        Fragment items =  new item_service_fragment();


        fragmentTransaction.replace(Servicescontainer, items);
        fragmentTransaction.replace(Catcontainer, categories);

        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);
        fragmentTransaction.commit();

        Populate(ServicesPane);

        return rootView;
    }


    private void Populate(LinearLayout Layout){

        for (int i =0; i<4;i++){
            


        }




    }

}