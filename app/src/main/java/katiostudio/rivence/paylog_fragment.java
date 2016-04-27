package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
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
    protected List<Pago> mDataset;

    public static int Paylogcontainer= R.id.paylog_fragment_layout;



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



        return rootView;
    }




}

