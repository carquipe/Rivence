package katiostudio.rivence;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Locale;

import katiostudio.rivence.Controlador.Cliente;


public class menu_fragment extends Fragment implements View.OnClickListener {
    public static int Catcontainer = R.id.bottom_bar;
    public static int Fragcontainer = R.id.content;
    public EventCenter eventCenter;



    public menu_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);

        eventCenter = new EventCenter();

        final ImageButton menu1 = (ImageButton) rootView.findViewById(R.id.Menu1);
        final ImageButton menu2 = (ImageButton) rootView.findViewById(R.id.Menu2);
        final ImageButton menu3 = (ImageButton) rootView.findViewById(R.id.Menu3);
        final ImageButton menu4 = (ImageButton) rootView.findViewById(R.id.Menu4);


        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);

        return rootView;

    }


    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();



        switch (v.getId()) {

            case R.id.Menu1:
                Fragment services = new services_fragment();
                Fragment categories = new category_fragment();

                fragmentTransaction.setCustomAnimations(R.anim.fade_in,0,0,0);
                fragmentTransaction.replace(Fragcontainer, services, "servicesTAG");
                //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, 0, 0, 0);
                fragmentTransaction.add(Catcontainer, categories, "categoriesTAG");

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                eventCenter.submenuCreated();

                break;

            case R.id.Menu2:
                Fragment paylog = new paylog_fragment();

                fragmentTransaction.setCustomAnimations(R.anim.fade_in, 0, 0, 0);
                fragmentTransaction.replace(Fragcontainer, paylog);
                //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, 0, 0, 0);


                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                eventCenter.submenuCreated();

                break;

            case R.id.Menu3:
                Fragment nearyou = new nearyou_fragment();

                fragmentTransaction = main.fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in, 0, 0, 0);
                fragmentTransaction.replace(Fragcontainer, nearyou);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                eventCenter.submenuCreated();

                break;

            case R.id.Menu4:
                Fragment config = new config_fragment();

                fragmentTransaction = main.fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in, 0, 0, 0);
                fragmentTransaction.replace(Fragcontainer, config);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                eventCenter.submenuCreated();

                break;

        }
    }


}




