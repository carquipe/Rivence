package katiostudio.rivence;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import katiostudio.rivence.Controlador.EventAdapter;
import katiostudio.rivence.Controlador.Evento;
import java.util.List;

/**
 * Created by Kevin on 13/02/2016.
 */
public class nearyou_fragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";

    protected RecyclerView mRecyclerView;
    protected EventAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Evento> mDataset;

    public static int Nearyoucontainer= R.id.nearyou_fragment_layout;



    public nearyou_fragment() {
        // Constructor vacio para los fragmentos subclases
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iniciacion de los datos en Objeto Servicio con la Lista
        Evento even = new Evento();
        even.initializeData();
        mDataset = even.eventos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //inicializacion RecyclerView
        View rootView = inflater.inflate(R.layout.nearyou_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.nearyou_fragment_layout);
        mRecyclerView.setHasFixedSize(true);

        //Utilizamos LinearLayout para darle forma de lista vertical.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Creamos el adaptador
        mAdapter = new EventAdapter(mDataset);
        // Asignacion de adaptador al del Recycler View
        mRecyclerView.setAdapter(mAdapter);



        return rootView;
    }

}

