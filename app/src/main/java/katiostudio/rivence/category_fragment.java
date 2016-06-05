package katiostudio.rivence;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
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

    CategoryListener activityListener;

    public category_fragment() {
        // Empty constructor required for fragment subclasses
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_fragment, container, false);

        //Filtro de menús
        final ImageView cat1 = (ImageView) rootView.findViewById(R.id.cat1);
        final ImageView cat2 = (ImageView) rootView.findViewById(R.id.cat2);
        final ImageView cat3 = (ImageView) rootView.findViewById(R.id.cat3);
        final ImageView cat4 = (ImageView) rootView.findViewById(R.id.cat4);
        final ImageView cat5 = (ImageView) rootView.findViewById(R.id.cat5);

/*        //SET COLOR CATEGORIAS
        GradientDrawable pendingBackground = (GradientDrawable) cat1.getBackground();
        pendingBackground.setColor(getResources().getColor(R.color.paylog_pressed)); */


        //ACCIONES ONCLICK BOTONES MENU
        cat1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Update CardView
                activityListener.categoryClicked(1);
                // services_fragment.updateCat1();
            }
        });
        cat2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Update CardView
                activityListener.categoryClicked(2);
                //services_fragment.updateCat2();
            }
        });
        cat3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Update CardView
                activityListener.categoryClicked(3);
                //services_fragment.updateCat3();
            }
        });
        cat4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Update CardView
                activityListener.categoryClicked(4);
                //services_fragment.updateCat4();
            }
        });
        cat5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Update CardView
                activityListener.categoryClicked(5);
                //services_fragment.updateCat5();
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

}

