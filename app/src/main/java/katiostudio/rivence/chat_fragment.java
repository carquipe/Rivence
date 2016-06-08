package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Kevin on 13/02/2016.
 */
public class chat_fragment extends Fragment implements View.OnClickListener {

    public chat_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chat_fragment, container, false);
        final ImageView closeBtn = (ImageView) rootView.findViewById(R.id.closebtn);

        closeBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.closebtn:
                main.drawerLayout.closeDrawer(GravityCompat.START);


                break;

        }
    }
}