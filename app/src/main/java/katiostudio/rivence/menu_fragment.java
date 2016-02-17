package katiostudio.rivence;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Kevin on 12/02/2016.
 */
public class menu_fragment extends Fragment implements View.OnClickListener  {
    public static int Catcontainer= R.id.bottom_bar;
    public static int Fragcontainer = R.id.content;

    public menu_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        final ImageButton menu4 = (ImageButton) rootView.findViewById(R.id.Menu4);
        final ImageButton menu1 = (ImageButton) rootView.findViewById(R.id.Menu1);

        menu4.setOnClickListener(this);
        menu1.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = main.fragmentManager.beginTransaction();

        switch (v.getId()) {

            case R.id.Menu1:
                Fragment services = new services_fragment();
                Fragment categories = new category_fragment();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in,0,0,
                        R.anim.fade_out);
                fragmentTransaction.replace(Fragcontainer, services);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,0,0,
                        R.anim.exit_to_right);
                fragmentTransaction.add(Catcontainer, categories);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                break;

            case R.id.Menu4:
                Fragment config = new config_fragment();

                fragmentTransaction = main.fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in,0,0,
                        R.anim.fade_out);
                fragmentTransaction.replace(Fragcontainer, config);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

                break;

        }
    }
}




