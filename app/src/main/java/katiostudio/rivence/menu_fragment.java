package katiostudio.rivence;

import android.app.Fragment;
import android.app.FragmentContainer;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import static katiostudio.rivence.main.Fragcontainer;

/**
 * Created by Kevin on 12/02/2016.
 */
public class menu_fragment extends Fragment implements View.OnClickListener  {

    public static int Fragcontainer = R.id.content;

    public menu_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        final ImageButton menu4 = (ImageButton) rootView.findViewById(R.id.Menu4);

        menu4.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.Menu4:
                Fragment fragment = new config_fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(Fragcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in,
                        android.R.animator.fade_out);
                fragmentTransaction.commit();

                break;

        }
    }
}




