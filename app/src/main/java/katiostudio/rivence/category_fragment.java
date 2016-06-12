package katiostudio.rivence;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.app.Activity;
import android.widget.TextView;

import katiostudio.rivence.Controlador.PaylogFilterCards;
import katiostudio.rivence.Interfaces.CategoryListener;


public class category_fragment extends Fragment {

    /* Definicion de variables globales */
    CategoryListener activityListener;
    private int isActive;
    public category_fragment() {
        // Empty constructor required for fragment subclasses
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_fragment, container, false);

        //Filtro de menús
        final ImageView cat0 = (ImageView) rootView.findViewById(R.id.cat0);
        final ImageView cat1 = (ImageView) rootView.findViewById(R.id.cat1);
        final ImageView cat2 = (ImageView) rootView.findViewById(R.id.cat2);
        final ImageView cat3 = (ImageView) rootView.findViewById(R.id.cat3);
        final ImageView cat4 = (ImageView) rootView.findViewById(R.id.cat4);
        final ImageView cat5 = (ImageView) rootView.findViewById(R.id.cat5);



        //ACCIONES ONCLICK BOTONES MENU
        cat0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 0;
                //Change color to pressed
                cat0.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(0);
            }
                                });
        cat1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 1;

                //Change color to pressed
                cat1.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(1);
            }
        });
        cat2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 2;

                //Change color to pressed
                cat2.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(2);
                //services_fragment.updateCat2();
            }
        });
        cat3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 3;

                //Change color to pressed
                cat3.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(3);
            }
        });
        cat4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 4;

                //Change color to pressed
                cat4.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(4);
            }
        });
        cat5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Unpress before category
                unpressButton(cat0,cat1,cat2,cat3,cat4,cat5);
                isActive = 5;

                //Change color to pressed
                cat5.setBackgroundResource(R.drawable.category_pressed2);

                //Update CardView
                activityListener.categoryClicked(5);
            }
        });


        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            activityListener = (CategoryListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement CategoryListener");
        }
    }

    //Cambio de color del botón deseleccionado
    public void unpressButton(ImageView cat0, ImageView cat1, ImageView cat2, ImageView cat3, ImageView cat4, ImageView cat5 ) {
        switch (isActive) {
            case 0:
                cat0.setBackgroundResource(R.drawable.category_button);
                break;
            case 1:
                cat1.setBackgroundResource(R.drawable.category_button);
                break;
            case 2:
                cat2.setBackgroundResource(R.drawable.category_button);
                break;
            case 3:
                cat3.setBackgroundResource(R.drawable.category_button);
                break;
            case 4:
                cat4.setBackgroundResource(R.drawable.category_button);
                break;
            case 5:
                cat5.setBackgroundResource(R.drawable.category_button);
                break;

        }
    }
}

