package katiostudio.rivence;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import katiostudio.rivence.Controlador.PaylogFilterCards;
import katiostudio.rivence.Controlador.PaylogAdapter;
import katiostudio.rivence.Controlador.Pago;
import java.util.List;

/**
 * Created by Kevin on 13/02/2016.
 */
public class paylog_fragment extends Fragment {


    private static final String TAG = "RecyclerViewFragment";


    protected RecyclerView mRecyclerView;
    protected PaylogAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Pago> mDataset;protected PaylogFilterCards filterCards;
    int isActive = 1;




    public paylog_fragment() {
        // Empty constructor required for fragment subclasses
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iniciacion de los datos en Objeto Servicio con la Lista
        Pago pay = new Pago();
        pay.initializeData();
        mDataset = pay.pagos;
    }


    public void unpressButton(TextView all, TextView paid, TextView pending){
        switch(isActive){
            case 1:
                GradientDrawable allBackground = (GradientDrawable) all.getBackground();
                allBackground.setColor(getResources().getColor(R.color.paylog_notpressed));
                break;
            case 2:
                paid.setBackgroundColor(getResources().getColor(R.color.paylog_notpressed));
                break;
            case 3:
                GradientDrawable pendingBackground = (GradientDrawable) pending.getBackground();
                pendingBackground.setColor(getResources().getColor(R.color.paylog_notpressed));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //inicializacion RecyclerView
        View rootView = inflater.inflate(R.layout.paylog_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.paylog_fragment_layout);
        mRecyclerView.setHasFixedSize(true);

        //Utilizamos LinearLayout para darle forma de lista vertical.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Creamos el adaptador
        mAdapter = new PaylogAdapter(mDataset);
        // Asignacion de adaptador al del Recycler View
        mRecyclerView.setAdapter(mAdapter);

        //Filtro de menús
        final TextView paid = (TextView) rootView.findViewById(R.id.paidButton);
        final TextView pending = (TextView) rootView.findViewById(R.id.pendingButton);
        final TextView all = (TextView) rootView.findViewById(R.id.allButton);
        filterCards = new PaylogFilterCards(mAdapter.getList());




            //ACCIONES ONCLICK BOTONES MENU
        pending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                //Change color to pressed
                GradientDrawable pendingBackground = (GradientDrawable) pending.getBackground();
                pendingBackground.setColor(getResources().getColor(R.color.paylog_pressed));

                //UnpressButton Routine
                unpressButton(all,paid,pending);
                isActive=3;

                //Update CardView
                mAdapter.setList(filterCards.performFilteringPending());
                mAdapter.notifyDataSetChanged();
            }
        });

        paid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                //Change color to pressed
                paid.setBackgroundColor(getResources().getColor(R.color.paylog_pressed));

                //UnpressButton Routine
                unpressButton(all,paid,pending);
                isActive=2;

                //Update CardView
                mAdapter.setList(filterCards.performFilteringPaid());
                mAdapter.notifyDataSetChanged();
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                //Change color to pressed
                GradientDrawable allBackground = (GradientDrawable) all.getBackground();
                allBackground.setColor(getResources().getColor(R.color.paylog_pressed));

                //UnpressButton Routine
                unpressButton(all,paid,pending);
                isActive=1;

                //Update CardView
                mAdapter.setList(filterCards.performFilteringAll());
                mAdapter.notifyDataSetChanged();
            }
        });



        return rootView;
    }




}

