package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kevin on 15/02/2016.
 */
public class item_nearyou_fragment extends Fragment {
    private int radius = 20;
    public item_nearyou_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_nearyou, container, false);


        return rootView;
    }

}