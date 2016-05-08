package katiostudio.rivence;

import android.app.Fragment;
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
        TextView paid = (TextView) rootView.findViewById(R.id.paidButton);
        TextView pending = (TextView) rootView.findViewById(R.id.pendingButton);
        TextView all = (TextView) rootView.findViewById(R.id.allButton);
        filterCards = new PaylogFilterCards(mAdapter.getList());


            //ACCIONES ONCLICK BOTONES MENU
        pending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                mAdapter.setList(filterCards.performFilteringPending());
                mAdapter.notifyDataSetChanged();
            }
        });

        paid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                mAdapter.setList(filterCards.performFilteringPaid());
                mAdapter.notifyDataSetChanged();
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                mAdapter.setList(filterCards.performFilteringAll());
                mAdapter.notifyDataSetChanged();
            }
        });



        return rootView;
    }




}

