package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import katiostudio.rivence.Controlador.RVAdapter;
import katiostudio.rivence.Controlador.Servicio;
import java.util.List;



public class services_fragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";

    protected RecyclerView mRecyclerView;
    protected RVAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Servicio> mDataset;

    public static int Servicescontainer= R.id.services_fragment_layout;

    public services_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iniciacion de los datos en Objeto Servicio con la Lista
        Servicio serv = new Servicio();
        serv.initializeData();
        mDataset = serv.servicios;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context thiscontext;


        //inicializacion RecyclerView
        View rootView = inflater.inflate(R.layout.services_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.services_fragment_layout);
        mRecyclerView.setHasFixedSize(true);

        //Utilizamos LinearLayout para darle forma de lista vertical.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Creamos el adaptador
        mAdapter = new RVAdapter(mDataset);
        // Asignacion de adaptador al del Recycler View
        mRecyclerView.setAdapter(mAdapter);



        return rootView;
    }





    }

